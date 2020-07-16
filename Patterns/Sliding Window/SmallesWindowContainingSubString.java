import java.util.HashMap;
import java.util.Map;

class SmallesWindowContainingSubString {
    public String findSmallestSubString(String s, String pattern) {
        int windowStart = 0;
        int matched = 0;
        int minLength = s.length() + 1;
        int subStringStart = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c: pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i=0; i<s.length(); i++) {
            char rightChar = s.charAt(i);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);

                if (map.get(rightChar) >= 0) {
                    matched++;
                }
            }

            while (matched == pattern.length()) {
                if (minLength > i - windowStart + 1) {
                    minLength = i - windowStart + 1;
                    subStringStart = windowStart;
                } 

                char leftChar = s.charAt(windowStart);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }

                    map.put(leftChar, map.get(leftChar) + 1);
                }
                windowStart++;
            }
        }

        return minLength > s.length() ? "" : s.substring(subStringStart, subStringStart + minLength);
    }    

    public static void main(String[] args) {
        SmallesWindowContainingSubString obj = new SmallesWindowContainingSubString();
        System.out.println(obj.findSmallestSubString("aabdec", "abc"));
        System.out.println(obj.findSmallestSubString("abdabca", "abc"));
        System.out.println(obj.findSmallestSubString("adcad", "abc"));
    }
}