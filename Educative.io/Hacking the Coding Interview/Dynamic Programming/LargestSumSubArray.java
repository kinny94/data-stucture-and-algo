class LargestSumSubArray {
    
    public static int findSubArray(int[] A) {
        if (A.length < 1) {
            return 0;
        }

        int currentMax = A[0];
        int globalMax = A[0];   

        for (int i=1; i<A.length; i++) {
            if (currentMax < 0) {
                currentMax = A[i];
            } else {
                currentMax += A[i];
            }

            if (globalMax < currentMax) {
                globalMax = currentMax;
            }
        }

        return globalMax;
    }
}