import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Vertex {

    private String data;
    private boolean isVisited;
    private List<Vertex> neighbors;

    Vertex(String data) {
        this.data = data;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Vertex v) {
        this.neighbors.add(v);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Vertex> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Vertex [data=" + data + "]";
    }
}

class TopologicalSort {
    
    private Stack<Vertex> stack;

    TopologicalSort() {
        this.stack = new Stack<>();
    }

    public void dfs(Vertex v) {
        v.setVisited(true);
        for(Vertex vertex: v.getNeighbors()) {
            if (!vertex.isVisited()) {
                dfs(vertex);
            }
        }

        stack.push(v);
    }

    public Stack<Vertex> getStack() {
        return this.stack;
    }

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();
        List<Vertex> graph = new ArrayList<>();
        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).addNeighbor(graph.get(3));
        graph.get(3).addNeighbor(graph.get(1));
        graph.get(4).addNeighbor(graph.get(0));
        graph.get(4).addNeighbor(graph.get(1));
        graph.get(5).addNeighbor(graph.get(0));
        graph.get(5).addNeighbor(graph.get(2));

        for (int i=0;i<graph.size(); i++) {
            if (!graph.get(i).isVisited()) {
                ts.dfs(graph.get(i));
            }
        }

        Stack<Vertex> stack = ts.getStack();
        for (int i=0; i<graph.size(); i++) {
            Vertex vertex = stack.pop();
            System.out.println(vertex + " ");
        }
    }
}