import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak2 {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        return wordBreak(s, set, 0);
    }
    
    HashMap<Integer, List<String>> map = new HashMap<>();
    
    private List<String> wordBreak(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        
        List<String> result = new ArrayList<>();
        if (start == s.length()) {
            result.add("");
        }
        
        for (int i=start + 1; i<=s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))){
                List<String> list = wordBreak(s, wordDict, i);
                for(String l: list) {
                    result.add(s.substring(start, i) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        
        map.put(start, result);
        return result;
    }
}