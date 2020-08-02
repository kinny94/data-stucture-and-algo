class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            searchPair(nums, -nums[i], i+1, result);
        }
        
        return result;
    }
    
    private void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> result) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                result.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                
                while (left<right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (targetSum > currentSum) {
                left++;
            } else {
                right--;
            }
        }
    }
}