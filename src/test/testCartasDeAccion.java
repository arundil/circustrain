package test;

import java.awt.Color;
import java.util.Map;

import game.factory.GameFactory;
import actionCards.ActionCard;
import actionCards.BasicMoveImpl;
import actionCards.FastMoveImpl;
import actionCards.HoldImpl;
import actionCards.OvernighterImpl;
import actionCards.RestImpl;
import actionCards.TravelImpl;
import actionCards.WagesImpl;
import bag.TalentBagImpl;
import board.Board;
import board.BoardImpl;
import performance.PerformanceDemand;
import performance.PerformanceDemandImpl;
import player.Player;
import player.PlayerImpl;
import talent.Clown;
import talent.ClownImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

public class testCartasDeAccion extends Test {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Board b = new BoardImpl("/data/boardcfg.txt");
		Clown cl = new ClownImpl();
		Player p = new PlayerImpl("Pepe",false, true);
		p.moveCity(b.getCityByName("Toronto"));
		p.addMoney(100);
		Map<Talent, Integer> talentPoints= CollectionsFactory.createMapFactory().createMap();
		talentPoints.put(cl, 3);
		PerformanceDemand pd = new PerformanceDemandImpl("green", "Bla Bla Bla", 2, talentPoints, false);
		p.getCity().setPerfomance(pd);
		System.out.println(p);
		System.out.println("Elegir carta de acción a usar:\n" +
				"[0]Viaje\n" +
				"[1][2]Movimiento Básico\n" +
				"[3]Movimiento Rápido\n" +
				"[4]Salarios\n" +	
				"[5]De noche\n" +
				"[6]Descanso\n" +
				"[7]Quedarse");
		Integer elec = GameFactory.takeParametersToIntegerTopValue("Opcion:", 7);
		
		if (elec == 0){
			ActionCard ac = new TravelImpl(p);
			ac.execute();
		}
		if (elec == 1 || elec == 2){
			ActionCard ac = new BasicMoveImpl(elec, p);
			ac.execute();
		}
		if (elec == 3){
			ActionCard ac = new FastMoveImpl(p);
			ac.execute();
		}
		if (elec == 4){
			ActionCard ac = new WagesImpl(p, true);
			ac.execute();
		}
		if (elec == 5){
			ActionCard ac = new OvernighterImpl(p);
			ac.execute();	
		}
		if (elec == 6){
			ActionCard ac = new RestImpl(p,new TalentBagImpl());
			ac.execute();
		}
		if (elec == 7){
			ActionCard ac = new HoldImpl(p);
			ac.execute();
		}
		System.out.println("La ciudad actual de "+p.getName()+" es " + p.getCity());
		System.out.println("La ejecución ha terminado correctamente");
	}
}
