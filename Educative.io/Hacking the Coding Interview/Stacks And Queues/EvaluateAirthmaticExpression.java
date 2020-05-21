class Node {
    public int data;
    public List<Node> neighbors = new ArrayList<Node>();
    public Node(int d) {data = d;}
}

class Graph {
    private static Node clone_rec(
    Node root, 
    HashMap<Node, Node> nodes_completed) {
        if (root == null) {
            return null;
        }
        
        Node pNew = new Node(root.data);
        nodes_completed.put(root, pNew);
        
        for (Node p : root.neighbors) {
            Node x = nodes_completed.get(p);
            if (x == null){
                pNew.neighbors.add(clone_rec(p, nodes_completed));
            } else {
                pNew.neighbors.add(x);
            }
        }
        return pNew;
    }
    
    public static Node clone(Node root) {
        HashMap<Node, Node> nodes_completed = 
        new HashMap<Node, Node>();
        
        return clone_rec(root, nodes_completed);
    }
    
    public static void main(String[] args) {
        ArrayList<Node> vertices = CloneGraph.create_test_graph_undirected(7, 18);
        
        CloneGraph.print_graph(vertices.get(0));
        
        Node cp = clone(vertices.get(0));
        System.out.println();
        System.out.println("After copy.");
        CloneGraph.print_graph(cp);
        
        HashSet<Node> set = new HashSet<Node>();
        System.out.println(CloneGraph.are_graphs_equal_rec(vertices.get(0), cp, set));
    }  
}
