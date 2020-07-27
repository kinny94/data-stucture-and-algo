class EqualSubSetSumParition {
    public boolean canPartition(int[] num) {
        int n = num.length;
        int sum = 0;

        for (int i=0; i<n; i++) {
            sum += num[i];
        }

        // if 'sum' is a an odd number, we can't have two subsets with same total
        if (sum % 2 != 0) {
            return false;
        }

        // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
        sum = sum / 2;

        boolean[][] dp = new boolean[n][sum + 1];

        for (int i=0; i<n; i++) {
            dp[i][0] = true;
        }

        for (int s=1; s<=sum; s++) {
            dp[0][s] = num[0] == s ? true : false;
        }

        for (int i=1; i<n; i++) {
            for (int s=1; s<=sum; s++) {
                if (dp[i-1][s]) {
                    // if we can get the sum 's' without the number at index 'i'
                    dp[i][s] = dp[i-1][s];
                } else if (s >= num[i]) {
                    // else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i-1][s-num[i]];
                }
            }
        }

        return dp[n-1][sum];
    }    

    public static void main(String[] args) {
        EqualSubSetSumParition ps = new EqualSubSetSumParition();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}