package test;

import actionCards.ActionCard;
import actionCards.BasicMoveImpl;
import board.Board;
import board.BoardImpl;
import player.Player;
import player.PlayerImpl;

public class testCartasDeAccion extends Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board b = new BoardImpl("/src/board/boardcfg.txt");
		Player p = new PlayerImpl("Pepe",false, true);
		p.moveCity(b.getCityByName("Madison"));
		ActionCard ac = new BasicMoveImpl(1, p);
		ac.execute();
		System.out.println("La ciudad actual de "+p.getName()+" es " + p.getCity());

	}

}
