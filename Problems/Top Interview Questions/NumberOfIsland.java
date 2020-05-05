class NumberOfIsland {
    public int numIslands(char[][] grid) {
        
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, dir);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void dfs(char[][] grid, int row, int column, int[][] directions) {
        
        if (row < 0 || row>= grid.length || column < 0 || column >= grid[row].length || grid[row][column] == '0') {
            return;
        }
        
        grid[row][column] = '0';
        
        for (int i=0; i<directions.length; i++) {
            int xCoordinate = row + directions[i][0];
            int yCoordinate = column + directions[i][1];
            
            dfs(grid, xCoordinate, yCoordinate, directions);
        }
    }
}   