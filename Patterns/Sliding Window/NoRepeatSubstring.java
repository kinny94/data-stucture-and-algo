import java.util.HashMap;
import java.util.Map;

class NoRepeatSubstring {
    public int maxLength(String s) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char right = s.charAt(i);

            if (map.containsKey(right)) {
                windowStart = Math.max(windowStart, map.get(right) + 1);
            }

            map.put(right, i);
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        NoRepeatSubstring obj = new NoRepeatSubstring();
        System.out.println("Length of the longest substring: " + obj.maxLength("aabccbb"));
        System.out.println("Length of the longest substring: " + obj.maxLength("abbbb"));
        System.out.println("Length of the longest substring: " + obj.maxLength("abccde"));
    }
}