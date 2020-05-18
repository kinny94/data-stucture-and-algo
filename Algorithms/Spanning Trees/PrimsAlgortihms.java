import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {

    private double weight;
    private Vertex startVertex;
    private Vertex targetVertex;

	public Edge(Vertex startVertex, Vertex targetVertex, double weight) {
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

	@Override
	public int compareTo(Edge edge) {
		return Double.compare(this.weight, edge.getWeight());
	}
}

class Vertex {
	
	private String name;
	private boolean visited;
	private Vertex previousVertex;
	private List<Edge> adjacencies;

	public Vertex(String name) {
		this.name = name;
		this.adjacencies = new ArrayList<>();
	}

	public void addEdge(Edge edge) {
		this.adjacencies.add(edge);
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public List<Edge> getAdjacencies() {
		return adjacencies;
	}

	public void setAdjacencies(List<Edge> adjacencies) {
		this.adjacencies = adjacencies;
	}
}

class PrimsAlgortihms {
	
	private List<Vertex> unvisistedVertexes;
	private List<Edge> spanningTree;
	private PriorityQueue<Edge> edgeHeap;
	private double fullCost;

	PrimsAlgortihms(List<Vertex> unvisitedList) {
		this.spanningTree = new ArrayList<>();
		this.unvisistedVertexes = unvisitedList;
		this.edgeHeap = new PriorityQueue<>();
	}

	public void primsAlgo(Vertex vertex) {
		this.unvisistedVertexes.remove(vertex);

		while(!unvisistedVertexes.isEmpty()) {
			for (Edge edge: vertex.getAdjacencies()) {
				if (this.unvisistedVertexes.contains(edge.getTargetVertex())) {
					this.edgeHeap.add(edge);
				}
			}

			Edge minEdge = this.edgeHeap.remove();
			this.spanningTree.add(minEdge);
			this.fullCost += minEdge.getWeight();

			vertex = minEdge.getTargetVertex();
			this.unvisistedVertexes.remove(vertex);
		}
	}

	public void showMST() {

		System.out.println("Thie minimum spanning tree cost: " + this.fullCost);
		for (Edge edge: this.spanningTree) {
			System.out.println(edge.getStartVertex() + " - " + edge.getTargetVertex());	
		}
	}

	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();
		
		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		
		vertexList.add(vertex0);
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		
		vertex0.addEdge(new Edge(vertex0, vertex1, 1));	
		vertex0.addEdge(new Edge(vertex0, vertex2, 1));	
		vertex1.addEdge(new Edge(vertex1, vertex2, 10));
		
		vertex1.addEdge(new Edge(vertex1, vertex0, 1));	
		vertex2.addEdge(new Edge(vertex2, vertex0, 1));	
		vertex2.addEdge(new Edge(vertex2, vertex1, 10));
		
		
		PrimsAlgortihms algorithm = new PrimsAlgortihms(vertexList);
		
		algorithm.primsAlgo(vertex2);
		algorithm.showMST();
	}
}

