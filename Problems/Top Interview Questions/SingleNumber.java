class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if(e.getValue() == 1) return e.getKey();
        }
        return -1;
    }
}