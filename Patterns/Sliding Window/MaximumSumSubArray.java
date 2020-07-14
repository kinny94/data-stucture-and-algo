class MaximumSumSubArray {
    private int maxSum(int[] arr) {
        int resultSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i=0; i<arr.length; i++) {
            currentSum = currentSum + arr[i];
            resultSum = Math.max(resultSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return resultSum;
    }

    public static void main(String[] args) {
        MaximumSumSubArray obj = new MaximumSumSubArray();
        System.out.println(obj.maxSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}