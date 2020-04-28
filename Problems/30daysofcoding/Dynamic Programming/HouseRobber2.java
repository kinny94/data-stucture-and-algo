class HouseRobber2 {

    private int rob(int[] num, int lo, int high) {
        int include = 0;
        int exclude = 0;

        for (int j=lo; j<=high; j++) {
            int i = include;
            int e = exclude;

            include = e + num[j];
            exclude = Math.max(e, i);
        }

        return Math.max(include, exclude);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}