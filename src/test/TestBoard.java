package test;

import game.factory.GameFactory;
import bag.PerformanceBag;
import board.Board;

public class TestBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Board Tablero=GameFactory.createBoard();
		PerformanceBag bolsaDeActuaciones=GameFactory.createPerformanceBag();
		for(int i=0;i<8;i++){
			Tablero.addPerfomanceInRandomCity(bolsaDeActuaciones.getPerformance("green"));
		}

		System.out.println(Tablero.getCities());

	}
}
