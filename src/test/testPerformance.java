package test;

import game.CircusTrainGame;
import gameState.*;
import player.Player;
import player.PlayerImpl;
import utiles.factoria.readDataFromKeyBoard;
import bag.PerformanceBag;
import bag.PerformanceBagImpl;
import board.Board;
import board.BoardImpl;

public class testPerformance extends Test{
	public static void main(String[] args) {
		Board b = new BoardImpl("/src/board/boardcfg.txt");
		Player p = new PlayerImpl("Pepe");
		PerformanceBag p1=new PerformanceBagImpl();
		CircusTrainGame game = new CircusTrainGame();
		GreenState gS= new GreenState(game);
		YellowState yS = new YellowState(game);
		RedState rS = new RedState(game);
		
		p.moveCity(b.getCityByName("Toronto"));
		p.addMoney(100);
		System.out.println(p);
		System.out.println("Sacar carta de acción:\n" +
				"[0]Sacar una carta aleatoriamente verde\n" +
				"[1]Sacar otra carta aleatoriamente amarilla\n"+
				"[2]Sacar otra carta aleatoriamente roja\n");
		Integer elec = readDataFromKeyBoard.takeParametersToIntegerTopValue("Opcion:", 2);
		
		if (elec == 0){
			System.out.println(gS.getPerformance().toString());
			}
		if (elec == 1){
			System.out.println(yS.getPerformance().toString());
		}
		if (elec == 2){
			System.out.println(rS.getPerformance().toString());
		}
		
		System.out.println("La ciudad actual de "+p.getName()+" es " + p.getCity());
		System.out.println("La ejecución ha terminado correctamente");
}}
