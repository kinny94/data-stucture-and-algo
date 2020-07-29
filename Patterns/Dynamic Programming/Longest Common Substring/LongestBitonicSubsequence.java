class LongestBitonicSubsequence {
    private int findLBSLength(int[] nums) {
        int[] lds = new int[nums.length];
        int[] ldsReverse = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            lds[i] = 1; // every element is an LDS of length 1
            for (int j = i - 1; j >= 0; j--)
            if (nums[j] < nums[i]) {
                lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            ldsReverse[i] = 1; // every element is an LDS of length 1
            for (int j = i + 1; j < nums.length; j++)
            if (nums[j] < nums[i]) {
                ldsReverse[i] = Math.max(ldsReverse[i], ldsReverse[j] + 1);
            }
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
          maxLength = Math.max(maxLength, lds[i] + ldsReverse[i] - 1);
        }
    
        return maxLength;
    }

    public static void main(String[] args) {
        LongestBitonicSubsequence lbs = new LongestBitonicSubsequence();
        int[] nums = { 4, 2, 3, 6, 10, 1, 12 };
        System.out.println(lbs.findLBSLength(nums));
        nums = new int[] { 4, 2, 5, 9, 7, 6, 10, 3, 1 };
        System.out.println(lbs.findLBSLength(nums));
    }
}