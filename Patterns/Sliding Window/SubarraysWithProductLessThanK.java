class SubarraysWithProductLessThanK {
    public int numSubArrayProductLesThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int prod = 1;
        int count = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            prod *= nums[windowEnd];
            while (prod >= k) {
                prod = prod / nums[windowStart];
                windowStart++;
            }

            count = count + windowEnd - windowStart + 1;
        }

        return count;
    }   

    public static void main(String[] args) {
        SubarraysWithProductLessThanK obj = new SubarraysWithProductLessThanK();
        System.out.println(obj.numSubArrayProductLesThanK(new int[]{10,5,2,6}, 100));
    }
}