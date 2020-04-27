import java.util.Arrays;

class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i=2; i<=n; i++) {
            for (int j=1; j<=2; j++) {
                dp[i] = dp[i] + dp[i-j];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }

    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairs(2));
    }
}