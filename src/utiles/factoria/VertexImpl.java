package utiles.factoria;

import java.util.Set;


public class VertexImpl implements Vertex {
	
	private static Integer id=0;
	
	
	public Set<Vertex> adjacents;
	
	public VertexImpl(){
		id++;
		adjacents=CollectionsFactory.createSetFactory().createSet();
	}

	public Set<Vertex> getAdjacents() {
		return adjacents;
	}

	@Override
	public Boolean hasAdjacents() {
		return !adjacents.isEmpty();
	}

	@Override
	public void setAdjacent(Vertex v) {
		adjacents.add(v);
	
	}

	@Override
	public Boolean isAdjacent(Vertex v) {
		return adjacents.contains(v);
	}
}
