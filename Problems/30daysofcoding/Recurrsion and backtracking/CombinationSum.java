import java.util.*; 

class CombinationSum {

    public List<List<Integer>> combinationalSum(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        findCombinationSum(results, new ArrayList<Integer>(), candidates, target, 0);
        return results;
    }

    private void findCombinationSum(List<List<Integer>> results, List<Integer> combinations, int[] candidates, int target, int index) {

        if (target == 0) {
            results.add(new ArrayList<>(combinations));
            return;
        }

        for (int i=index; i<candidates.length; i++) {
            if (candidates[i] <= target) {
                combinations.add(candidates[i]);
                findCombinationSum(results, combinations, candidates, target - candidates[i], i);
                combinations.remove(combinations.size() - 1);
            } else {
                break;
            }
            
        }
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] a = {2, 3, 6, 7};
        System.out.println(obj.combinationalSum(a, 7));
    }
}