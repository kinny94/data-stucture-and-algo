class 132Pattern {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int[] mins = new int[nums.length];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mins[i] = min;
            min = Math.min(min, nums[i]);
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i > 0; i--) {
            while (!stack.empty() && stack.peek() <= mins[i]) stack.pop();
            if (!stack.empty() && stack.peek() < nums[i]) return true;
            stack.push(nums[i]);
        }
        
        return false;
    }
}