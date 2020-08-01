class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int windowStart = 0;
        int maxRepeatingCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            char rightChar = s.charAt(i);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            maxRepeatingCount = Math.max(maxRepeatingCount, map.get(rightChar));
            
            if (i - windowStart + 1 - maxRepeatingCount > k) {
                char leftchar = s.charAt(windowStart);
                map.put(leftchar, map.get(leftchar) - 1);
                windowStart++;
            }
            
            maxLength = Math.max(maxLength, i - windowStart + 1);
        }
        
        return maxLength;
    }
}