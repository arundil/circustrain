package board;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import performance.Performance;
import tipos.CollectionsUtils;
import tipos.Filter;
import tipos.reverseFilter;
import tipos.unionFilter;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.Graph;
import utiles.factoria.ReadFile;
import utiles.factoria.Vertex;


public class BoardImpl implements Board {
	
	Graph gameMap;
	
	Filter<City> hasPerformance=new hasPerfomanceFilter();
	Filter<City> hasNotPerformance=new reverseFilter<City>(hasPerformance);
	Filter<City> isCanadian=new isCanadianFilter();
	Filter<City> isNotCanadian=new reverseFilter<City>(isCanadian);
	
	//Constructor sin parametros
	public BoardImpl(){
		gameMap=CollectionsFactory.createGraphFactory().createGraph();
	}
	
	//Constructor desde un archivo
	public BoardImpl(String file){
		
		this();
		String fileLine=null;
		BufferedReader fileReader = null;
		try {
			//Soluciona el problema cuando movemos el trabajo de un ordenador a otro.
			fileReader = ReadFile.readTextFile(System.getProperty("user.dir")+file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		


			try {
				while ((fileLine = fileReader.readLine())!=null) {
					   String []readedString=fileLine.split(",");
					   if(readedString[0].equals("C")){
						   Boolean isCanada=new Boolean(readedString[2]);
						   String cityName=readedString[1];
						   addCity(new CityImpl(cityName,isCanada));
					   }
					   
					   if(readedString[0].equals("R")){
						   City c1=getCityByName(readedString[1]);
						   City c2=getCityByName(readedString[2]);
						   addTrack(c1, c2);
					   }
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   



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
		Filter<City> notCandadianWithoutPerformanceFilter=new unionFilter<City>(hasNotPerformance, isNotCanadian);
		City city=this.getRandomCity(notCandadianWithoutPerformanceFilter);
		city.setPerfomance(performance);
		return city;
	}

	//Devuelve el n�mero de ciudades que tengan Performance

	public Integer countCitiesWithPerfomance() {
		return CollectionsUtils.count(this.getCities(), hasPerformance);
	}
	
	public List<City> getCitiesWithoutPerformance() {
		
		return CollectionsUtils.filteredList(this.getCities(),hasNotPerformance);
	}

	@Override
	public void addCity(City c) {
		Vertex v=(Vertex)c;
		gameMap.addVertex(v);
	}

	@Override
	public void addTrack(City c1, City c2) {
			this.gameMap.addEdge(c1, c2);
	}
	public String toString(){
		String stringToPrint="";
		for (City c:this.getCities()){
			stringToPrint=stringToPrint+c.getName()+"("+c.getAdjacents().toString()+")\r\n";
		}
		return stringToPrint;
	}

	@Override
	public List<City> getCitiesWithPerfomance() {
		return CollectionsUtils.filteredList(this.getCities(), hasPerformance);
	}
	
	@SuppressWarnings("unused")
	private City getRandomCity(){
		List<City> cities=this.getCities();
		Integer random=(int)(Math.random()*cities.size()); 
		return cities.get(random);
	}
	
	private City getRandomCity(Filter<City> filter){
		List<City> cities=CollectionsUtils.filteredList(this.getCities(), filter) ;
		
		Integer random=(int)(Math.random()*cities.size()); 
		return cities.get(random);
	}
	
}
