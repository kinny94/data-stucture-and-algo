class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        Set<Integer> visited = new HashSet<>();
        dfs(0, graph, visited);
        return visited.size() == n;
    }
    private void dfs(int node, List<Integer>[] graph, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        for (int next : graph[node]) {
            dfs(next, graph, visited);
        }
    }
}