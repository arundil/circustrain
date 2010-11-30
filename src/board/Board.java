package board;

import java.util.List;
import performance.Performance;


public interface Board {
	public void addCity(City c);
	public void addRoad(City c1,City c2);
	public List<City> getCities();
	public City getCityByName(String name);
	public List<City> getCanadianCities();
	public Integer getCitiesWithPerfomance();
	public City addPerfomanceInRandomCity(Performance performance);
}
