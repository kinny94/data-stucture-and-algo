class LongestAlternatingSubsequence {
    public int findLASLength(int[] nums)  {
        if (nums == null || nums.length == 0) return 0;
        
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        LongestAlternatingSubsequence las = new LongestAlternatingSubsequence();
        int[] nums = {1,2,3,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{3,2,1,4};
        System.out.println(las.findLASLength(nums));
        nums = new int[]{1,3,2,4};
        System.out.println(las.findLASLength(nums));
    }
}