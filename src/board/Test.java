package board;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board Tablero=new BoardImpl();
		
		
		
		City Montreal=new CityImpl("Montreal",true);
		Tablero.addCity(Montreal);
		
		System.out.print(Tablero);

		

	}

}
