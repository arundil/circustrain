package board;

import java.util.List;
import java.util.Set;

import performance.Performance;
import tipos.Filter;
import utiles.factoria.CollectionsFactory;

import Graph.GraphImpl;

public class BoardImpl extends GraphImpl implements Board {
	
	public BoardImpl(){
		super();
		
	}

	//Devuelve un Set de City
	@Override
	public Set<City> getCities() {
		return (Set<City>) this.getVertexSet();
	}

	//Devuelva un City dado el nombre de una ciudad
	@Override
	public City getCityByName(String name) {
		
		for(City c:(Set<City>)this.getVertexSet()){
			if(c.getName().equals(name)){
				return c;
			}
		}
		return null;
	}

	
	//Devuelve un List de ciudades que son Canadiense
	@Override
	public List<City> getCanadianCities() {
		List<City> canadianCities=CollectionsFactory.createListFactory().createList();
		Filter<City> isCanadian=new isCanadianFilter();
		for(City c:this.getCities()){
			if(isCanadian.exp(c)){
				canadianCities.add(c);
			}
		}
		return canadianCities;
	}

	
	//Recoge un performance y lo añade a una ciudad que no tenga aleatoriamente
	@Override
	public void addPerfomance(Performance performance) {
		// TODO Auto-generated method stub
		
	}

	//Devuelve el número de ciudades que tengan Performance
	@Override
	public Integer getCitiesWithPerfomance() {
		// TODO Auto-generated method stub
		return null;
	}
}
