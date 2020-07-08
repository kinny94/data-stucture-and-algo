import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        createCombinations(results, new ArrayList<Integer>(), 0, candidates, target);
        return results;
    }

    private void createCombinations(List<List<Integer>> results, List<Integer> current, int index, int[] candidates, int target) {
        if (target == 0) {
            results.add(new ArrayList<>(current));
        }

        for (int i=index; i<candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            createCombinations(results, current, i, candidates, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}