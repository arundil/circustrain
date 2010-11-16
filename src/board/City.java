package board;

import java.util.Set;

import Graph.Vertex;


import performance.Performance;

public interface City extends Vertex {
	
	public Boolean getCanada();
	
	public Boolean hasPerfomance();
	public Performance getPerformance();
	public void setPerfomance(Performance performance);
	
	public Set<City> maxMovement(Integer jump);
	public Set<City> exactMovement(Integer jump);
	
	public String toString();
}
