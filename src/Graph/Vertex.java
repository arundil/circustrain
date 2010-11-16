package Graph;

import java.util.Set;

public interface Vertex {
	
	public void setName(String name);
	public String getName();
	
	public Boolean hasAdjacents();
	public Set<? extends Vertex> getAdjacents();
	
	public void setAdjacent(Vertex v);
	
	public Boolean isAdjacent(Vertex v);

}
