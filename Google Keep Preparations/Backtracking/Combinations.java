import java.util.ArrayList;
import java.util.List;

class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();

        if (n == 0) {
            return results;
        }

        createCombinations(results, new ArrayList<Integer>(), n , k, 1;
        return results;
    }

    private void createCombinations(List<List<Integer>> results, List<Integer> current, int n, int k, int index) {
        if (current.size() == k) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i=index; i<=n; i++) {
            if (!current.contains(i)) {
                current.add(i);
                createCombinations(results, current, n, k, i);
                current.remove(current.size() - 1);
            }
        }
    }
}