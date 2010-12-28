package board;

import java.util.List;
import performance.Performance;


public interface Board {
	public void addCity(City city);
	public void addTrack(City city1,City city2);
	public List<City> getCities();
	public City getCityByName(String name);
	public List<City> getCanadianCities();
	public Integer countCitiesWithPerfomance();
	public List<City> getCitiesWithPerfomance();
	public List<City> getCitiesWithoutPerformance();
	public City addPerfomanceInRandomCity(Performance performance);
	public void removeAllPerformances();
}
