class ZeroMatrix {
    public void convertToZeroMatrix(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i =0; i<row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int i=0; i<column.length; i++) {
            if (column[i]) {
                nullifyColumn(matrix, i);
            }
        }

        printArray(matrix);
    }

    public void nullifyRow(int[][] matrix, int index) {
        for (int j=0; j<matrix[0].length; j++) {
            matrix[index][j] = 0;
        }
    }

    public void nullifyColumn(int[][] matrix, int index) {
        for (int j=0; j<matrix[0].length; j++) {
            matrix[j][index] = 0;
        }
    }

    public void printArray(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {1, 0, 3}, {3, 0, 1}};
        ZeroMatrix obj = new ZeroMatrix();
        obj.convertToZeroMatrix(a);
    }

}