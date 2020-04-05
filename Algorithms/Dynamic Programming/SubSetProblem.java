class SubSetProblem {

    private boolean[][] dpTable;
    private int[] S;
    private int sum;

    SubSetProblem(int[] S, int sum) {
        this.S = S;
        this.sum = sum;
        this.dpTable = new boolean[S.length+1][sum + 1];
    }

    public void solve() {
        for (int i=0; i<S.length + 1; i++) {
            dpTable[i][0] = true;
        }

        for (int rowIndex = 1; rowIndex < S.length+1; rowIndex++) {
            for (int columnIndex = 1; columnIndex<sum+1; columnIndex++) {
                if (columnIndex < S[rowIndex-1]) {
                    dpTable[rowIndex][columnIndex] = dpTable[rowIndex-1][columnIndex];
                } else {
                    if (dpTable[rowIndex-1][columnIndex] == true) {
                        dpTable[rowIndex][columnIndex] = dpTable[rowIndex-1][columnIndex];
                    } else {
                        dpTable[rowIndex][columnIndex] = dpTable[rowIndex-1][columnIndex - S[rowIndex-1]];
                    }
                }
            }
        }

        System.out.println("Solution:  " + dpTable[S.length][sum]);
    }

    public void showIntegers() {
        int columnIndex = sum;
        int rowIndex = S.length;

        while( columnIndex > 0 || rowIndex > 0) {
            if (dpTable[rowIndex][columnIndex] == dpTable[rowIndex-1][columnIndex]) {
                rowIndex--;
            } else {
                System.out.println("We take: " + S[rowIndex-1]);
                columnIndex = columnIndex - S[rowIndex - 1];
                rowIndex--; 
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 3, 1};
        int sum = 9;
        SubSetProblem ssp = new SubSetProblem(numbers, sum);
        ssp.solve();
        ssp.showIntegers();
    }   
}