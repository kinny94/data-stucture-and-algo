class NumberOfIsland {
    
    public int numsOfIsland(char[][] grid) {

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

    private void dfs(char[][] grid, int i, int j, int[][] dir) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        for (int k=0; k<dir.length; k++){
            int xCoordinate = i + dir[k][0];
            int yCoordinate = j + dir[k][1];

            dfs(grid, xCoordinate, yCoordinate, dir);
        }
    }
}