package board;

import java.util.List;
import java.util.Set;

import performance.Performance;
import tipos.CollectionsUtils;
import tipos.Filter;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.Graph;
import utiles.factoria.GraphImpl;
import utiles.factoria.Vertex;


public class BoardImpl implements Board {
	
	Graph gameMap;
	
	public BoardImpl(){
		gameMap=CollectionsFactory.createGraphFactory().createGraph();
	}

	//Devuelve un Set de City
	@Override
	public List<City> getCities() {
		List<City> cityList=CollectionsFactory.createListFactory().createList();
			for(Vertex<City> v:gameMap.getVertexList()){
				cityList.add(v.getContents());
			}
		return cityList;
	}

	//Devuelva un City dado el nombre de una ciudad
	@Override
	public City getCityByName(String name) {
		
		for(City c:(List<City>)this.getVertexList()){
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
	public City addPerfomanceInRandomCity(Performance performance) {
		
		
	}

	//Devuelve el número de ciudades que tengan Performance
	@Override
	public Integer getCitiesWithPerfomance() {
		return CollectionsUtils.count(this.getVertexList(), new hasPerfomanceFilter());
	}

	@Override
	public void addCity(City c) {
		Vertex<City> newVertex=CollectionsFactory.createVertexFactory().createVertex();
		newVertex.addContents(c);
		this.gameMap.addVertex(newVertex);
	}
}
