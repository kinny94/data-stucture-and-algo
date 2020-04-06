class WordLadder {
    //TC: O(MN)
    //SC: O(MN)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict=new HashSet<>(wordList);
        Set<String> seen=new HashSet<>();
        seen.add(beginWord);
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        int step = 0;
        while (!q.isEmpty()){
            int level = q.size();
            step++;
            for(int i=1;i<=level;i++){
                String word = q.poll();
                if(word.equals(endWord))
                return step;
                for(int j=0;j<word.length();j++){
                    char chars[]= word.toCharArray();
                    for(char c = 'a';c<='z';c++){
                        if(chars[j] == c) continue;
                        chars[j] = c;
                        String newWord = String.valueOf(chars);
                        if(wordDict.contains(newWord) && !seen.contains(newWord)){
                            seen.add(newWord);
                            q.offer(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
    
}