class RodCutting {
    public int solveRodCutting(int[] lengths, int[] prices, int n) {
        if (n<=0 || prices.length == 0 || prices.length != lengths.length) {
            return 0;
        }

        int lengthCount = lengths.length;
        int[][] dp = new int[lengthCount][n+1];

        for (int i=0; i<lengthCount; i++) {
            dp[i][0] = 0;
        }

        for (int i=0; i<lengthCount; i++) {
            for (int j=1; j<=n; j++) {
                int profit1 = 0;
                int profit2 = 0;

                if (j >= lengths[i]) {
                    profit1 = prices[i] + dp[i][j - lengths[i]];
                }

                if (i > 0) {
                    profit2 = dp[i-1][j];
                }

                dp[i][j] = Math.max(profit1, profit2);
            }
        }

        return dp[lengthCount - 1][n];
    }   

    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }
}