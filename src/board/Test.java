package board;

import Graph.Vertex;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board Tablero=new BoardImpl();
		
		
		
		City Montreal=new CityImpl("Montreal",true);
		City Albany=new CityImpl("Albany",false);
		Tablero.addVertex(Montreal);
		Tablero.addVertex(Albany);
		Tablero.addEdge(Montreal, Albany);
		
		
		
		System.out.print(Montreal.getAdjacents());
	}

}
