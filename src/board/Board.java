package board;

import java.util.List;
import java.util.Set;

import performance.Performance;

import Graph.Graph;

public interface Board extends Graph {
	public Set<City> getCities();
	public City getCityByName(String name);
	public List<City> getCanadianCities();
	public Integer getCitiesWithPerfomance();
	public void addPerfomance(Performance performance);	
}
