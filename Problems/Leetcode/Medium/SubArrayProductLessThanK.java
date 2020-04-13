
/*
    The idea is always keep an max-product-window less than K;
    Every time shift window by adding a new number on the right(j), if the product is greater than k, then try to reduce numbers on the left(i), until the subarray product fit less than k again, (subarray could be empty);
    Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
    example:
    for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))
*/class SubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;        
    }
}