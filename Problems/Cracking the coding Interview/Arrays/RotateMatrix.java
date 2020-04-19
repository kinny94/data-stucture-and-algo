class RotateMatrix {
    public void rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }

        int n = matrix.length;

        for (int i=0; i<n/2; i++) {
            int first = i;
            int last = n-1-i;
            for (int j=first; j<last; j++) {
                int offset = j - first;

                int top = matrix[i][j];

                matrix[i][j] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[j][last];
                matrix[j][last] = top;
            }
        }


        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateMatrix obj = new RotateMatrix();
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        obj.rotateMatrix(input); 
    }
}