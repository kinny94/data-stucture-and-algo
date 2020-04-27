import java.util.*;

class MinimumFallingSum {
    
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        
        int[][] dp = new int[n][m];
        dp[0][0] = A[0][0];
        
        for (int j=1; j<m; j++) {
            dp[0][j] = A[0][j];
        } 
        
        for (int i=1; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (j == 0) {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                } else if (j == m - 1){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                } else {
                    dp[i][j] = A[i][j] + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int j=0; j<m; j++) {
            min = Math.min(min, dp[n-1][j]);
        }
        return min;
    }
    
    public void print2D(int mat[][]) { 
        for (int[] row : mat) 
        System.out.println(Arrays.toString(row)); 
    } 
    
    
    public static void main(String[] args) {
        MinimumFallingSum obj = new MinimumFallingSum();
        int[][] a = {{-80, -13, 22}, {83, 94, -5}, {73, -48, 61}};
        System.out.println(obj.minFallingPathSum(a));
    }
}