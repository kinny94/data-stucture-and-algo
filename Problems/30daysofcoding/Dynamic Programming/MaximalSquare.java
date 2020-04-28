import java,util.*;

class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (a.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int result = 0;

        int[][] dp = new int[n+1][m+1];

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]) + 1;
                    result = Math.max(dp[i][j], result);
                }
            }
        } 

        System.out.println(Arrays.deepToString(dp));

        return result * result;
    }
}