class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i=0; i<nums.length; i++) {
            int remainder = target - nums[i];
            if (map.containsKey(remainder)) {
                result[0] = i;
                result[1] = this.map.get(remainder);
                return result;
            }

            map.put(nums[i], i);
        }

        return result;
    }
}