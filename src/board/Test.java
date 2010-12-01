package board;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//TODO: Preguntar como coño se ponen las direcciones relativas
		Board Tablero=new BoardImpl("C:\\Users\\jenkin90\\Documents\\workspace\\circustrain\\src\\board\\boardcfg.txt");

		System.out.print(Tablero.getCanadianCities());
	}

}
