class SmallestSubArrayWithAGivenSum {
    public static int findMinSubArray(int S, int[] arr) {

        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int i=0; i<arr.length; i++) {
            windowSum += arr[i];

            while (windowSum >= S) {
                minLength = Math.min(minLength, i - windowStart + 1);
                windowSum =  windowSum - arr[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }   
    
    public static void main(String[] args) {
        int result = SmallestSubArrayWithAGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubArrayWithAGivenSum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = SmallestSubArrayWithAGivenSum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}