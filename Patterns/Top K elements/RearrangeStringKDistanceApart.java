import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class RearrangeStringKDistanceApart {
    public static String reorganizeString(String str, int k) {
        if (k <= 1) {
            return str;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch: str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder(str.length());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> curEntry = maxHeap.poll();
            sb.append(curEntry.getKey());
            curEntry.setValue(curEntry.getValue() - 1);
            queue.offer(curEntry);

            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0) {
                    maxHeap.add(entry);
                }
            }
        }

        return sb.toString().length() == str.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " + 
              RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " + 
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " + 
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " + 
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}