class CheckPaths {
    
    //Perfrom DFS Traversal starting from source and if you reach destination
    //then it means that there exist a path between source and destination
    //so return true and if you traverse the graph but can't reach destination
    //then simply return false.
    public static boolean checkPath(Graph g, int source, int destination) {
        if (source == destination){
            return true;
        }

        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you push it into stack
        boolean[] visited = new boolean[g.vertices];

        //Create Stack
        Stack<Integer> stack = new Stack<>(g.vertices);

        stack.push(source);
        visited[source] = true;

        //Traverse while stack is not empty
        while (!stack.isEmpty()) {

            //Pop a vertex/node from stack
            int current_node = stack.pop();

            //Get adjacent vertices to the current_node from the array,
            //and if only push unvisited adjacent vertices into stack
            //Before pushing into stack, check if it's the destination.
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;

            while (temp != null) {

                if (!visited[temp.data]) {

                    if (temp.data == destination) {
                        return true;
                    }

                    stack.push(temp.data);
                    visited[temp.data] = true;

                }

                temp = temp.nextNode;
            }

        } //end of while
        return false;
    }
}