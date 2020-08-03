class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        
        for (int currentNum: nums) {
            int n = subsets.size();
            for (int i=0; i<n; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNum);
                subsets.add(set);
            }
        }
        
        return subsets;
    }
}