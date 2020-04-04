class ColoringProblem {

    private int numOfVertex;
    private int numOfColors;
    private int[] colors;
    private int[][] neighbors; 

    ColoringProblem(int[][] neighbors, int numOfColors) {
        this.numOfColors = numOfColors;
        this.neighbors = neighbors;
        this.numOfVertex = neighbors.length;
        this.colors = new int[numOfVertex]; 
    }

    public void solve() {
        if (solveProblem(0)) {
            showresult();
        } else {
            System.out.println("No feasible solution possible!!");
        }
    }

    private void showresult() {
        for (int i=0; i<numOfVertex; i++) {
            System.out.println("Node " + (i+1) + " has color index : " + colors[i]);
        }
    }

    private boolean solveProblem(int nodeIndex) {
        if (nodeIndex == numOfVertex) {
            return true;
        }

        for (int colorIndex=1; colorIndex<=numOfColors; colorIndex++) {
            if (isColorValid(nodeIndex, colorIndex)) {
                colors[colorIndex] = colorIndex;

                if (solveProblem(nodeIndex + 1)) {
                    return true;
                }

                // backtrack
            }
        }

        return false;
    }

    private boolean isColorValid(int nodeIndex, int colorIndex) {
        for (int i=0; i<numOfVertex; i++) {
            if (neighbors[nodeIndex][i] == 1 && colorIndex == colors[i]) {
                return false;
            }
        }

        return true; 
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 1, 0}
        };
        int numOfColors= 3;


        ColoringProblem cp = new ColoringProblem(matrix, numOfColors);
        cp.solve();
    }
}