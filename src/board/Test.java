package board;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board Tablero=new BoardImpl();
		
		
		
		City Montreal=new CityImpl("Montreal",true);
		City Winnipeg=new CityImpl("Winnipeg",true);
		City Toronto=new CityImpl("Toronto",true);
		
		
		City Albany=new CityImpl("Albany",false);
		City Boston=new CityImpl("Boston",false);
		City Rochester=new CityImpl("Rochester",false);
		
		City Buffalo=new CityImpl("Buffalo",false);
		City Detroit=new CityImpl("Detroit",false);
		
		City Duluth=new CityImpl("Duluth",false);
		City StPaul=new CityImpl("StPaul",false);
		
		City NewHeaven=new CityImpl("NewHeaven",false);
		City NewYork=new CityImpl("NewYork",false);
		
		Tablero.addCity(Montreal);
		Tablero.addCity(Albany);
		Tablero.addCity(Boston);
		Tablero.addCity(Rochester);
		Tablero.addCity(Duluth);
		Tablero.addCity(StPaul);
		
		Tablero.addCity(Winnipeg);
		
		Tablero.addCity(Toronto);
		Tablero.addCity(Buffalo);
		Tablero.addCity(Detroit);
		
		Tablero.addCity(NewHeaven);
		Tablero.addCity(NewYork);
		
		
		Tablero.addRoad(Montreal, Albany);
		Tablero.addRoad(Montreal, Rochester);
		Tablero.addRoad(Albany, Boston);
		Tablero.addRoad(Toronto, Buffalo);
		Tablero.addRoad(Toronto, Detroit);
		Tablero.addRoad(Buffalo, Rochester);
		
		Tablero.addRoad(StPaul, Winnipeg);
		Tablero.addRoad(Duluth, Winnipeg);
		Tablero.addRoad(Boston, NewHeaven);
		Tablero.addRoad(NewYork, NewHeaven);
		Tablero.addRoad(NewYork, Albany);
		
		
		System.out.println(Tablero);

	}

}
