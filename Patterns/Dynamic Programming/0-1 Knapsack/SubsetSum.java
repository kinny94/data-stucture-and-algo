class SubsetSum {
    public boolean canPartition(int[] num, int sum) {
        boolean[][] dp = new boolean[num.length][sum +1];

        for (int i=0; i<num.length; i++) {
            dp[i][0] = true;
        }

        for (int i=1; i<=sum; i++) {
            dp[0][i] = num[0] == i ? true : false;
        }

        for (int i=1; i<num.length; i++) {
            for (int j=1; j<=sum; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = dp[i-1][j];
                } else if (j >= num[i]) {
                    dp[i][j] = dp[i-1][j - num[i]];
                }
            }
        }

        return dp[num.length - 1][sum];
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }
}