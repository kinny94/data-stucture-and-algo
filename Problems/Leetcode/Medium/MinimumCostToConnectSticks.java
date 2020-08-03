class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i=0; i<sticks.length; i++) {
            minHeap.add(sticks[i]);
        }
        
        int result = 0;
        int temp = 0;
        
        while (minHeap.size() > 1) {
            temp = minHeap.poll() + minHeap.poll();
            result += temp;
            minHeap.add(temp);
        }
        
        return result;
    }
}