class NumberOfDiceRolls {

    private final static int MASK = 1000000007;

    public int numRollsToTarget(int d, int f, int target) {
        if (target > f * d) {
            return 0;
        }
        
        int[][] dp = new int[d+1][target + 1];
        dp[0][0] = 1;

        for (int i=1; i<=d; i++) {
            for (int j=1; j<=target; j++) {
                for (int k=1; k<=Math.min(j, f); k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % MASK;
                }
            }
        }

        return dp[d][target];
    }
}