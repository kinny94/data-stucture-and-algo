class TargetSum {
    // recurrsive
    public int findTargetSumWays(int[] nums, int S) {
        return findWays(nums, 0, S);
    }
    
    public int findWays(int[] nums, int start, int S) {
        int n = nums.length;
        if (start >= nums.length) {
            return S == 0 ? 1 : 0;
        }
        return findWays(nums, start + 1, S - nums[start]) + findWays(nums, start + 1, S + nums[start]);
    }

    // dp
    public int findTargetSubsets(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}