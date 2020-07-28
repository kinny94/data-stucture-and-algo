class MinimumJumpsToReachTheEnd {
    public int countMinJumps(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int currentFarthest = 0;

        for (int i=0; i<nums.length - 1; i++) {
            currentFarthest = Math.max(currentFarthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = currentFarthest;
            }
        }

        return jumps;
    }    

    public static void main(String[] args) {
        MinimumJumpsToReachTheEnd aj = new MinimumJumpsToReachTheEnd();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
    }
}