class MaximumRibbonCut {
    public int countRibbonPieces(int[] ribbonLengths, int total) {
        int n = ribbonLengths.length;
        int [][] dp = new int[n][total + 1];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<=total; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        
        for (int i=0; i<n; i++) {
            dp[i][0] = 0;
        }
        
        for (int i=0; i<n; i++) {
            for (int j=1; j<=total; j++) {
                if (i>0) {
                    dp[i][j] = dp[i-1][j];
                }
                
                if (j >= ribbonLengths[i] && dp[i][j - ribbonLengths[i]] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - ribbonLengths[i]] + 1);
                }
            }
        }
        
        return dp[n-1][total] == Integer.MIN_VALUE ? -1 : dp[n-1][total];
    }    
    
    public  int cutRibbonOfEqualLength(int[] arr, int k) {
        int max = 0;
        for (int a : arr) {
            max = Math.max(max, a);
        }
        int lo = 1, hi = max;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int len = getLen(arr, mid);
            if (len >= k) { lo = mid + 1; }
            else { hi = mid - 1; }
        }
        return hi;
    }
    private static int getLen(int[] arr, int target) {
        int res = 0;
        for (int a : arr) {
            res += (a / target);
        }
        return res;
    }
    
    public static void main(String[] args) {
        MaximumRibbonCut cr = new MaximumRibbonCut();
        int[] ribbonLengths = {2,3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[]{2,3};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{5,3,7};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[]{3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{1, 2, 3, 4, 9};
        System.out.println(cr.cutRibbonOfEqualLength(ribbonLengths, 5));
    }
}