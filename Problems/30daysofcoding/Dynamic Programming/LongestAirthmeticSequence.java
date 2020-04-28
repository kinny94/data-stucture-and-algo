import java.util.HashMap;

class LongestAirthmeticSequence {
    public int longestArithSeqLength(int[] A) {
        int n = A.length, res = 0;
        int[][] dp = new int[n][n];
        int[] index = new int[20001];
        Arrays.fill(index,-1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prev = A[i] - (A[j] - A[i]);
                if (prev < 0 || index[prev] == -1) continue;
                dp[i][j] = dp[index[prev]][i] + 1;
                res = Math.max(res, dp[i][j]);
            }
            index[A[i]] = i;
        }
        return res + 2;
    }
}