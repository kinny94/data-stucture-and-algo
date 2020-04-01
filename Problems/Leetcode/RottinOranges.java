class RottingOranges {
    class Solution {
        public int orangesRotting(int[][] grid) {
            
            int rows = grid.length;
            int cols = grid[0].length;
            
            int numFresh = 0;
            
            Queue<int[]> queue = new LinkedList<>();
            
            for(int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new int[]{ j, i });
                    } else if (grid[i][j] == 1) {
                        numFresh++;
                    }
                }
            }
            
            if (numFresh == 0) return 0;
            
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int minutes = 0;
                    
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int k = 0; k < size; k++) {
                    int[] coordinate = queue.poll();
                    
                    for (int[] dir: dirs) {
                        int x = coordinate[0] + dir[0];
                        int y = coordinate[1] + dir[1];
                        
                        if (x < 0 || y < 0 || x >= cols || y >= rows) continue;
                        
                        if (grid[y][x] == 1) {
                            grid[y][x] = 2;
                            queue.add(new int[]{ x, y });
                            numFresh--;
                        }
                    }
                }
                minutes++;
            }
            
            return numFresh > 0 ? -1 : minutes-1;
        }
    }
}