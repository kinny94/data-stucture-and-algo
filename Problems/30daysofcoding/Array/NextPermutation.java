import java.util.Arrays;

class NextPermutation {
    
    public void nextPermutation(int[] nums) {
        
        int k = nums.length - 2;
        while (k >= 0 && nums[k] >= nums[k+1]) {
            k--;
        }

        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int l= nums.length - 1; l>k; --l) {
            if (nums[l] > nums[k]) {
                swap(nums, l, k);
                break;
            }
        }

        reverse(nums, k+1, nums.length -1);
        System.out.println(Arrays.toString(nums));
    }


    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] a = {1,2,3};
        np.nextPermutation(a); 
    }
}