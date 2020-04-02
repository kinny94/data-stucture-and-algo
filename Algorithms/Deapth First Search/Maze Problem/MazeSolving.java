  import java.util.*;
import java.io.File;

class FileReader {

    private int[][] maze;
    private String fileName;
    private int noOfColumns;
    private int noOfRows;
    private int startPosCol;
    private int startPosRow;

    FileReader(String filename, int noOfColumns, int  noOfRows) {
        this.fileName = filename;
        this.noOfColumns = noOfColumns;
        this.noOfRows = noOfRows;
        this.maze = new int[noOfRows][noOfColumns];
    }

    public void parseFile() {
        try {
            Scanner scan = new Scanner(new File(this.fileName));
            for(int i=0; i<noOfRows; i++) {
                for(int j=0; j<noOfColumns; j++) {
                    maze[i][j] = scan.nextInt();
                    if (maze[i][j] == 2) {
                        startPosCol = j;
                        startPosRow = i;
                    }
                }
            }
            scan.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    } 

    public int getStartPositionCol() {
        return this.startPosCol;
    }

    public int getStartPositionRow() {
        return this.startPosRow;
    }

    public int[][] getMaze() {
        return this.maze;
    }
}
class MazeSolving {
    
    private int[][] mazeMap;
    private boolean[][] visited;
    private int startPositionCol;
    private int startPositionRow;

    public MazeSolving(int[][] mazeMap, int startPositionCol, int startPositionRow) {
        this.mazeMap = mazeMap;
        this.visited = new boolean[mazeMap.length][mazeMap.length];
        this.startPositionCol = startPositionCol;
        this.startPositionRow = startPositionRow;
    }

    public void findMyWayOut() {
        try {
            dfs(startPositionRow, startPositionCol);
            System.out.println("No solution found!!");
        } catch(RuntimeException e) {
            System.out.println("Route to find to exit...");
        }
    }

    private void dfs(int rowIndex, int colIndex) {
        System.out.println("Visiting i=" + rowIndex + ", j= " + colIndex + "-> ["+rowIndex+"]"+"["+colIndex+"]");
        if (this.mazeMap[rowIndex][colIndex] == 3) {
            throw new RuntimeException();
        }

        int endOfMaze = this.mazeMap.length - 1;

        if (visited[rowIndex][colIndex]) { // if it has already been visited
            return;
        } else  if (rowIndex < 0 || rowIndex >= endOfMaze) { // out of maze
            return;
        } else if (colIndex < 0 || colIndex >= endOfMaze) { //out of maze
            return;
        } else if (this.mazeMap[rowIndex][colIndex] == 1) { // if it is wall we cannot go in the direction
            return;
        } else {
            this.visited[rowIndex][colIndex] = true; // set the current position to visited
            dfs(rowIndex+1, colIndex); // going down
            dfs(rowIndex, colIndex+1); // going right
            dfs(rowIndex, colIndex-1); // going left
            dfs(rowIndex-1, colIndex); // going up
        }
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("Maze.txt", 7, 7);
        fileReader.parseFile();
        MazeSolving mazeSolver = new MazeSolving(
            fileReader.getMaze(),
            fileReader.getStartPositionCol(),
            fileReader.getStartPositionRow()
        );
        mazeSolver.findMyWayOut();
    }
}