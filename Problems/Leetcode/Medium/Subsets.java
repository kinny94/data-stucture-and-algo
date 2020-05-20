class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        createSubsets(results, new ArrayList<>(), 0, nums);
        return results;
    }
    
    private void createSubsets(List<List<Integer>> results, List<Integer> currentList, int index, int[] nums) {

        results.add(new ArrayList<>(currentList));

        for (int i=index; i<nums.length; i++) {
            currentList.add(nums[i]);
            createSubsets(results, currentList, i + 1, nums);
            currentList.remove(currentList.size() - 1);
        }
    }
}