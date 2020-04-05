class CoinChange {
    
    // 2^N
    public int recursiveCoinChange(int M, int[] coins, int index) {
        if (M < 0) return 0;
        if (M == 0) return 1;

        if (coins.length == index) return 0;

        return recursiveCoinChange(M-coins[index], coins, index) + recursiveCoinChange(M, coins, index + 1);
    }

    public int dpCoinChange(int M, int[] coins) {
        int[][] dpTable = new int[coins.length + 1][M + 1];

        // for 1 amount there's only one solution - no coins
        for (int i=0; i<coins.length; i++) {
            dpTable[i][0] = 1;
        }

        // for no coins there's no solution
        for (int i=1; i<coins.length + 1; i++) {
            dpTable[0][i] = 0;
        }

        for (int i=1; i<coins.length + 1; i++) {
            for (int j=1; j<=M; j++) {
                if (coins[i-1] <= j) {
                    // if the coin value is greater than the total amount - not take that item
                    dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-coins[i - 1]];
                } else {
                    dpTable[i][j] = dpTable[i-1][j];
                }
            }
        } 

        return dpTable[coins.length][M];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int M = 5;
        CoinChange cc = new CoinChange();
        System.out.println(cc.recursiveCoinChange(M, coins, 0));
        System.out.println(cc.dpCoinChange(M, coins));
    }
}