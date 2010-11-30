package utiles.factoria;

import java.util.List;

public class GraphImpl implements Graph {
	
	private List<Vertex> vertices;

	public GraphImpl(){
		vertices=CollectionsFactory.createListFactory().createList();
	}
	
	@Override
	public void addEdge(Vertex v1, Vertex v2) {
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
	public void addVertex(Vertex v) {
		vertices.add(v);

	}

	@Override
	public Boolean hasEdge(Vertex v1, Vertex v2) {
		return v1.isAdjacent(v2);
	}
	
	public String toString(){
		return vertices.toString();
	}

	@Override
	public List<Vertex> getVertexList() {
		return vertices;
	}

}
