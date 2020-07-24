import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        
        for (int currentNumber: nums) {
            int n = permutations.size();
            for (int i=0; i<n; i++) {
                List<Integer> oldPermutations = permutations.poll();
                for (int j=0; j<=oldPermutations.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutations);
                    newPermutation.add(j, currentNumber);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        permutations.add(newPermutation);
                    }
                }
            }
        }

        return result;
    }    

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}