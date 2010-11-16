package board;

import java.util.Set;

import Graph.Graph;

public interface Board extends Graph {
	public Set<City> getCities();
	public City getCityByName(String name);
	
}
