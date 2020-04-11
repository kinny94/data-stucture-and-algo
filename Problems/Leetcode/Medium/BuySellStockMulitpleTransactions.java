class BuySellStockMulitpleTransactions {

    // much better if we use priority queue
    public static void main(String[] args) {
        BuySellStockMulitpleTransactions obj = new BuySellStockMulitpleTransactions();
        int[] x = { 10, 11, 13, 14, 16, 18, 17, 10, 4, 14 };
        System.out.println(obj.maxProfit(x));
        System.out.println(obj.maxProfit2(x));
    }
    
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = helper(0, prices.length-1, prices, profit);
        return maxProfit;
    }
    
    private int helper(int startIndex, int endIndex, int[] prices, int profit) {
        int maxElement = prices[startIndex]; 
        int maxElementIndex = startIndex;
        
        for (int i=startIndex; i<endIndex; i++) {
           if (prices[i] > maxElement) {
               maxElement = prices[i];
               maxElementIndex = i;
           }
        }
        
        if (maxElementIndex == startIndex) {
            return helper(startIndex+1, prices.length, prices, profit);    
        }
        
        if (maxElementIndex == prices.length - 1) {
            for (int i=startIndex; i<=maxElementIndex; i++) {
                profit += (maxElement - prices[i]);
            }
            return profit;
        } else {
            
            for (int i=startIndex; i<=maxElementIndex; i++) {
                profit = profit + (maxElement - prices[i]);
            }
            return helper(maxElementIndex + 1, prices.length, prices, profit);
        }
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        int max = 0;
    
        for (int i = prices.length - 1; i >=0; i--) {
            max = Math.max(max, prices[i]);
            profit += max - prices[i];
        }
    
        return profit;
    }
}