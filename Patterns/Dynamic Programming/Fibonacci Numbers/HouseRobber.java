class HouseRobber {
    public int findMaxSteal(int[] wealth) {
        if (wealth.length == 0) {
            return 0;
        }


        int[] dp = new int[wealth.length + 1];
        dp[0] = 0;
        dp[1] = wealth[0];

        for (int i=1; i<wealth.length; i++) {
            dp[i+1] = Math.max(wealth[i] + dp[i-1], dp[i]);
        }

        return dp[wealth.length];
    }    

    public static void main(String[] args) {
        HouseRobber ht = new HouseRobber();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxSteal(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxSteal(wealth));
    }
}