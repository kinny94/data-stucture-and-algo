class NextPermutation {
    public void nextPermutation(int[] nums) {

        int k = nums.length - 2;
        while (k >= 0 &&  nums[k] >= nums[k+1]) {
            k--;
        } 

        if (k == -1) {
            reverse(nums, 0,  nums.length - 1); 
            return;
        }

        for (int i = nums.length - 1; i>k; i--) {
            if (nums[i] > nums[k]) {
                swap(nums, i, k);
                break;
            }
        }

        reverse(nums, k+1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}