package board;

import Graph.Vertex;

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
		
		Tablero.addVertex(Montreal);
		Tablero.addVertex(Albany);
		Tablero.addVertex(Boston);
		Tablero.addVertex(Rochester);
		
		Tablero.addVertex(Winnipeg);
		Tablero.addVertex(Toronto);
		
		Tablero.addEdge(Montreal, Albany);
		Tablero.addEdge(Montreal, Rochester);
		Tablero.addEdge(Albany, Boston);
		
		
		System.out.println(Tablero);
		System.out.println(Albany.getAdjacents());
	}

}
