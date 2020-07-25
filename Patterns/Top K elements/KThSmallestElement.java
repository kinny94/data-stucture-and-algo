import java.util.PriorityQueue;

class KThSmallestElement {
    public static int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i=0; i<k; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i=k; i<nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.peek();
    }   

    public static void main(String[] args) {
        int result = KThSmallestElement.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);
    
        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KThSmallestElement.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);
    
        result = KThSmallestElement.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result); 
    }
}