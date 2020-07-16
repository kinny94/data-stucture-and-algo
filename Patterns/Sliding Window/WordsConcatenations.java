import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordsConcatenations {
    public List<Integer> findIndices(String s,  String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<>();
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

    public static void main(String[] args) {
        WordsConcatenations obj = new WordsConcatenations();
        List<Integer> result = obj.findIndices("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = obj.findIndices("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}