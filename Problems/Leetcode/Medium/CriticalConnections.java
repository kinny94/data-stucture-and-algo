/*
    A connection is critical when it is a single point of failure: if it is down, there is no other way for the nodes on its two ends to reach each other.
    If a set of nodes in a graph are part of a cycle, then even if one link goes down, the nodes on the two ends of that link will have another way to reach each other.
    So this reduces the problem to finding out cycles in the graph. Any node that does not fall into a cycle, is part of a critical connection.

    Run a DFS traversal on the graph. As you're visiting a node, save the timestamp of your visit with the node. 
    After you have visited all of the nodes, for each node find out (and store as a property of this node) the timestamp of oldest visited node that is reachable 
    from this node (let's call this "lowlink", but it can be anything). At the end, you'd find out that the nodes that belong to same cycle have the same lowlink values.

    Since the purpose of timestamp is only to find out the order in which nodes were traversed, you can use a simple integer starting from 0 and increment it every time you visit a new node.
*/
class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        // result list
        List<List<Integer>> criticalConnectionsList = new ArrayList<>();
        
        // create the graph
        Map<Integer, List<Integer>> graph =  new HashMap<>();
        
         // Keep track of Strongly Conected Compoments low-link value
        int[] lowLinkValues = new int[n];
        
        // visited array
        boolean[] visited = new boolean[n]; 
        
        // keep track of cycles
        int time = 0;
        
        // fill the graph
        for (List<Integer> connection: connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            
            // ading connectiosnc zo they are both connected
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for (int i=0; i<graph.size(); i++) {
            if (!visited[i]) {
                dfs(i, i, visited, lowLinkValues, graph, time, criticalConnectionsList);
            }
        }
        
        return criticalConnectionsList;
    }
    
    private void dfs(int currentVertex,  int parentVertex, boolean[] visited, int[] lowLinkValues, Map<Integer, List<Integer>> graph, int time, List<List<Integer>> criticalConnectionsList) {
        
        // Increment time per cycle
        time++;
        
        // set the current vertex low link value to the current time
        lowLinkValues[currentVertex] = time;
        
        // set discovered value to ime to avoid comparison
        int discoveredValue = time;
        
        visited[currentVertex] = true;
        
        // Iterate through edges
        for (int vertex: graph.get(currentVertex)) {
            
            // avoid comparison in reverse
            if (vertex == parentVertex) continue;
        
            if (!visited[vertex]) {
                dfs(vertex, currentVertex, visited, lowLinkValues, graph, time, criticalConnectionsList);
                
                // This means there is an edge that connects strongly connected components
                if (discoveredValue < lowLinkValues[vertex]) {
                    criticalConnectionsList.add(Arrays.asList(currentVertex, vertex));
                }
            }
            
            // Update lowlinkValues
            lowLinkValues[currentVertex] = Math.min(lowLinkValues[currentVertex], lowLinkValues[vertex]);
        }
    }
}