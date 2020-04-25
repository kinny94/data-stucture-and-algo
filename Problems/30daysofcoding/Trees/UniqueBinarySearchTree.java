import java.util.HashMap;
import java.util.Map;

/*
    The idea is to use each number i as root node, then the left branch will be what's less than i, the right branch will be what's larger than i. The total number of distinct structure is their product. Thus, sum up the product for all numbers. Use a map to memorize the visited number.
*/
class UniqueBinarySearchTree {
    public int numOfTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        return numOfTrees(n, map);
    }

    private int numOfTrees(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int sum = 0;
        for (int i=0; i<=n; i++) {
            sum += numOfTrees(i-1, map) * numOfTrees(n-i, map);
        }

        map.put(n, sum);
        return sum;
    }
}