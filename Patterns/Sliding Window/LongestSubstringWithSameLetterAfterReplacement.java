import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithSameLetterAfterReplacement {
    public int maxLength(String s, int k) {
        int maxLength = 0;
        int windowStart = 0;
        int maxRepeatingCount = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char rightChar = s.charAt(i);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            maxRepeatingCount = Math.max(maxRepeatingCount, map.get(rightChar));

            if (i - windowStart + 1 - maxRepeatingCount > k) {
                // shrink the window
                char leftChar = s.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, i - windowStart + 1);
        }

        return maxLength;
    }    

    public static void main(String[] args) {
        LongestSubstringWithSameLetterAfterReplacement obj = new LongestSubstringWithSameLetterAfterReplacement();
        System.out.println(obj.maxLength("aabccbb", 2));
        System.out.println(obj.maxLength("abbcb", 1));
        System.out.println(obj.maxLength("abccde", 1));
    }
}