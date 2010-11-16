package Graph;

import java.util.Set;

public interface Graph {

	public void addVertex(Vertex v);
	public void addEdge(Vertex v1,Vertex v2);
	public Boolean hasEdge(Vertex v1,Vertex v2);
	public Set<? extends Vertex> getVertexSet();
	
}
