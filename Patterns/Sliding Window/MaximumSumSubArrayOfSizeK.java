class MaximumSumSubArrayOfSizeK {
    public int findMaximumSumSubarray(int[] arr, int k) {
        int windowSum = 0;
        int windowStart = 0;

        for (int i=0; i<k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        for (int i=k; i<arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[windowStart];
            maxSum = Math.max(windowSum, maxSum);
            windowStart++;
        }

        return maxSum;
    }   

    public static void main(String[] args) {
        MaximumSumSubArrayOfSizeK obj = new MaximumSumSubArrayOfSizeK();
        System.out.println(obj.findMaximumSumSubarray(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }
}