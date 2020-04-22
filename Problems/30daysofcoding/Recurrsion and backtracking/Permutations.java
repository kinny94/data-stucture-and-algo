import java.util.List;
import java.util.ArrayList;

class Permutations {
    
    public List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null && nums.length == 0) {
            return results;
        }

        findPermutations(results, new ArrayList<Integer>(), nums, 0);
        return results;
    }

    private void findPermutations(List<List<Integer>> results, List<Integer> permutation, int[] nums, int index) {

        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!permutation.contains(nums[i]) && permutation.size() != nums.length) {
                permutation.add(nums[i]);
                findPermutations(results, permutation, nums, i);
                permutation.remove(permutation.size() - 1);
            } 
        }
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Permutations obj = new Permutations();
        System.out.println(obj.permutations(a));
    }
}