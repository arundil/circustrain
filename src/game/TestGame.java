package game;

import game.factory.GameFactory;

import java.util.List;
import java.util.Map;

import performance.Performance;
import performance.PerformanceDemand;
import performance.PerformanceDemandImpl;
import player.Player;
import talent.AcrobatImpl;
import talent.BigCatImpl;
import talent.ClownImpl;
import talent.ElephantImpl;
import talent.FreakShowImpl;
import talent.HumanCannonballImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

public class TestGame {
	public static void main (String[] args){
		
		CircusTrainGame game=GameFactory.createCircusTrainGame();

		CommandPay pay=new CommandPay(game.getPlayerList().get(0),game,1);
//		pay.execute();
		game.startGame();
		game.runGame();
		
//		Player p1=GameFactory.createPlayer("Tristan", true, true);
//		List<Talent> talentList=CollectionsFactory.createListFactory().createList();
//		talentList.add(GameFactory.createTalent("CLOWN"));
//		talentList.add(GameFactory.createTalent("CLOWN"));
//		talentList.add(GameFactory.createTalent("ACROBAT"));
//		talentList.add(GameFactory.createTalent("ELEPHANT"));
//		talentList.add(GameFactory.createTalent("ELEPHANT"));
//		talentList.add(GameFactory.createTalent("HORSE"));
//		talentList.add(GameFactory.createTalent("HORSE"));
//		p1.addMoney(27);
		
		
		
	}
}
