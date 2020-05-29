import java.util.HashSet;
import java.util.Set;

/*
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
*/

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();

        for (int i: nums) {
            if (set.contains(target - i)) {
                return new int[]{i, target - i};
            } else {
                set.add(i);
            }
        }

        return new int[]{};
    }    
}