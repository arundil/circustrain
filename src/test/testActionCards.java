package test;

import game.AdvancedTwoPlayersGame;
import game.CircusTrainGame;
import gameState.GameState;
import gameState.GreenState;
import java.util.List;
import java.util.Map;
import performance.PerformanceDemand;
import performance.PerformanceDemandImpl;
import player.Player;
import player.PlayerImpl;
import talent.Clown;
import talent.ClownImpl;
import talent.Elephant;
import talent.ElephantImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import actionCards.ActionCard;
import actionCards.BasicMoveImpl;
import actionCards.FastMoveImpl;
import actionCards.HoldImpl;
import actionCards.OvernighterImpl;
import actionCards.RestImpl;
import actionCards.TravelImpl;
import actionCards.WagesImpl;
import board.Board;
import board.BoardImpl;

public class testActionCards extends Test {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		GameState ge = new GreenState(new AdvancedTwoPlayersGame());
		CircusTrainGame cg = new AdvancedTwoPlayersGame();
		Board b = new BoardImpl("/data/boardcfg.txt");
		Clown cl = new ClownImpl();
		Elephant el = new ElephantImpl();
		Player p = new PlayerImpl("Pepe");
		List<Talent> lt = CollectionsFactory.createListFactory().createList();
		p.moveCity(b.getCityByName("Toronto"));
		p.addMoney(15);
		Map<Talent, Integer> talentPoints= CollectionsFactory.createMapFactory().createMap();
		talentPoints.put(cl, 3);
		List<Talent> talents  = CollectionsFactory.createListFactory().createList();
		talents.add(el);
		talents.add(cl);
		talents.add(cl);
		talents.add(cl);
		talents.add(cl);
		talents.add(cl);
		lt.add(cl);
		lt.add(cl);
		p.addTalent(talents);
		//BankruptCircus bk = new BankruptCircusImpl("Rojo", "soy un pudrecolchones",lt );
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
		Integer elec = readDataFromKeyBoard.takeParametersToIntegerTopValue("Opcion:", 7);
		
		if (elec == 0){
			ActionCard ac = new TravelImpl(p);
			ac.execute(ge);
		}
		if (elec == 1 || elec == 2){
			ActionCard ac = new BasicMoveImpl(p);
			ac.execute(ge);
		}
		if (elec == 3){
			ActionCard ac = new FastMoveImpl(p);
			ac.execute(ge);
		}
		if (elec == 4){
			ActionCard ac = new WagesImpl(cg,p);
			ac.execute(ge);
		}
		if (elec == 5){
			ActionCard ac = new OvernighterImpl(p);
			ac.execute(ge);	
		}
		if (elec == 6){
			ActionCard ac = new RestImpl(cg,p);
			ac.execute(ge);
		}
		if (elec == 7){
			ActionCard ac = new HoldImpl(p);
			ac.execute(ge);
		}
		System.out.println(p.getMoney());
		System.out.println("La ciudad actual de "+p.getName()+" es " + p.getCity());
		System.out.println("La ejecución ha terminado correctamente");
	}
}
