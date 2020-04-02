class NumbnerOfIsland {
    
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int row;
    private static int col;
    
    public int numIslands(char[][] grid) {
        
        if (grid.length == 0) {
            return 0;
        }
        
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int x, int y) {
        for (int[] dir: directions) {
            int xCoordinate = x + dir[0];
            int yCoordinate = y + dir[1];
            
            if (xCoordinate >=0 && yCoordinate >= 0 && xCoordinate < row && yCoordinate < col) {
                if (grid[xCoordinate][yCoordinate] == '1') {
                    grid[xCoordinate][yCoordinate] = '0';
                    dfs(grid, xCoordinate, yCoordinate);
                }
            }
        }
    }
}