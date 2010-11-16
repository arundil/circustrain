package Graph;

import java.util.Set;

import utiles.factoria.CollectionsFactory;

public class GraphImpl implements Graph {
	
	private Set<Vertex> vertices;

	public GraphImpl(){
		vertices=CollectionsFactory.createSetFactory().createSet();
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
	public Set<? extends Vertex> getVertexSet() {
		return vertices;
	}

}
