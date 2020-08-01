class Solution {
    public int longestOnes(int[] A, int K) {
        
        int maxLength = 0;
        int maxrepatingCount = 0;
        int windowStart = 0;
        
        for (int i=0; i<A.length; i++) {
            if (A[i] == 1) {
                maxrepatingCount++;
            }
            
            if (i - windowStart + 1 - maxrepatingCount > K) {
                if (A[windowStart] == 1) {
                    maxrepatingCount--;
                }
                windowStart++;
            }
            
            maxLength = Math.max(maxLength, i -windowStart + 1);
        }
        
        return maxLength;
    }
}