package board;

import java.util.List;
import performance.Performance;
import tipos.CollectionsUtils;
import tipos.Filter;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.Graph;
import utiles.factoria.Vertex;


public class BoardImpl implements Board {
	
	Graph gameMap;
	
	//Constructor sin parametros
	public BoardImpl(){
		gameMap=CollectionsFactory.createGraphFactory().createGraph();
	}
	
	//Constructor desde un archivo
	public BoardImpl(String file){
		gameMap=CollectionsFactory.createGraphFactory().createGraph();
		open
		
	}


	//Devuelve un Set de City
	@Override
	public List<City> getCities() {
		List<City> cityList=CollectionsFactory.createListFactory().createList();
			for(Vertex v:gameMap.getVertexList()){
				cityList.add((City)v);
			}
		return cityList;
	}

	//Devuelva un City dado el nombre de una ciudad
	@Override
	public City getCityByName(String name) {
		
		for(City c:this.getCities()){
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
		
		return null;
	}

	//Devuelve el número de ciudades que tengan Performance
	@Override
	public Integer getCitiesWithPerfomance() {
		return CollectionsUtils.count(this.getCities(), new hasPerfomanceFilter());
	}

	@Override
	public void addCity(City c) {
		Vertex v=(Vertex)c;
		gameMap.addVertex(v);
	}

	@Override
	public void addRoad(City c1, City c2) {
			this.gameMap.addEdge(c1, c2);
	}
	public String toString(){
		return this.getCities().toString();
	}
}
