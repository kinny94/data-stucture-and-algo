import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Vertex {

    private String name;
    private Node node; // assign a disjoint node to a vertex

    Vertex(String name) {
        this.name = name;
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

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
}

// we first sort the edges of the graph according to the edge weight, hence the comparable implementation
class Edge implements Comparable<Edge> {

	private double weight;
	private Vertex startVertex;
	private Vertex targetVertex;

	Edge(Vertex startVertex, Vertex targetVertex, double weight) {
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

// these are gonna be the disjoint sets
class Node {

	private int id;
	private int rank; // something like the depth of the tree
	private Node parent;

	Node(int rank, int id, Node parent) {
		this.rank = rank;
		this.id = id;
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
}

class DisJointSet {

	private int nodeCount = 0;
	private int setCount = 0;
	private List<Node> rootNodes; // representatives

	public DisJointSet(List<Vertex> vertexes) {
		this.rootNodes = new ArrayList<>(vertexes.size());
		makeSets(vertexes);
	}

	// to find the representative of the current node
	public int find(Node node) {

		Node currentNode = node;
		
		while(currentNode.getParent() != null) {
			currentNode = currentNode.getParent();
		}

		Node rootNode = currentNode;
		currentNode = node;
		
		while(currentNode != rootNode) {
			Node temp = currentNode.getParent();
			currentNode.setParent(rootNode);
			currentNode = temp;
		}

		return currentNode.getId();
	} 

	public void union(Node node1, Node node2) {

		int index1 = find(node1);
		int index2 = find(node2);

		if (index1 == index2) {
			return;
		}

		Node root1 = this.rootNodes.get(index1);
		Node root2 = this.rootNodes.get(index2);

		if (root1.getRank() < root2.getRank()) {
			root1.setParent(root2);
		} else if (root1.getRank() > root2.getRank()) {
			root2.setParent(root1);
		} else {
			root2.setParent(root1);
			root1.setRank(root1.getRank() + 1);
		}

		this.setCount--;
	}

	private void makeSets(List<Vertex> vertexes) {
		for (Vertex v: vertexes) {
			makeSets(v);
		}
	}

	private void makeSets(Vertex vertex) {
		Node node = new Node(0, rootNodes.size(), null);
		vertex.setNode(node);
		this.rootNodes.add(node);
		this.setCount++;
		this.nodeCount++;	
	}
	
}

class KruskalAlgorithm {
	
	public void spanningTree(List<Vertex> vertexList, List<Edge> edgeList) {

		DisJointSet disjointSet = new DisJointSet(vertexList);
		List<Edge> mst = new ArrayList<>();
		Collections.sort(edgeList);

		for (Edge edge: edgeList) {
			Vertex u = edge.getStartVertex();
			Vertex v = edge.getTargetVertex();

			if (disjointSet.find(u.getNode()) != disjointSet.find(v.getNode())) {
				mst.add(edge);
				disjointSet.union(u.getNode(), v.getNode());
			}
		}

		for (Edge edge: mst) {
			System.out.println(edge.getStartVertex() + " " + edge.getTargetVertex() + " -- ");
		}
	}

	public static void main(String[] args) {

		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(new Vertex("A"));
		vertexList.add(new Vertex("B"));
		vertexList.add(new Vertex("C"));
		vertexList.add(new Vertex("D"));
		vertexList.add(new Vertex("E"));
		vertexList.add(new Vertex("F"));
		vertexList.add(new Vertex("G"));
		vertexList.add(new Vertex("H"));
		
		List<Edge> edgeList = new ArrayList<>();
		edgeList.add(new Edge(vertexList.get(0), vertexList.get(1), 3));
		edgeList.add(new Edge(vertexList.get(0), vertexList.get(2), 2));
		edgeList.add(new Edge(vertexList.get(0), vertexList.get(3), 5));
		edgeList.add(new Edge(vertexList.get(1), vertexList.get(5), 13));
		edgeList.add(new Edge(vertexList.get(1), vertexList.get(3), 2));
		edgeList.add(new Edge(vertexList.get(2), vertexList.get(4), 5));
		edgeList.add(new Edge(vertexList.get(2), vertexList.get(3), 2));
		edgeList.add(new Edge(vertexList.get(3), vertexList.get(4), 4));
		edgeList.add(new Edge(vertexList.get(3), vertexList.get(5), 6));
		edgeList.add(new Edge(vertexList.get(3), vertexList.get(6), 3));
		edgeList.add(new Edge(vertexList.get(4), vertexList.get(6), 6));
		edgeList.add(new Edge(vertexList.get(5), vertexList.get(6), 2));
		edgeList.add(new Edge(vertexList.get(5), vertexList.get(7), 3));
		edgeList.add(new Edge(vertexList.get(6), vertexList.get(7), 6));
		
		KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm();
		kruskalAlgorithm.spanningTree(vertexList, edgeList);
	}
}