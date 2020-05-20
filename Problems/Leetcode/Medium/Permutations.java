import java.util.ArrayList;

class Permutations {
   public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> results = new ArrayList<>();

      if (nums == null || nums.length == 0) {
         return results;
      }

      createPermutations(results, new ArrayList<Integer>(), nums);
      return results;
   }

   private void createPermutations(List<List<Integer>> results, List<Integer> current, int[] nums) {
      if (currentList.size() == nums.length) {
         results.add(currentList);
         return;
      }

      for (int i=0; i<nums.length; i++) {
         if (!currentList.contains(nums[i])) {
            currentList.add(nums[i]);
            createPermutations(results, current, nums);
            currentList.remove(currentList.size() - 1);
         }
      }
   }
}