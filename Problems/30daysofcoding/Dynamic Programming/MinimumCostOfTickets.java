import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MinimumCostOfTickets {
    public int mincostTickets(int[] days, int[] costs) {

        Set<Integer> set = new HashSet<>();
        for (int day: days) {
            set.add(day);
        }

        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        for (int i=1; i<=lastDay; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i-1];
            } else {
                dp[i] =  dp[i-1] + costs[0];

                int j = (i >= 7) ? i - 7 : 0;
                dp[i] = Math.min(dp[i], dp[j] + costs[1]);

                j = (i>=30) ? i-30 : 0;
                dp[i] = Math.min(dp[i], dp[j] + costs[2]);

                System.out.println(j);
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[lastDay];
    }

    public static void main(String[] args) {
        MinimumCostOfTickets obj = new MinimumCostOfTickets();
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        System.out.println(obj.mincostTickets(days, costs));
    }
}