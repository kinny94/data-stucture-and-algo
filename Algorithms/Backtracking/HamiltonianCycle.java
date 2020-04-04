class HamiltonianCycle {
    private int numOFVertexes;
    private int[] hamiltonianPath;
    private int[][] adjacencyMatrix;
    
    HamiltonianCycle(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.hamiltonianPath = new int[adjacencyMatrix.length];
        this.numOFVertexes = adjacencyMatrix.length;
        // coz we gonna assign indices to every vertex
        this.hamiltonianPath[0] = 0;
    }

    public void solve(){
        // coz vertex 0 is laready considered;
        if (!findFeasibleSolution(1)) {
            System.out.println("No feasible solution...");
        } else {
            showHamiltonianPath();
        }
    }

    private void showHamiltonianPath() {
        System.out.println("Hamiltonian cycle : ");
        for (int i=0; i<hamiltonianPath.length; i++) {
            System.out.print(hamiltonianPath[i] + " ");
        }

        // since its a cycle, it will end up at the same index
        System.out.println(hamiltonianPath[0]);
    }

    private boolean findFeasibleSolution(int position) {
        // all vertexes considered
        if (position == numOFVertexes) {
            // if the last vertex in the hamiltonian path is connected to first vertex 
            if (adjacencyMatrix[hamiltonianPath[position-1]][hamiltonianPath[0]] == 1) {
                return true;
            } else {
                return false;   
            }
        }

        // already considered the first one
        for (int vertexIndex=1; vertexIndex<numOFVertexes; ++vertexIndex) {
            if (isFeasible(vertexIndex, position)) {
                hamiltonianPath[position] = vertexIndex;

                if (findFeasibleSolution(position + 1)) {
                    return true;
                } 
                // backtracking

            }
        }

        return false;
    }

    private boolean isFeasible(int vertexIndex, int actualposition) {
        // first criteria - whether two nodes are connected
        if (adjacencyMatrix[hamiltonianPath[actualposition-1]][vertexIndex] == 0) {
            return false;
        }

        // second: whether we have visited it or not;
        for (int i=0; i<actualposition; i++) {
            if (hamiltonianPath[i] == vertexIndex) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 1, 0},
            {1, 0, 1}, 
            {0, 1, 0}
        };

        int[][] matrix2 = {
            {0, 1, 1, 1, 0, 0}, 
            {1, 0, 1, 0, 1, 0},
            {1, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 1},
            {0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1}
        };
        HamiltonianCycle cycle = new HamiltonianCycle(matrix);
        HamiltonianCycle cycle2 = new HamiltonianCycle(matrix2);
        cycle.solve();
        cycle2.solve();
    }
}