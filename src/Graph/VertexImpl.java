package Graph;

import java.util.Set;

public class VertexImpl implements Vertex {
	
	private String name;
	public Set<Vertex> adjacents;
	
	public VertexImpl(String name){
		this.name=name;
	}

	@Override
	public Set<? extends Vertex> getAdjacents() {
		return adjacents;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Boolean hasAdjacents() {
		return !adjacents.isEmpty();
	}

	@Override
	public void setName(String name) {
		this.name=name;

	}

	@Override
	public void setAdjacent(Vertex v) {
		this.adjacents.add(v);
		
	}

	@Override
	public Boolean isAdjacent(Vertex v) {
		return adjacents.contains(v);
	}

}
