import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class MaximumDistinctElements {
    public static int findMaximumDistinctElements(int[] nums, int k) {
        int distinctElementCount = 0;
        if (nums.length <= k) {
            return distinctElementCount;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i,  map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                distinctElementCount++;
            } else {
                minHeap.add(entry);
            }
        }

        while (k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            k -= entry.getValue() - 1;
            if (k >= 0) {
                distinctElementCount++;
            }
        }

        if (k>0) {
            distinctElementCount -= k;
        }

        return distinctElementCount;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}