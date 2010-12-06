package board;

import java.awt.Color;

import performance.VictoryPoints;
import performance.VictoryPointsImpl;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Board Tablero=new BoardImpl("/data/boardcfg.txt");
		VictoryPoints vp=new VictoryPointsImpl(new Color(5),"PV1","PV1",2); 
		City c=Tablero.addPerfomanceInRandomCity(vp);
		System.out.println(c);
		System.out.println(Tablero.getCities());

	}

}
