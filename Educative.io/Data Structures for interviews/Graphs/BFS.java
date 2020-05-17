// not the complicated one on educative.io

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex {

    private int data;
    private List<Vertex> neighbors;
    private boolean visited;

    Vertex(int data) {
        this.data = data;
        neighbors = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Vertex> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addNeighbors(Vertex vertex) {
        this.neighbors.add(vertex);
    }

    @Override
    public String toString() {
        return "Vertex [data=" + data + "]";
    }
}


class BFS {
    
    public void bfs(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.setVisited(true);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.print(currentVertex.getData() + " ");

            for (int i=0; i<currentVertex.getNeighbors().size(); i++) {
                if (!currentVertex.getNeighbors().get(i).isVisited()) {
                    currentVertex.getNeighbors().get(i).setVisited(true);
                    queue.add(currentVertex.getNeighbors().get(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        v1.addNeighbors(v2);
        v1.addNeighbors(v4);

        v4.addNeighbors(v5);
        
        v2.addNeighbors(v3);
        bfs.bfs(v1);
        
    }
}