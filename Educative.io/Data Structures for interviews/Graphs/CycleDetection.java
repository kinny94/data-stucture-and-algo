import java.util.ArrayList;
import java.util.List;

class Vertex {
    
    private String name;
    private boolean isVisited;
    private boolean isBeingVisited;
    private List<Vertex> neighbors;

    Vertex(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbors(Vertex vertex) {
        this.neighbors.add(vertex);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public boolean isBeingVisited() {
        return isBeingVisited;
    }

    public void setBeingVisited(boolean isBeingVisited) {
        this.isBeingVisited = isBeingVisited;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Vertex> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Vertex [name=" + name + "]";
    }

}

class CycleDetection {
    public void cycleDetect(List<Vertex> neighbors) {
        for (Vertex v: neighbors) {
            if (!v.isVisited()) {
                dfs(v);
            }
        }
    }

    public void dfs(Vertex vertex) {
        
        System.out.println("DFS on vertex " + vertex);
        vertex.setBeingVisited(true);
        
        for(Vertex v: vertex.getNeighbors()) {
            System.out.println("Visiting the neighbors of vertex " + v);
            if (v.isBeingVisited()) {
                System.out.println("Cycle detected!!!");
                return;
            }

            if (!v.isVisited()) {
                v.setVisited(true);
                dfs(v);
            }
        }

        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }

    public static void main(String[] args) {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Vertex v6 = new Vertex("6");

        v1.addNeighbors(v2);
        v1.addNeighbors(v3);
        v2.addNeighbors(v3);
        v4.addNeighbors(v1);
        v4.addNeighbors(v5);
        v5.addNeighbors(v6);
        v6.addNeighbors(v4);

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(v1);
        vertexList.add(v2);
        vertexList.add(v3);
        vertexList.add(v4);
        vertexList.add(v5);
        vertexList.add(v6);

        CycleDetection cd = new CycleDetection();
        cd.cycleDetect(vertexList);
    }
}