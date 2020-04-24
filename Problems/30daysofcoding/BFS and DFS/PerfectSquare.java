import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class PerfectSquare {
    public int numOfSquares(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        int level = 0;
        
        Set<Integer> visisted = new HashSet<Integer>();
        visisted.add(0);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int current = queue.poll();
                for (int j=1; current + j * j <= n; j++) {
                    int temp = current + j * j;
                    if (temp == n) {
                        return level + 1;
                    }

                    if (!visisted.contains(temp)) {
                        queue.offer(temp);
                        visisted.add(temp);
                    }
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        PerfectSquare obj = new PerfectSquare();
        System.out.println(obj.numOfSquares(13));
    }
}