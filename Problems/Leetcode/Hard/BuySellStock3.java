class BuySellStock {
    public int maxProfit(int[] prices) {
        int buyOne = Integer.MAX_VALUE;
        int buyTwo = Integer.MAX_VALUE;
        
        int sellOne = 0;
        int sellTwo = 0;
        
        for (int price: prices) {
            buyOne = Math.min(buyOne, price);
            sellOne = Math.max(sellOne, price - buyOne);
            buyTwo = Math.min(buyTwo, price - sellOne);
            sellTwo = Math.max(sellTwo, price - buyTwo);
        }
        
        return Math.max(sellOne, sellTwo);
    }
}