  class FirstMissingNumber {
    public int firstMissingNumber(int nums[]) {

        boolean containsOne = false;
        if (nums == null && nums.length == 0) {
            return 1;
        }

        int n = nums.length;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                containsOne = true;
            } else if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        if (!containsOne) {
            return 1;
        }

        //  flip the sign
        for (int i=0; i<n; i++) {
            int index = Math.abs(nums[i]) - 1; // it could be possible that we have already flipped the sign at the index...so Math.abs
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i=0; i<n; i++) {
            if (nums[i] > 0) {
                return i + 1; // because indexes are zero based
            }
        }

        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingNumber obj = new FirstMissingNumber();
        System.out.println(obj.firstMissingNumber(new int[]{3,4,-1,1}));
    }
}