import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Vertex {
    
    private String name;
    private List<Vertex> neighbors;
    private boolean isVisited;

    Vertex(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Vertex> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void addNeighbor(Vertex vertex) {
        this.neighbors.add(vertex);
    }

    @Override
    public String toString() {
        return "Vertex [name=" + name + "]";
    }
}

class DFS {

    private Stack<Vertex> stack = new Stack<>();
     
    public void dfs(List<Vertex> vertexList) {

        for(Vertex v: vertexList) {
            if (!v.isVisited()) {
                v.setVisited(true);
                dfsWithStack(v);
                // dfsWithRecurrsion(v);
            }
        }
    }

    public void dfsWithStack(Vertex rootVertex) {
        this.stack.add(rootVertex);
        rootVertex.setVisited(true);

        while(!stack.isEmpty()) {
            Vertex actualVertex = this.stack.pop();
            System.out.println(actualVertex+ " ");

            for(Vertex v : actualVertex.getNeighbors()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    this.stack.push(v);
                }
            }
        }
    }

    private void dfsWithRecurrsion(Vertex v) {
        System.out.println(v + " ");
        for (Vertex vertex: v.getNeighbors()) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfsWithRecurrsion(vertex);
            }
        }
    }


    public static void main(String[] args) {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");

        List<Vertex> list = new ArrayList<Vertex>();

        v1.addNeighbor(v2);
        v1.addNeighbor(v3);

        v3.addNeighbor(v4);
        v4.addNeighbor(v5);

        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);

        DFS dfs = new DFS();
        dfs.dfs(list);
        System.out.println();
    }
}