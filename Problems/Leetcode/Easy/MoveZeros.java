class Solution {
    public void moveZeroes(int[] nums) {
        
        if (nums.length < 1) {
            return;
        }
        
        int readIndex = 0;
        int writeIndex = 0;
        
        while (readIndex < nums.length) {
            if (nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
            readIndex++;
        }
        
        while (writeIndex < nums.length) {
            nums[writeIndex] = 0;
            writeIndex++;
        }
    }
}