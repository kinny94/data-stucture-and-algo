import java.util.HashSet;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharacters {
    
    public int lengthOfLongestSubsString(String s) {
        int aPointer = 0;
        int bPointer = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (bPointer < s.length()) {
            if (!set.contains(s.charAt(bPointer))) {
                set.add(s.charAt(bPointer));
                bPointer++;
                max = Math.max(set.size(), max);
            } else {
                set.remove(s.charAt(aPointer));
                aPointer++;
            }
        }

        return max;
    }
}