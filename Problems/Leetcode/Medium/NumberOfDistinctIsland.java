class NumberOfDitinctIsland {
    
    private static int row;
    private static int col;
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numDistinctIslands(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        
        Set<String> uniqueShapes = new HashSet<>();
        StringBuilder shape;
        
        for(int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    shape = new StringBuilder("o");
                    dfs(grid, i, j, shape);
                    uniqueShapes.add(shape.toString());
                }
            }
        }
        
        return uniqueShapes.size();
    } 
    
    private void dfs(int[][] grid, int x, int y, StringBuilder shape) {
        for (int i=0; i<directions.length; i++) {
            
            int xCoordinate = x + directions[i][0];
            int yCoordinate = y + directions[i][1];
            
            if (xCoordinate >=0 && yCoordinate >= 0 && xCoordinate < row && yCoordinate < col) {
                if (grid[xCoordinate][yCoordinate] == 1) {
                    grid[xCoordinate][yCoordinate] = 0;
                    shape.append(i);
                    dfs(grid, xCoordinate, yCoordinate, shape);
                }
            }
        }
        
        shape.append('_');
    }
}