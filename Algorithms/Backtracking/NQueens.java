class NQueens {

    private int[][] chessboard;
    private int numsOFQueens;

    NQueens(int numsOFQueens) {
        this.numsOFQueens = numsOFQueens;
        this.chessboard = new int[numsOFQueens][numsOFQueens];
    }

    public void solve() {
        if (setQueens(0)) {
            printQueens();
        } else {
            System.out.println("No feasible solution..");
        }
    }

    public void printQueens() {
        for (int i=0; i<chessboard.length; i++) {
            for (int j=0; j<chessboard.length; j++) {
                if (chessboard[i][j] == 1) {
                    System.out.print(" * ");
                }  else {
                    // Empty spaces
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    private boolean setQueens(int col) {
        if (col == this.numsOFQueens) {
            return true;
        } else {
            for (int row=0; row<this.numsOFQueens; row++) {
                if (isPlaceValid(row, col)) {
                    chessboard[row][col] = 1;

                    if (setQueens(col + 1)) {
                        return true;
                    }

                    // backtracking phase - coz the above step didn't return
                    chessboard[row][col] = 0;
                }
            }
        }   

        return false;
    }

    private boolean isPlaceValid(int row, int col) {

        for(int i=0;i<col;i++)
			if( chessboard[row][i] == 1)
				return false;
		
		for(int i=row, j=col;i>=0 && j>=0;i--,j--) {
			if( chessboard[i][j] == 1 ) 
				return false;
		}
		
		for(int i=row, j=col;i<chessboard.length && j>=0;i++,j--) {
			if( chessboard[i][j] == 1)
				return false;
		}
		
        return true;
        
    }

    public static void main(String[] args) {
        NQueens algo = new NQueens(4    );
        algo.solve();
    }
}