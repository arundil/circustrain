package test;

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
		p.moveCity(b.getCityByName("Toronto"));
		p.addMoney(100);
		System.out.println(p);
		System.out.println("Sacar carta de acción:\n" +
				"[0]Sacar una carta aleatoriamente verde\n" +
				"[1]Sacar otra carta aleatoriamente amarilla\n"+
				"[2]Sacar otra carta aleatoriamente roja\n");
		Integer elec = readDataFromKeyBoard.takeParametersToIntegerTopValue("Opcion:", 2);
		
		if (elec == 0){
			System.out.println(p1.getPerformance("green").toString());
			}
		if (elec == 1){
			System.out.println(p1.getPerformance("yellow").toString());
		}
		if (elec == 2){
			System.out.println(p1.getPerformance("red").toString());
		}
		
		System.out.println("La ciudad actual de "+p.getName()+" es " + p.getCity());
		System.out.println("La ejecución ha terminado correctamente");
}}
