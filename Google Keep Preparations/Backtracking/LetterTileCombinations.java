import java.util.Arrays;

class LetterTileCombinations {
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        return dfs(chars,visited);
    }

    private int dfs(char[] chars, boolean[] visited){
        int count = 0;
        for(int i = 0; i < chars.length; i++){
            if(visited[i]) continue;
            if(i - 1 >= 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            count++;
            count+=dfs(chars, visited);
            visited[i] = false;
        }
        return count;
    }
}