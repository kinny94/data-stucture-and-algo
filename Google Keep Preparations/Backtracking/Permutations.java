import java.util.ArrayList;
import java.util.List;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        createPermutations(results, new ArrayList<>(), nums);
        return results;
    }

    private void createPermutations(List<List<Integer>> results, List<Integer> current, int[] nums) {
        
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!current.contains(nums[i])) {
                current.add(nums[i]);
                createPermutations(results, current, nums);
                current.remove(current.size() - 1);
            }
        }
    }
}