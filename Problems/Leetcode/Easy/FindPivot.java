class FindPivot {
    public int findPivot(int[] nums) {
        int sum = 0;

        if (nums.length < 3) {
            return -1;
        }

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        int right = 0;
        for (int i=0; i<nums.length; i++) {
            if (i-1 >= 0) {
                right += nums[i - 1];
            }

            int left = sum - (nums[i] + right);
            if (left == right) {
                return i;
            }
        }

        return -1;
    }
}