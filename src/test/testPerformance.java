package test;

import java.awt.Color;
import java.util.Map;

import game.factory.GameFactory;
import performance.Performance;
import performance.PerformanceDemandImpl;
import player.Player;
import player.PlayerImpl;
import talent.BigCatImpl;
import talent.ClownImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import actionCards.ActionCard;
import actionCards.BasicMoveImpl;
import actionCards.FastMoveImpl;
import actionCards.HoldImpl;
import actionCards.OvernighterImpl;
import actionCards.RestImpl;
import actionCards.TravelImpl;
import actionCards.WagesImpl;
import bag.PerformanceBag;
import bag.PerformanceBagImpl;
import bag.TalentBagImpl;
import board.Board;
import board.BoardImpl;

public class testPerformance extends Test{
	public static void main(String[] args) {
		Board b = new BoardImpl("/src/board/boardcfg.txt");
		Player p = new PlayerImpl("Pepe",false, true);
		PerformanceBag p1=new PerformanceBagImpl();
		p.moveCity(b.getCityByName("Toronto"));
		p.addMoney(100);
		System.out.println(p);
		System.out.println("Sacar carta de acción:\n" +
				"[0]Sacar una carta aleatoriamente verde\n" +
				"[1]Sacar otra carta aleatoriamente amarilla\n"+
				"[2]Sacar otra carta aleatoriamente roja\n");
		Integer elec = GameFactory.takeParametersToIntegerTopValue("Opcion:", 2);
		
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
