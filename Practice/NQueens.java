class NQueens {
    
    private int[][] chessBoard;
    private int numsOfQueens;

    NQueens(int numsOfQueens) {
        this.numsOfQueens = numsOfQueens;
        this.chessBoard = new int[numsOfQueens][numsOfQueens];
    }

    public void solve() {
        if (setQueens(0)) {
            printQueens();
        } else {
            System.out.println("No feasible solution!!");
        }
    }

    public void printQueens() {
        for (int i=0; i<this.chessBoard.length; i++) {
            for (int j=0; j<this.chessBoard.length; j++) {
                if (this.chessBoard[i][j] == 1) {
                    System.out.print(" Q ");
                }  else {
                    // Empty spaces
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public boolean setQueens(int col) {
        if (col == this.numsOfQueens) {
            return true;
        } else {
            for (int row = 0; row < this.numsOfQueens; row++) {
                if (isPlaceValid(row, col)) {
                    chessBoard[row][col] = 1;

                    if (setQueens(col + 1)) {
                        return true;
                    }

                    chessBoard[row][col] = 0;
                }
            }
        }

        return false;
    }

    private boolean isPlaceValid(int row, int col) {

        for(int i=0;i<col;i++) {
            if (this.chessBoard[row][i] == 1) {
                return false;
            }
        }
			
		
		for(int i=row, j=col;i>=0 && j>=0;i--,j--) {
			if( this.chessBoard[i][j] == 1 ) {
                return false;
            }
		}
		
		for(int i=row, j=col;i<this.chessBoard.length && j>=0;i++,j--) {
			if( this.chessBoard[i][j] == 1) {
                return false;
            }
		}
		
        return true;
    }


    public static void main(String[] args) {
        NQueens obj = new NQueens(4);
        obj.solve();
    }
}