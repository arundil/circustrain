package game;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import game.factory.GameFactory;
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

import org.junit.Before;
import org.junit.Test;

public class TestCommandPerformance {
	Player player;
	PerformanceDemand greenPerformance;
	PerformanceDemand yellowPerformance;
	PerformanceDemand redPerformance;
	PerformanceDemand twoWeeksPerformance;
	CommandPerformance testCommandTwoWeeks;
	CommandPerformance testCommandRed;
	CommandPerformance testCommandYellow;
	CommandPerformance testCommandGreen;
	
	@Before
	public void setUp(){
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
		greenPerformance= new PerformanceDemandImpl(Color.GREEN,"Green performance demand",3, greenPerformanceTalents, false);
		yellowPerformance= new PerformanceDemandImpl(Color.YELLOW,"Performance 2",4, yellowPerformanceTalents, false);
		redPerformance= new PerformanceDemandImpl(Color.RED,"Performance 3",3, redPerformanceTalents, false);
		twoWeeksPerformance= new PerformanceDemandImpl(Color.RED,"Performance 4",5, twoWeeksPerformanceTalents, true);
		testCommandGreen=new CommandPerformance(player, greenPerformance);
		testCommandYellow=new CommandPerformance(player, yellowPerformance);
		testCommandRed=new CommandPerformance(player, redPerformance);
		testCommandTwoWeeks=new CommandPerformance(player, twoWeeksPerformance);
	}
	
	@Test
	public void testGreenPerformance(){
		testCommandGreen.execute();
		assert player.getPerfomancesUsed().size()==1;
		assert player.getPerformanceMax()==11;
		assert player.getMoney()==15;
		assert player.getWeeksToPerformance()==1;
	}
	@Test
	public void testYellowPerformance(){
		testCommandYellow.execute();
		assert player.getPerfomancesUsed().size()==1;
		assert player.getPerformanceMax()==5;
		assert player.getMoney()==20;
		assert player.getWeeksToPerformance()==1;
	}
	@Test
	public void testRedPerformance(){
		testCommandRed.execute();
		assert player.getPerfomancesUsed().size()==1;
		assert player.getPerformanceMax()==4;
		assert player.getMoney()==30;
		assert player.getWeeksToPerformance()==1;
	}
	@Test
	public void testTwoWeeksPerformanceRound1(){
		testCommandTwoWeeks.execute();
		assert player.getPerfomancesUsed().size()==0;
		assert player.getPerformanceMax()==0;
		assert player.getMoney()==0;
		assert player.getWeeksToPerformance()==0;
	}
	@Test
	public void testTwoWeeksPerformanceRound2(){
		testCommandTwoWeeks.execute();
		testCommandTwoWeeks.execute();
		assert player.getPerfomancesUsed().size()==1;
		assert player.getPerformanceMax()==14;
		assert player.getMoney()==30;
		assert player.getWeeksToPerformance()==1;
		
	}
}
