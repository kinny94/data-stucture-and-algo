class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
    // split paragraph 
    String[] words = paragraph.toLowerCase().split("\\W+");
    
    // add banned words to set
    Set<String> set = new HashSet<>();
    for(String word : banned){
        set.add(word);
    }
    
    // add paragraph words to hash map
    Map<String, Integer> map = new HashMap<>();
    for(String word : words){
        if(!set.contains(word)){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }
        
    // get the most frequent word
    int max = 0; // max frequency
    String res = "";
    for(String str : map.keySet()){
        if(map.get(str) > max){
            max = map.get(str);
            res = str;
        }
    }
    
    return res;
}
}