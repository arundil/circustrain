package utiles.factoria;

import java.util.List;

public interface Graph<T> {

	public void addVertex(Vertex<T> v);
	public void addEdge(Vertex<T> v1,Vertex<T> v2);
	public Boolean hasEdge(Vertex<T> v1,Vertex<T> v2);
	public List<Vertex<T>> getVertexList();
	
}
