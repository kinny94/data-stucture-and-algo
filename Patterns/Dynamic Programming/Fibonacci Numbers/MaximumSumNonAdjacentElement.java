class MaximumSumNonAdjacentElement {
    public int maxSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i=1; i<nums.length; i++) {
            dp[i+1] = Math.max(dp[i-1] + nums[i], dp[i]);
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {
        MaximumSumNonAdjacentElement obj = new MaximumSumNonAdjacentElement();
        System.out.println(obj.maxSum(new int[]{5, 20, 15, -2, 18}));
    }
 }