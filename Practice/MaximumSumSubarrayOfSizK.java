class MaximumSumSubarrayOfSizK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int currentSum = 0;

        for (int i=0; i<k; i++) {
            currentSum += arr[i];
        }

        maxSum = currentSum;

        for (int i=k; i<arr.length; i++) {
            currentSum = currentSum - arr[i-k] + arr[i];
            maxSum = Math.max(currentSum, maxSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
        + MaximumSumSubarrayOfSizK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("Maximum sum of a subarray of size K: "
        + MaximumSumSubarrayOfSizK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
} 