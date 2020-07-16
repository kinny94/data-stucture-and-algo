import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StringAnagrams {
    public List<Integer> findAnagram(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c: pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<>();

        for (int i=0; i<str.length(); i++) {
            char rightChar = str.charAt(i);

            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == map.size()) {
                resultIndices.add(windowStart);
            }

            if (i >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }

                    map.put(leftChar, map.get(leftChar) + 1);
                }
                windowStart++;
            }

        }

        return resultIndices;
    }    

    public static void main(String[] args) {
        StringAnagrams obj = new StringAnagrams();
        System.out.println(obj.findAnagram("ppqp", "pq"));
        System.out.println(obj.findAnagram("abbcabc", "abc"));
    }
}