import java.util.HashMap;
import java.util.Map;

class PermutationInAStirng {

    public boolean findPermutation(String s, String pattern) {
        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c: pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i=0; i<s.length(); i++) {
            char rightChar = s.charAt(i);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == map.size()) {
                return true;
            }

            if (i >= pattern.length() - 1) {
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

        return false;
    }

    public static void main(String[] args) {
        PermutationInAStirng obj = new PermutationInAStirng();
        System.out.println("Permutation exist: " + obj.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + obj.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + obj.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + obj.findPermutation("aaacb", "abc"));
    }
}