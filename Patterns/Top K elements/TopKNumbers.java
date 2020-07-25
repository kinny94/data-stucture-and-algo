import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class TopKNumbers {
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
        for (int i=0; i<k; i++) {
            heap.add(nums[i]);
        }

        for (int i=k; i<nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }

        return new ArrayList<>(heap);
    }    

    public static void main(String[] args) {
        List<Integer> result = TopKNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = TopKNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}