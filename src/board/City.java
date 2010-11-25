package board;

import java.util.Set;



import performance.Performance;

public interface City {
	
	public Boolean isCanada();
	
	
	public Boolean hasPerfomance();
	public Performance getPerformance();
	public void setPerfomance(Performance performance);
	
	public Set<City> maxMovement(Integer jump);
	public Set<City> exactMovement(Integer jump);
	public String getName();
	
	public String toString();
		
}
