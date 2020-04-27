import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class PerfectSquares {

    public int numSqaures(int n) {
        int[] dp = new int[n+1];
        for (int i=0; i<=n; i++) {
            dp[i] = i;
            for (int j=1; j*J<=i; j++) {
                dp[i] = Math.min(dp[i-j*j] + 1, dp[i]);
            }
        }

        return dp[n];
    }

    public int bfsSolution(int n) {
        if (n == 0 || n ==1) {
            return n;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int level = 0;

        Set<Integer> visited = new HashSet<>();
        visisted.add(0);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int current = current.poll();
                for (int j=1; current + j * j <= n; j++) {
                    int temp = current + j * j;
                    if (temp == n) {
                        return level + 1;
                    } 

                    if (!visited.contains(temp)) {
                        queue.offer(temp);
                        visited.add(temp);
                    }
                }
            }
            level++;
        }

        return 0;
    }
}