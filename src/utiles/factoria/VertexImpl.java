package utiles.factoria;

import java.util.Set;


public class VertexImpl<T> implements Vertex<T> {
	
	private static Integer id=0;
	
	private T contents;
	
	public Set<Vertex<T>> adjacents;
	
	public VertexImpl(){
		id++;
		adjacents=CollectionsFactory.createSetFactory().createSet();
	}

	@Override
	public Set<Vertex<T>> getAdjacents() {
		return adjacents;
	}



	@Override
	public Boolean hasAdjacents() {
		return !adjacents.isEmpty();
	}

	@Override
	public void setAdjacent(Vertex<T> v) {
		this.adjacents.add(v);
		
	}

	@Override
	public Boolean isAdjacent(Vertex<T> v) {
		return adjacents.contains(v);
	}

	@Override
	public void addContents(T object) {
		this.contents=object;
	}

	@Override
	public T getContents() {
		return contents;
	}

}
