package game;

import game.factory.GameFactory;

import java.util.List;

import player.Player;

import actionCards.ActionCard;

import talent.Talent;
import utiles.factoria.CollectionsFactory;

public class TestGame {
	public static void main (String[] args){
		
		CircusTrainGame game=GameFactory.createCircusTrainGame();
//		pay.execute();
		game.startGame();
		Player one = game.getPlayerList().get(0);
//		one.addMoney(25);
//		ActionCard mb = one.getActionCards().get(1);
//		ActionCard mb2 = one.getActionCards().get(2);
//		
//		List<ActionCard> list = CollectionsFactory.createListFactory().createList();
//		list.add(mb);
//		list.add(mb2);
//		one.addActionCards(list);
//		
//		List<Talent> talentList=CollectionsFactory.createListFactory().createList();
//		talentList.add(GameFactory.createTalent("CLOWN"));
//		talentList.add(GameFactory.createTalent("CLOWN"));
//		talentList.add(GameFactory.createTalent("ACROBAT"));
//		talentList.add(GameFactory.createTalent("ELEPHANT"));
//		talentList.add(GameFactory.createTalent("ELEPHANT"));
//		talentList.add(GameFactory.createTalent("HORSE"));
//		talentList.add(GameFactory.createTalent("HORSE"));
//		one.addTalent(talentList);
//		
		game.runGame();
		
//		Player p1=GameFactory.createPlayer("Tristan", true, true);
//		p1.addMoney(27);
		
		
		
	}
}
