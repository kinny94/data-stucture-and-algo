/**
     * For instance, at the very beginning, if leftMax = 2, rightMax = 5, then we move left pointer from index 0 to index 1 since left bar is smaller. For index 1, left bar is 2, we can conclude that the area in position 1 is 2. Let us analysis two possible conditions:
        Condition 1: there exists another bar with height h, as 2 < h < 5, then position 1 can fill water with 2 units, even though water will be blocked by the middle bar
        Condition 2: there exists another bar with height h, as 2 > h, then position 1 still can fill water with 2 units (in other words, if there does not exist any bars greater than 2, then water will fill out every position until reach the right most bar with height 5)
        So anything in the middle of leftMax bar and rightMax bar will not influence how much water can current position trap
 */
class TrapTheWater {
    public int trap(int[] height) {
        
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        
        // leftMax represents the highest bar from left
        int leftMax = Integer.MIN_VALUE;
        
        // rightMax represents the highest bar from right
        int rightMax = Integer.MIN_VALUE;
    
           if (height == null || height.length == 0) {
            return 0;
        }

        // use two pointers to scan the entire array until they meet with each other
        // Key points: any bars in the middle of leftMax bar and rightMax bar will not influence
        // how much water can current position trap
        for (int left = 0, right = height.length - 1; left <= right;) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            //how much can current position trap depends on the shorter bar
            if (leftMax < rightMax) {
                //DO NOT FORGET to subtract bar height of current position
                result += leftMax - height[left];
                left++;
            }
            else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
 
    }
}