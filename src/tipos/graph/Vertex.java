package tipos.graph;

import java.util.Set;

public interface Vertex<V> {
	V getLabel();
	Set<Vertex<V>> getAdjacents();
	boolean hasAdjacents();
	boolean add(Vertex<V> v);
	boolean remove(Vertex<V> v);
	
	public void setLabel(V l);
	Integer getCode();
}
