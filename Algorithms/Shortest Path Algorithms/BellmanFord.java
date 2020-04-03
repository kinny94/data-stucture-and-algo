import java.util.ArrayList;
import java.util.List;

class Vertex {

	private int id;
	private boolean visited;
	private int minDistance = Integer.MAX_VALUE;
	private Vertex previousVertex;
	private List<Edge> adjacencies;

	public Vertex(int id) {
		this.id = id;
		this.adjacencies = new ArrayList<>();
	}

	public int getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(int minDistance) {
		this.minDistance = minDistance;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}
	
	public void addEdge(Edge edge){
		this.adjacencies.add(edge);
	}

	public List<Edge> getAdjacencies() {
		return adjacencies;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	@Override
	public String toString() {
		return ""+this.id;
	}
}


class Edge {

	private int weight;
	private Vertex startVertex;
	private Vertex targetVertex;

	public Edge(Vertex startVertex, Vertex targetVertex, int weight) {
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
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


class BellmanFord {
    
	private List<Vertex> vertexList;
	private List<Edge> edgeList;

	public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}

	public void bellmanFord(Vertex sourceVertex, Vertex targetVertex) {

		sourceVertex.setMinDistance(0);

		for (Vertex vertex : vertexList) {
			for (Edge edge : edgeList) {
				
				/*
				 * ez adja a O(V*E) complexityt mindig, nem lesz olyan mint Djokstra algoritmusnal ahol a priority queue
				 * 	pontos implekemntalasatol fugg a futasi ido
				 * 		Itt lehet hasznalni listat vagy arrayt teljesen mindegx !!!
				 *      DE ... lehet hogy O(E) = V*V es igy egy V*V*V algoritmust kapunk ... tehat lassabb a Dijkstra algoritmusnal mindig
				 *      		~ a Dijkstra akar linearois time cmplecxitivel is tudna futni
				 */

				if ( edge.getStartVertex().getMinDistance() == Integer.MAX_VALUE ) {
					continue;
				}

				int newDistance = edge.getStartVertex().getMinDistance() + edge.getWeight();

				if (newDistance < edge.getTargetVertex().getMinDistance()) {
					edge.getTargetVertex().setMinDistance(newDistance);
					edge.getTargetVertex().setPreviousVertex(edge.getStartVertex());
				}
			}
		}

		for (Edge edge : edgeList) {
			if (edge.getStartVertex().getMinDistance() != Integer.MAX_VALUE) {
				if ( hasCycle(edge) ) {
					System.out.println("Negative edge weight cycles detected!");
					return;
				}
			}
		}

		if (targetVertex.getMinDistance() != Integer.MAX_VALUE) {
			System.out.println("There is a shortest path from sourco to target, with cost: " + targetVertex.getMinDistance());
			
			Vertex actualVErtex = targetVertex;
			while( actualVErtex.getPreviousVertex() != null ){
				System.out.print(actualVErtex+"-");
				actualVErtex=actualVErtex.getPreviousVertex();
			}
			
		} else {
			System.out.println("There is no path from source to target...");
		}
	}
	
	private boolean hasCycle(Edge edge){
		return edge.getTargetVertex().getMinDistance() > edge.getStartVertex().getMinDistance() + edge.getWeight();
	}

    public static void main(String[] args) {
        
        List<Vertex> vertexList = new ArrayList<>();
		
		vertexList.add(new Vertex(1));
		vertexList.add(new Vertex(2));
		vertexList.add(new Vertex(3));
		vertexList.add(new Vertex(4));
		vertexList.add(new Vertex(5));
		
		List<Edge> edgeList = new ArrayList<>();
		edgeList.add(new Edge(vertexList.get(0),vertexList.get(1),5));
		edgeList.add(new Edge(vertexList.get(0),vertexList.get(3),-4));
		edgeList.add(new Edge(vertexList.get(0),vertexList.get(2),8));  
		edgeList.add(new Edge(vertexList.get(1),vertexList.get(0),-2));
		edgeList.add(new Edge(vertexList.get(2),vertexList.get(1),-3));
		edgeList.add(new Edge(vertexList.get(2),vertexList.get(3),9));
		edgeList.add(new Edge(vertexList.get(3),vertexList.get(1),7));
		edgeList.add(new Edge(vertexList.get(4),vertexList.get(0),6));
		edgeList.add(new Edge(vertexList.get(4),vertexList.get(2),7));
		
		BellmanFord bellmannFordAlgorithm = new BellmanFord(vertexList, edgeList);
		bellmannFordAlgorithm.bellmanFord(vertexList.get(4),vertexList.get(3));
    }
}