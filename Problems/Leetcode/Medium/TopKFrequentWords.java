class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s: words){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = 
                         new PriorityQueue<>((a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());
        
        for(Map.Entry<String, Integer> entry: map.entrySet()){
             maxHeap.offer(entry);
            if(maxHeap.size()>k) {
                maxHeap.poll();   
            }
        }
        
        List<String> res = new ArrayList<>();
       while(!maxHeap.isEmpty())
            res.add(0, maxHeap.poll().getKey());
        
        return res;
    }
}