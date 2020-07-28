import java.util.Arrays;

class CoinChange {
    public int countChangeMaxWays(int[] denominations, int total) {
        int n = denominations.length;
        int[][] dp = new int[n][total + 1];

        for (int i=0; i<n; i++) {
            dp[i][0] = 1;
        }

        for (int i=0; i<n; i++) {
            for (int j=1; j<=total; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i-1][j];
                }

                if (j >= denominations[i]) {
                    dp[i][j] = dp[i][j] + dp[i][j - denominations[i]];
                }
            }
        }

        return dp[n-1][total];
    }

    public int countChangeMinWays(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin: coins) {
            for (int i=coin; i<=amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }  

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChangeMaxWays(denominations, 5));
        System.out.println(cc.countChangeMinWays(denominations, 5));
    }
}