class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            
            String sortedString = String.valueOf(arr);
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(strs[i]);
            } else {
                List<String> items = new ArrayList<>();
                items.add(strs[i]);
                map.put(sortedString, items);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String,List<String>>  entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
        
    }
}