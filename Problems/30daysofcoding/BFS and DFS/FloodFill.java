class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        if (image[sr][sc] == newcolor) {
            return image;
        }

        fill(image, sr, sc, image[sr][sc], newcolor);
        return image;
    }

    public void fill(int[][] image, int i, int j, int color, int newcolor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != color) {
            return;
        }

        image[i][j] = newcolor;

        fill(image, i+1, j, color, newcolor);
        fill(image, i-1, j, color, newcolor);
        fill(image, i, j+1, color, newcolor);
        fill(image, i, j-1, color, newcolor);
    }
}