package board;

import utiles.factoria.Vertex;

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
		
		Tablero.addVertex(Montreal);
		Tablero.addVertex(Albany);
		Tablero.addVertex(Boston);
		Tablero.addVertex(Rochester);
		Tablero.addVertex(Duluth);
		Tablero.addVertex(StPaul);
		
		Tablero.addVertex(Winnipeg);
		
		Tablero.addVertex(Toronto);
		Tablero.addVertex(Buffalo);
		Tablero.addVertex(Detroit);
		
		Tablero.addVertex(NewHeaven);
		Tablero.addVertex(NewYork);
		
		
		Tablero.addEdge(Montreal, Albany);
		Tablero.addEdge(Montreal, Rochester);
		Tablero.addEdge(Albany, Boston);
		Tablero.addEdge(Toronto, Buffalo);
		Tablero.addEdge(Toronto, Detroit);
		Tablero.addEdge(Buffalo, Rochester);
		
		Tablero.addEdge(StPaul, Winnipeg);
		Tablero.addEdge(Duluth, Winnipeg);
		Tablero.addEdge(Boston, NewHeaven);
		Tablero.addEdge(NewYork, NewHeaven);
		Tablero.addEdge(NewYork, Albany);
		
		
		System.out.println(Tablero);
		for(Vertex c:Tablero.getVertexSet()){
			System.out.println(((City)c).toString() + ((City)c).getAdjacents().toString());
		}
	}

}
