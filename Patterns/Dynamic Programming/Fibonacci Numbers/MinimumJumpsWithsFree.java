class MinimumJumpsWithsFree {

    // for 3 steps
    public int findMinFee(int[] fee) {
        int dp[] = new int[fee.length + 1]; 
        dp[0] = 0; // no steps no fee
        dp[1] = fee[0];
        dp[2] = dp[3] = fee[0];

        for (int i=3; i<fee.length; i++) {
            dp[i+1] = Math.min(fee[i] + dp[i], Math.min(fee[i-1] + dp[i-1], fee[i-2] + dp[i-2]));
        }
        return dp[fee.length];
    }

    // for 2 steps 
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2; i<cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
    
    public static void main(String[] args) {
        MinimumJumpsWithsFree sc = new MinimumJumpsWithsFree();
        int[] fee = { 1, 2, 5, 2, 1, 2 };
        System.out.println(sc.findMinFee(fee));
        fee = new int[] { 2, 3, 4, 5 };
        System.out.println(sc.findMinFee(fee));
    }
}