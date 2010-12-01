package board;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestBoard {
	Board tablero;
	@Before
	public void setUp() throws Exception {
		String user = System.getProperty("user.dir");
		tablero=new BoardImpl(user+"/src/board/boardcfg.txt");
	}

	@Test
	public void numCiudades(){
		assert tablero.getCities().size()==27 : "Numero de ciudades incorrecto. Hay "+tablero.getCities().size();
	}
	
	@Test
	public void testAdd(){
		tablero.addCity(new CityImpl("Nueva ciudad",false));
		assert tablero.getCities().size()==28 : "Numero de ciudades incorrecto. Hay "+tablero.getCities().size();
	}
	
	@Test
	public void testAddCanadian(){
		tablero.addCity(new CityImpl("Nueva ciudad",true));
		assert tablero.getCanadianCities().size()==4 : "Numero de ciudades incorrecto. Hay "+tablero.getCities().size();
	}
	
	@Test
	public void testAddCanadian2(){
		tablero.addCity(new CityImpl("Nueva ciudad",false));
		assert tablero.getCanadianCities().size()==3 : "Numero de ciudades incorrecto. Hay "+tablero.getCities().size();
	}
	@Test
	public void testGetCityByName(){
		City testCity=new CityImpl("New York",false);
		
		assert tablero.getCityByName("New York").equals(testCity);
	}
	
	@Test
	public void getCanadianCities(){
		City Winnipeg=tablero.getCityByName("Winnipeg");
		City Toronto=tablero.getCityByName("Toronto");
		City Montreal=tablero.getCityByName("Montreal");

		List<City> canadian=tablero.getCanadianCities();
		
		assert canadian.contains(Winnipeg)&&canadian.contains(Toronto)&&canadian.contains(Montreal) : "Contiene: "+tablero.getCanadianCities();
	}
}
