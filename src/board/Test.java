package board;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Board Tablero=new BoardImpl("/src/board/boardcfg.txt");

		City c=Tablero.getCityByName("Indianapolis");
		
		System.out.print(c.maxMovement(2));
	}

}
