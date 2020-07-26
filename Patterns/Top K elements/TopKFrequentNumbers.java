import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentNumbers {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> topNumbers = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }

        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}