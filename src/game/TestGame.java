package game;

import game.factory.GameFactory;

import java.awt.Color;
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
		Player player;
		PerformanceDemand greenPerformance;
		PerformanceDemand yellowPerformance;
		PerformanceDemand redPerformance;
		PerformanceDemand twoWeeksPerformance;
		CommandPerformance testCommandTwoWeeks;
		CommandPerformance testCommandRed;
		CommandPerformance testCommandYellow;
		CommandPerformance testCommandGreen;
		
		player = GameFactory.createPlayer("Tristan",true, true);
		List<Talent> playerTalents=CollectionsFactory.createListFactory().createList();
		playerTalents.add(new ClownImpl());
		playerTalents.add(new ElephantImpl());
		playerTalents.add(new AcrobatImpl());
		player.addTalent(playerTalents);
		Map<Talent,Integer> greenPerformanceTalents=CollectionsFactory.createMapFactory().createMap();
		greenPerformanceTalents.put(new ClownImpl(),1);
		greenPerformanceTalents.put(new AcrobatImpl(),2);
		greenPerformanceTalents.put(new ElephantImpl(),5);
		Map<Talent,Integer> yellowPerformanceTalents=CollectionsFactory.createMapFactory().createMap();
		yellowPerformanceTalents.put(new ClownImpl(),1);
		yellowPerformanceTalents.put(new HumanCannonballImpl(),3);
		yellowPerformanceTalents.put(new BigCatImpl(),4);
		Map<Talent,Integer> redPerformanceTalents=CollectionsFactory.createMapFactory().createMap();
		redPerformanceTalents.put(new ClownImpl(),1);
		redPerformanceTalents.put(new AcrobatImpl(),2);
		redPerformanceTalents.put(new FreakShowImpl(),6);
		Map<Talent,Integer> twoWeeksPerformanceTalents=CollectionsFactory.createMapFactory().createMap();
		twoWeeksPerformanceTalents.put(new ClownImpl(),3);
		twoWeeksPerformanceTalents.put(new ElephantImpl(),6);
		twoWeeksPerformanceTalents.put(new FreakShowImpl(),18);
		greenPerformance= new PerformanceDemandImpl("green","Green performance demand",3, greenPerformanceTalents, false);
		yellowPerformance= new PerformanceDemandImpl("yellow","Performance 2",4, yellowPerformanceTalents, false);
		redPerformance= new PerformanceDemandImpl("red","Performance 3",3, redPerformanceTalents, false);
		twoWeeksPerformance= new PerformanceDemandImpl("red","Performance 4",5, twoWeeksPerformanceTalents, true);
		testCommandGreen=new CommandPerformance(player, greenPerformance);
		testCommandYellow=new CommandPerformance(player, yellowPerformance);
		testCommandRed=new CommandPerformance(player, redPerformance);
		testCommandTwoWeeks=new CommandPerformance(player, twoWeeksPerformance);
	
		System.out.println(player.getPerfomancesUsed().size());
		testCommandGreen.execute();
		System.out.println(player.getPerfomancesUsed().size());
		for(Performance performance:player.getPerfomancesUsed()){
			System.out.println(performance.toString());
			
		}
		
		
	}
}
