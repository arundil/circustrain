package utiles.factoria;

import java.util.List;

public class GraphImpl<T> implements Graph <T>{
	
	private List<Vertex<T>> vertices;

	public GraphImpl(){
		vertices=CollectionsFactory.createListFactory().createList();
	}
	
	@Override
	public void addEdge(Vertex<T> v1, Vertex<T> v2) {
		if(!vertices.contains(v1)){
			throw new IllegalArgumentException("El vertice v1 no está en el grafo");
		}
		if(!vertices.contains(v2)){
			throw new IllegalArgumentException("El vertice v2 no está en el grafo");
		}
		v1.setAdjacent(v2);
		v2.setAdjacent(v1);

	}

	@Override
	public void addVertex(Vertex<T> v) {
		vertices.add(v);

	}

	@Override
	public Boolean hasEdge(Vertex<T> v1, Vertex<T> v2) {
		return v1.isAdjacent(v2);
	}
	
	public String toString(){
		return vertices.toString();
	}

	@Override
	public List<Vertex<T>> getVertexList() {
		return vertices;
	}

}
