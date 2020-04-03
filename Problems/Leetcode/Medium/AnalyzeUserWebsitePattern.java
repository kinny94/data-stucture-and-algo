class AnalyzeUserWebsitePattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
       int n = timestamp.length;
       //1. Sort sessions list by time, can not use map ,because web will be duplicated
       List<List<String>> sessions =  new ArrayList<>();
       for (int i = 0; i < n; i++){
           sessions.add(new ArrayList<>());
           sessions.get(i).add(username[i]);
           sessions.get(i).add(""+timestamp[i]);
           sessions.get(i).add(website[i]);
       }
       sessions.sort((a, b)-> Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1)));
       
       //2. add each person visited list;
       Map<String, List<String>> visited = new HashMap<>();//(name, list<web>)
       for (int i = 0; i < n; i++){
           visited.putIfAbsent(sessions.get(i).get(0), new ArrayList<>());
           visited.get(sessions.get(i).get(0)).add(sessions.get(i).get(2));
       }
       
       //3. find each user list and build all 3-subsequences and count by map, and get maxCount;
       Map<String, Integer> sequence = new HashMap<>();//(sequence, count)
       int maxCount = 0;
       String maxseq = "";
       for (String name : visited.keySet()){
           List<String> list = visited.get(name);
           if(list.size() < 3) continue;
           //build users' all 3-sequences, use set in case duplicated 3-sequences
           Set<String> subseqences = subseqence(list);
           for (String seq : subseqences){
               sequence.put(seq, sequence.getOrDefault(seq, 0)+1);
               if(sequence.get(seq) > maxCount){
                   maxCount = sequence.get(seq);
                   maxseq = seq;
               }
               else if (sequence.get(seq) == maxCount && seq.compareTo(maxseq) < 0) maxseq = seq;
           }
       }
       String[] strs = maxseq.split(",");
       List<String> res = new ArrayList<>();
       for (String s : strs) res.add(s);
       return res;
   }
   
   public Set<String> subseqence(List<String> list){
       int n = list.size();
       Set<String> res = new HashSet<>();
       for (int i = 0; i < n-2; i++){
           for (int j = i+1; j < n-1; j++){
               for (int k = j+1; k < n; k++){
                   res.add(list.get(i)+","+list.get(j)+","+list.get(k));
               }
           }
       }
       return res;
   }
}