package board;

import java.util.List;
import java.util.Set;

import performance.Performance;
import utiles.factoria.Vertex;

public interface City extends Vertex{
	
	public Boolean isCanada();
	
	
	public Boolean hasPerfomance();
	public Performance getPerformance();
	public void setPerfomance(Performance performance);
	
	public List<City> maxMovement(Integer jump);
	public List<City> exactMovement(Integer jump);
	public String getName();
	public List<City> getCitiesAdjacents();
	public void removePerformance();

	public String toString();
		
}
