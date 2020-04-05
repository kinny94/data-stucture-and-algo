class Knapsack {

    private int numOfItems;
    private int knapsackCapacity;
    private int dpTable[][];
    private int totalBenefit;
    private int[] weights;
    private int[] values;

    Knapsack(int items, int capacity, int[] weights, int[] values) {
        this.numOfItems = items;
        this.knapsackCapacity = capacity;
        this.weights = weights;
        this.values = values;
        this.dpTable = new int[numOfItems+1][this.knapsackCapacity + 1];
    }

    public void solve() {
        // coz 0 in the dp table is always gonna have 0 value
        for (int i=1; i<numOfItems + 1; i++) {
            for (int j=1; j<knapsackCapacity+1; j++) {
                int notTakingItem = dpTable[i-1][j];
                int takingItem = 0;

                if (weights[i] <= j) {
                    takingItem = values[i] + dpTable[i-1][j-weights[i]];
                }

                dpTable[i][j] = Math.max(notTakingItem, takingItem);
            }
        }

        totalBenefit = dpTable[numOfItems][knapsackCapacity];
    }
    
    public void showResult() {
        System.out.println("Total benefit: " + totalBenefit);

        for (int i=numOfItems, w=knapsackCapacity; i>0; i--) {
            // not equal to the item right above it
            if (dpTable[i][w] != 0 && dpTable[i][w] != dpTable[i-1][w]) {
                System.out.println("We take item: " + i);
                w = w - weights[i];
            }
        }
    }

    public static void main(String[] args) {
        int numOfItems = 3;
        int knapsackCapacity = 5;
        
        // int[] weights = {4, 2, 3};
        // int[] profit = {10, 4, 7};

        int[] weights = new int[numOfItems + 1];
        weights[1] = 4;
        weights[2] = 2;
        weights[3] = 3;

        int[] profit = new int[numOfItems + 1];
        profit[1] = 10;
        profit[2] = 4;
        profit[3] = 7;

        Knapsack kp = new Knapsack(numOfItems, knapsackCapacity, weights, profit);
        kp.solve();
        kp.showResult();
    }
}