class FriendCircles {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;

        for (int i=0; i<M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }

        return count;
    }   
    
    private void dfs(int[][] M, int[] visisted, int i) {
        for (int j=0; j<M.length; j++) {
            if (M[i][j] == 1 && visisted[j] == 0) {
                visisted[j] = 1;
                dfs(M, visisted, j);
            }
        }
    }
}