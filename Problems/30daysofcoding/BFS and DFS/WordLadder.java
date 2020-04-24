import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        Set<String> seen = new HashSet<>();
        seen.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 0;

        while(!queue.isEmpty()) {
            int level = queue.size();
            step++;

            for (int i=1; i<=level; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return step;
                }

                for (int j=0; j<word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c<'z';c++) {
                        if (chars[j] == c) {
                            continue;
                        }
                        chars[j] = c;
                        String newWord = String.valueOf(chars);
                        if (wordDict.contains(newWord) && !seen.contains(newWord)) {
                            seen.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder obj =  new WordLadder();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(obj.ladderLength("hit", "cog", wordList));
    }
}