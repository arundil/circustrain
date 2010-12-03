package board;

import java.util.List;
import performance.Performance;


public interface Board {
	public void addCity(City c);
	public void addTrack(City c1,City c2);
	public List<City> getCities();
	public City getCityByName(String name);
	public List<City> getCanadianCities();
	public Integer countCitiesWithPerfomance();
	public List<City> getCitiesWithPerfomance();
	public List<City> getCitiesWithoutPerformance();
	public City addPerfomanceInRandomCity(Performance performance);
	
}
