class UnboundKnapsack {
    
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {

        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }

        int[][] dp = new int[profits.length][capacity + 1];

        for (int i=0; i<profits.length; i++) {
            dp[i][0] = 0;
        }

        for (int i=0; i<profits.length; i++) {
            for (int j=1; j<=capacity; j++) {
                int profit1 = 0;
                int profit2 = 0;

                if (j >= weights[i]) {
                    profit1 = profits[i] + dp[i][j - weights[i]];
                }

                if (i > 0) {
                    profit2 = dp[i-1][j];
                }

                dp[i][j] = profit1 > profit2 ? profit1 : profit2;
            }
        }
        

        return dp[profits.length-1][capacity];
    }

    public static void main(String[] args) {
        UnboundKnapsack ks = new UnboundKnapsack();
        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        System.out.println(ks.solveKnapsack(profits, weights, 8));
        System.out.println(ks.solveKnapsack(profits, weights, 6));
    }
}