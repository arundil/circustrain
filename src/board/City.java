package board;

import java.util.Set;

import performance.Performance;

public interface City extends Vertex<City>{
	
	public Boolean hasPerfomance();
	public Performance getPerformance();
	
	public Set<City> maxMovement(Integer jump);
	public Set<City> exactMovement(Integer jump);
	
	
	
}
