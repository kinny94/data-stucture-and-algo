import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
    
    private double weight;
    private Vertex startVertex;
    private Vertex targetVertex;

    public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}

class Vertex implements Comparable<Vertex> {

    private String name;
    private List<Edge> neighbors;
    private boolean isVisited;
    private Vertex predecessor;
    private double distance = Double.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbors(Edge edge) {
        this.neighbors.add(edge);
    }

    @Override
    public String toString() {
        return "Vertex [name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Edge> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Vertex vertex) {
       return Double.compare(this.distance, vertex.getDistance());
    }
    
}

class Dijkastra {
    public void computePath(Vertex startingVertex) {
        startingVertex.setDistance(0);
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(startingVertex);
        while(!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();
            for (Edge edge: currentVertex.getNeighbors()) {
                Vertex v = edge.getTargetVertex();
                double newDistance = currentVertex.getDistance() + edge.getWeight();
                if (newDistance < v.getDistance()) {
                    v.setDistance(newDistance);
                    v.setPredecessor(currentVertex);
                    pq.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPath(Vertex targetVertex) {
        List<Vertex> shortestPAthToTarget = new ArrayList<>();
        for (Vertex v = targetVertex; v !=null; v = v.getPredecessor()) {
            shortestPAthToTarget.add(v);
        }

        Collections.sort(shortestPAthToTarget);
        return shortestPAthToTarget;
    }

    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");

        vertex1.addNeighbors(new Edge(1, vertex1, vertex2));
        vertex1.addNeighbors(new Edge(3, vertex1, vertex3));
        vertex2.addNeighbors(new Edge(1, vertex2, vertex3));

        Dijkastra djks = new Dijkastra();
        djks.computePath(vertex1);
        System.out.println(djks.getShortestPath(vertex3));
    }
}