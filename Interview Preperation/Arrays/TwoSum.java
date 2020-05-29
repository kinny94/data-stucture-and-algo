import java.util.HashSet;
import java.util.Set;

/*
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
*/

class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
    
            for (int i=0; i<nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{i, map.get(target - nums[i])};
                } else {
                    map.put(nums[i], i);
                }
            }
                    
            return new int[]{};
        }    
    } 
}