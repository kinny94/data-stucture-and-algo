class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !hasNeighboringZero(i, j, matrix)) {
                    matrix[i][j] = matrix.length + matrix[0].length + 1;
                }
            }
        } 

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j, 1, directions);
                }
            }
        }  
        
        return matrix;
    }

    private boolean hasNeighboringZero(int i, int j, int[][] matrix) {
        if (i > 0 && matrix[i-1][j] == 0) {
            return true;
        }

        if (i < matrix.length-1 && matrix[i+1][j] == 0) {
            return true;
        }

        if (j > 0 && matrix[i][j - 1] == 0) {
            return true;
        }

        if (j < matrix[0].length - 1 && matrix[i][j+1] == 0) {
            return true;
        }
        
        return false;
    }

    public void dfs(int[][] matrix, int i, int j, int val, int[][] dir) {

        if (i<0||j<0||j>=matrix[0].length||i>=matrix.length||(matrix[i][j]<=val && val != 1)) {
            return;
        }

        matrix[i][j] = val;

        for (int k=0; k<dir.length; k++) {
            int xCoordinate = i + dir[k][0];
            int yCoordinate = j + dir[k][1];
            dfs(matrix, xCoordinate, yCoordinate, matrix[i][j]+1, dir);
        }
    }
}