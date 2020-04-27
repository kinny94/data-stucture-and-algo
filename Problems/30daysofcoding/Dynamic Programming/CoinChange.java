import java.util.Arrays;

class CoinChange {

    public int coinChange(int[] coins, int amount) {
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

        System.out.println(Arrays.toString(dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] a = {1, 2, 5};
        cc.coinChange(a, 11);
    }
}