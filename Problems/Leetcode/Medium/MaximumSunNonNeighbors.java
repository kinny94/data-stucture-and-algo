class MaximumSumNonNeighbors {
    
    public static int maxSum(int a[], int start, int end) {
        int maxSum = 0;
        
        // Trivial cases
        if (start == end) {
            return a[start];
        } else if (start > end) {
            return 0;
        } else if (end - start == 1) {
            return a[start] > a[end] ? a[start] : a[end];
        } else if (start < 0) {
            return 0;
        } else if (end >= a.length) {
            return 0;
        }
        
        // Subproblem solutions, DP
        for (int i = start; i <= end; i++) {
            int possibleMaxSub1 = maxSum(a, i + 2, end);
            int possibleMaxSub2 = maxSum(a, start, i - 2);
            
            int possibleMax = possibleMaxSub1 + possibleMaxSub2 + a[i];
            if (possibleMax > maxSum) {
                maxSum = possibleMax;
            }
        }
        
        return maxSum;
    }
    
    public static int test(int a[]) {
        int[] dp = {a[0], a[1]};
        for(int i = 2; i < a.length; i++)
        {
            int temp = dp[1];
            dp[1] = dp[0] + a[i];
            dp[0] = Math.max(dp[0], temp);
        }    
        return Math.max(dp[0], dp[1]);
    }
    
    public static void main(String args[]) {
        int a[] = { 5, 1, 1, 5};
        System.out.println(maxSum(a, 0, a.length - 1));
        System.out.println(test(a));
    }
}

