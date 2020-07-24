import java.util.ArrayList;
import java.util.List;

class AllDistinctSubsets {
    
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }    
    
    public static void main(String[] args) {
        List<List<Integer>> result = AllDistinctSubsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);
        
        result = AllDistinctSubsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}