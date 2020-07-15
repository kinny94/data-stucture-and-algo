class SmallestSubArrayWithGivenSum {
    public int findMinSubArray(int s, int[] arr) {
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int i=0; i<arr.length; i++) {
            windowSum += arr[i];
            while (windowSum >= s) {
                minLength = Math.min(minLength, i - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }   

    public static void main(String[] args) {
        SmallestSubArrayWithGivenSum obj = new SmallestSubArrayWithGivenSum();
        System.out.println(obj.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
    }
}