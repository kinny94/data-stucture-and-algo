import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }   

        Queue<int[]> queue = new LinkedList<>();
        int countFresh = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        if (countFresh == 0) {
            return 0;
        }

        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();

            for (int i=0; i<size; i++) {
                int[] point = queue.poll();
                
                for (int dir[]: directions) {
                    int xCoordinate = point[0] + dir[0];
                    int yCoordinate = point[1] + dir[1];

                    if (xCoordinate < 0 || yCoordinate < 0 || xCoordinate >= grid.length || yCoordinate >= grid[0].length || grid[xCoordinate][yCoordinate] == 2 || grid[xCoordinate][yCoordinate] == 0) {
                        continue;
                    }

                    grid[xCoordinate][yCoordinate] = 2;

                    queue.offer(new int[]{xCoordinate, yCoordinate});
                    countFresh--;
                }
            }
        }

        return countFresh  == 0 ? count - 1: -1;
    }   
}