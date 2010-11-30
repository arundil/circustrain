package utiles.factoria;

import java.util.Set;

public interface Vertex{
	
	public Boolean hasAdjacents();
	public Set<Vertex> getAdjacents();
	
	public void setAdjacent(Vertex v);
	
	public Boolean isAdjacent(Vertex v);


}
