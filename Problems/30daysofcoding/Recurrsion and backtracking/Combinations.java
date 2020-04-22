import java.util.*;

class Combinations {

    public List<List<Integer>> combinations(int n, int k) {

        List<List<Integer>> results = new ArrayList<>();
        
        findCombinations(results, new ArrayList<Integer>(), n, k, 1);
        return results; 
    }

    private void findCombinations(List<List<Integer>> results, List<Integer> combinations, int n, int k, int index) {

        if (combinations.size() == k) {
            results.add(new ArrayList<>(combinations));
            return;
        }

        for (int i=index; i<=n; i++) {
            if (!combinations.contains(i)) {
                combinations.add(i);
                findCombinations(results, combinations, n, k, i);
                combinations.remove(combinations.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        System.out.println(obj.combinations(4, 2));
    }
    
}