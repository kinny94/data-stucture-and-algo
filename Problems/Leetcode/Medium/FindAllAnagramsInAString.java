import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        
        int matched = 0;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (char ch: p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
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
                result.add(windowStart);
            }
            
            if (i >= p.length() - 1) {
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
        
        return result;
    }
}