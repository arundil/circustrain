package utiles.factoria;

import java.util.Set;

public interface Vertex <T>{
	
	public Boolean hasAdjacents();
	public Set<Vertex <T>> getAdjacents();
	
	public void setAdjacent(Vertex<T> v);
	
	public Boolean isAdjacent(Vertex<T> v);
	
	public void addContents(T object);
	public T getContents();

}
