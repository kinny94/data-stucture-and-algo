import java.util.HashMap;
import java.util.Map;

class LongestSubStringWithKDistinctCharacters {
    
    public int findLongestSubString(String s, int k) {

        if (s == null || s.length() == 0 || s.length() < k) {
            return 0;
        }

        int windowStart = 0;
        int maxLength = 0;
        int count = 0;

        Map<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            char rightChar = s.charAt(i);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.size() > k) {
                char leftChar = s.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                windowStart++;
            }
            count++;
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }

        System.out.println(count);
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubStringWithKDistinctCharacters obj = new LongestSubStringWithKDistinctCharacters();
        System.out.println(obj.findLongestSubString("arraci", 2));
        System.out.println("Length of the longest substring: " + obj.findLongestSubString("araaci", 1));
        System.out.println("Length of the longest substring: " + obj.findLongestSubString("cbbebi", 3));
        System.out.println("Length of the longest substring: " + obj.findLongestSubString("aabeefegeeccrr", 3));
    }
}