package board;

import java.util.List;
import java.util.Set;

import performance.Performance;
import utiles.factoria.Graph;


public interface Board {
	public void addCity(City c);
	public List<City> getCities();
	public City getCityByName(String name);
	public List<City> getCanadianCities();
	public Integer getCitiesWithPerfomance();
	public City addPerfomanceInRandomCity(Performance performance);	
}
