class MAximumSumSubarray {
    private int maxSum(int[] arr) {
        int currentSum = 0;
        int resultSum = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {
            currentSum += arr[i];
            resultSum = Math.max(currentSum, resultSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return resultSum;
    }

    public static void main(String[] args) {
        MAximumSumSubarray obj = new MAximumSumSubarray();
        System.out.println(obj.maxSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}