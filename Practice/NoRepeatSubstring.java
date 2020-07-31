import java.util.HashMap;
import java.util.Map;

class NoRepeatSubstring {
    public int maxLength(String s)  {
        int windowStart = 0;
        int maxLength = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char rightChar = s.charAt(i);

            if (map.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, map.get(rightChar));
            }

            map.put(rightChar, i);
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }

        return maxLength;
    }
}