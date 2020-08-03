class Node {
    int elementIndex;
    int arrayIndex;
    
    Node(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = 
            new PriorityQueue<>((n1, n2) -> matrix[n1.arrayIndex][n1.elementIndex] - matrix[n2.arrayIndex][n2.elementIndex]);
        
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i] != null) {
                minHeap.add(new Node(0, i));
            }
        }
        
        int numberCount = 0;
        int result = 0;
        
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = matrix[node.arrayIndex][node.elementIndex];
            if (++numberCount == k) {
                break;
            }
            
            node.elementIndex++;
            if (matrix[node.arrayIndex].length > node.elementIndex) {
                minHeap.add(node);
            }
        }
        
        return result;
    }
}