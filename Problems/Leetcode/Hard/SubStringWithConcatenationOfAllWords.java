import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubStringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        
        List<Integer> resultIndices = new ArrayList<>();
        
        if (s == "" || words.length == 0) {
            return resultIndices;
        }
        
        int wordsCount = words.length;
        int wordLength = words[0].length();
        
        for (int i=0; i<=s.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            
            for (int j=0; j<wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                String word = s.substring(nextWordIndex, nextWordIndex + wordLength);
                
                if (!map.containsKey(word)) {
                    break;
                }
                
                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);
                
                if (wordsSeen.get(word) > map.getOrDefault(word, 0)) {
                    break;
                }
                
                if (j + 1 == wordsCount) {
                    resultIndices.add(i);
                }
                
            }
        }
        
        return resultIndices;
        
    }
}