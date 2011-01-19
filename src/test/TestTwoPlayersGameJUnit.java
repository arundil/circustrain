package test;

import game.AdvancedTwoPlayersGame;
import gameState.GameState;
import gameState.RedState;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import performance.Performance;
import player.Player;
import talent.AcrobatImpl;
import talent.BigCatImpl;
import talent.ClownImpl;
import talent.ElephantImpl;
import talent.FreakShowImpl;
import talent.HorseImpl;
import talent.HumanCannonballImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

public class TestTwoPlayersGameJUnit {
	GameState redState;
//	GameState yellowState;
//	GameState greenState;
	AdvancedTwoPlayersGame game;
	Player player1;
	Player player2;
	List<Talent> player1Talents;
	List<Talent> player2Talents;
	List<Player> playerList;

	Talent AC;
	Talent H;
	Talent HC;
	Talent BC;
	Talent C;
	Talent E;
	Talent FS;
	
	Performance redPerformance;
	
	@Before
	public void setUp(){
		game=new AdvancedTwoPlayersGame();
		redState=new RedState(game);
		redPerformance=redState.getPerformance();
		player1=game.getPlayerList().get(0);
		player2=game.getPlayerList().get(1);
		AC=new AcrobatImpl();
		H=new HorseImpl();
		HC=new HumanCannonballImpl();
		BC=new BigCatImpl();
		C=new ClownImpl();
		E=new ElephantImpl();
		FS=new FreakShowImpl();
		
		player1Talents=CollectionsFactory.createListFactory().createList();
		player2Talents=CollectionsFactory.createListFactory().createList();
		playerList=CollectionsFactory.createListFactory().createList();
		
		player1.addMoney(35);
		player2.addMoney(50);
						
	}
	@Test
	public void testCompareTalentsCountAndAddVictoryPoints(){
		player1=game.getPlayerList().get(0);
		player2=game.getPlayerList().get(1);	
		player1.getTalents().clear();
		player2.getTalents().clear();
		
		player1Talents.add(C);player1Talents.add(AC);
		player2Talents.add(C);player2Talents.add(C);player2Talents.add(E);player2Talents.add(FS);
		
		player1.addTalent(player1Talents);//player1-->1C,1AC
		player2.addTalent(player2Talents);//player2-->2C,1E,1FS
		
		game.compareTalentsCountAndAddVictoryPoints();
		
		assert player1.getVictoryPoints()==1:"Fallo en compareTalentsCountAndAddVictoryPoints P1. P1 tiene "+player1.getVictoryPoints();
		assert player2.getVictoryPoints()==4:"Fallo en compareTalentsCountAndAddVictoryPoints P2. P2 tiene "+player2.getVictoryPoints();
	}
	
	@Test
	public void testComparePlayersAndAddVictoryPoints(){
		player1=game.getPlayerList().get(0);
		player2=game.getPlayerList().get(1);
		player1.getTalents().clear();
		player2.getTalents().clear();
		
		player1Talents.add(C);player1Talents.add(AC);
		player2Talents.add(C);player2Talents.add(C);player2Talents.add(E);player2Talents.add(FS);
		
		player1.addTalent(player1Talents);//player1-->1C,1AC
		player2.addTalent(player2Talents);//player2-->2C,1E,1F
		
		player1.addPerformance(10);
		player2.addPerformance(15);
		game.comparePlayersAndAddVictoryPoints();
		assert player1.getVictoryPoints()==1:"Fallo en compareTalentsCountAndAddVictoryPoints P1. P1 tiene "+player1.getVictoryPoints();
		assert player2.getVictoryPoints()==8:"Fallo en compareTalentsCountAndAddVictoryPoints P2. P2 tiene "+player2.getVictoryPoints();
	}
	
	@Test
	public void testHigherClownNumber(){
		player1=game.getPlayerList().get(0);
		player2=game.getPlayerList().get(1);
		player1.getTalents().clear();
		player2.getTalents().clear();
		player2Talents.clear();
		player2Talents.add(C);
		player2Talents.add(C);
		player2.addTalent(player2Talents);
		System.out.println(player1.getTalents());
		System.out.println(player2.getTalents());
		game.higherClownNumber();
		
		assert player2.getVictoryPoints()==3:"Fallo en HigherClownNumber. P2 tiene "+player2.getVictoryPoints();
	}
	@Test
	public void testHigherPerformancesNumber(){

		player2=game.getPlayerList().get(1);
		player2.addPerfomanceUsed(redPerformance);
		System.out.println(player2.getPerfomancesUsed());
		game.higherPerformancesNumber();
		assert player2.getVictoryPoints()==3:"Fallo en HigherPerformancesNumber. P2 tiene "+player2.getVictoryPoints();
	}
		
	@Test
	public void testNoClownsNoAnimals(){
		player1=game.getPlayerList().get(0);
		player2=game.getPlayerList().get(1);
		
		player1Talents.clear();
		//player1Talents.add(C);
		player1Talents.add(FS);
		
		player1.addTalent(player1Talents);//P1-> 1C,1FS
		player1.discardTalent(C);
		
		player1.addVictoryPoints(20);
		
		System.out.println(player1.getTalents());
		System.out.println(player2.getTalents());
		game.noClownsNoAnimals();
		
		assert player1.getVictoryPoints()==14:"Fallo en NoClownsNoAnimals P1. P1 tiene "+player1.getVictoryPoints();
	}

}
