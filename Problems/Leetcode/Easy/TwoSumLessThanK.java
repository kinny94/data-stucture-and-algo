import java.util.TreeSet;

class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        int res = -1;
        for (int a: A) {
            Integer pre = set.lower(K - a);
            
            if (pre != null) {
                res = Math.max( a+pre, res);
            }
            
            set.add(a);
        }
        
        return res;
    }
}