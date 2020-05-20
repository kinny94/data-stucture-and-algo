class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 1; i <= nums.length; i++) {
            result += i-nums[i-1];
        }
        return result;
    }
}