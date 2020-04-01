class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max =0;
        int min = Integer.MAX_VALUE;
        for(int price: prices) {
            min = Math.min(price, min);
            max = Math.max(price - min, max);
        }
        
        return max;
    }
}