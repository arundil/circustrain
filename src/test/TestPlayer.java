package test;

import board.Board;
import board.BoardImpl;
import player.Player;
import player.PlayerImpl;

public class TestPlayer extends Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player p = new PlayerImpl("Pepe");
		Board b = new BoardImpl("/data/boardcfg.txt");
		p.moveCity(b.getCityByName("Toronto"));
		
		System.out.print(p.getActionCards());
		p.getActionCards().get(0).execute();
	}

}
