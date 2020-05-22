class vertex {
    private int id;
    private boolean visited;
    
    public vertex(int id, boolean visited) {
        super();
        this.id = id;
        this.visited = visited;
    }
    
    int getId() {
        return id;
    }
    
    void setId(int id) {
        this.id = id;
    }
    
    boolean isVisited() {
        return visited;
    }
    
    void setVisited(boolean visited) {
        this.visited = visited;
    }
}

class edge {
    private int weight;
    private boolean visited;
    private vertex src;
    private vertex dest;
    
    public edge(int weight, boolean visited, vertex src,
    vertex dest) {
        this.weight = weight;
        this.visited = visited;
        this.src = src;
        this.dest = dest;
    }
    
    int getWeight() {
        return weight;
    }
    
    void setWeight(int weight) {
        this.weight = weight;
    }
    
    boolean isVisited() {
        return visited;
    }
    
    void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    vertex getSrc() {
        return src;
    }
    
    void setSrc(vertex src) {
        this.src = src;
    }
    
    vertex getDest() {
        return dest;
    }
    
    void setDest(vertex dest) {
        this.dest = dest;
    }
}


class graph {
    private List<vertex> g;   //vertices
    private List<edge> e;     //edges
    
    int findMinSpanningTree() {
        //TODO: Write - Your - Code
        return -1;
    }
    
    public graph(List<vertex> g, List<edge> e) {
        super();
        this.g = g;
        this.e = e;
    }
    
    public List<vertex> getG() {
        return g;
    }
    
    public void setG(List<vertex> g) {
        this.g = g;
    }
    
    public List<edge> getE() {
        return e;
    }
    
    public void setE(List<edge> e) {
        this.e = e;
    }
    
    // This method returns the vertex with a given id if it
    // already exists in the graph, returns NULL otherwise
    vertex vertexExists(int id) {
        for (int i = 0; i < g.size(); i++) {
            if (g.get(i).getId() == id) {
                return g.get(i);
            }
        }
        return null;
    }
    
    // This method generates the graph with v vertices
    // and e edges
    void generateGraph(int vertices,
    List<ArrayList<Integer>> edges) {
        // create vertices
        for (int i = 0; i < vertices; i++) {
            vertex v = new vertex(i + 1, false);
            g.add(v);
        }
        
        // create edges
        for (int i = 0; i < edges.size(); i++) {
            vertex src = vertexExists(edges.get(i).get(1));
            vertex dest = vertexExists(edges.get(i).get(2));
            edge e = new edge(edges.get(i).get(0), false, src,
            dest);
            getE().add(e);
        }
    }
    
    String printGraph() {
        String result = "";
        
        for (int i = 0; i < e.size(); i++) {
            result += e.get(i).getSrc().getId() + "->"
            + e.get(i).getDest().getId() + "["
            + e.get(i).getWeight() + ", "
            + e.get(i).isVisited() + "]  ";
        }
        return result;
    }
    
    void printMst(int w) {
        System.out.println("MST");
        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).isVisited() == true) {
                System.out.println(e.get(i).getSrc().getId() + "->"
                + e.get(i).getDest().getId());
            }
        }
        System.out.println("weight: " + w);
        System.out.println();
    }
};