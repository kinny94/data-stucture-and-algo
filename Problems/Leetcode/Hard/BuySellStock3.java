/**
 * Assume we only have 0 money at first;
    4 Variables to maintain some interested 'ceilings' so far:
    The maximum of if we've just buy 1st stock, if we've just sold 1nd stock, if we've just buy 2nd stock, if we've just sold 2nd stock.
    Very simple code too and work well. I have to say the logic is simple than those in Single Number II.
 */
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