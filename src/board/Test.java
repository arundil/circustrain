package board;

import tipos.graph.Vertex;
import tipos.graph.VertexImpl;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board Tablero=new BoardImpl();
		
		
		
		City Montreal=new CityImpl("Montreal",true);
		Vertex<City> v1=new VertexImpl<City>(1, Montreal);
		Tablero.add(v1);
		
		System.out.print(Tablero);

		

	}

}
