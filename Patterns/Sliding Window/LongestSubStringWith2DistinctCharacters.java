import java.util.HashMap;
import java.util.Map;

class LongestSubStringWith2DistinctCharacters {
    public int maxLength(String s) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char right = s.charAt(i);
            map.put(right,  map.getOrDefault(right, 0) + 1);

            while (map.size() > 2) {
                char left = s.charAt(windowStart);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, i - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubStringWith2DistinctCharacters obj = new LongestSubStringWith2DistinctCharacters();
        System.out.println(obj.maxLength("eceba"));
    }
}