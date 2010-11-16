package board;

import Graph.Graph;

public interface Board extends Graph {
	
	public void addCity(City city);
	public String toString();
}
