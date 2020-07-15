class LongestSubArrayWith1AfterReplacement {
    public int maxLength(int[] arr, int k) {
        int windowStart = 0;
        int maxLength = 0;
        int maxRepeatCount = 0;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                maxRepeatCount++;
            }

            if (i - windowStart + 1 - maxRepeatCount > k) {
                if (arr[windowStart] == 1) {
                    maxRepeatCount--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, i - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubArrayWith1AfterReplacement obj = new LongestSubArrayWith1AfterReplacement();
        System.out.println(obj.maxLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(obj.maxLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}