package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import player.Player;
import talent.Acrobat;
import talent.AcrobatImpl;
import talent.BigCat;
import talent.BigCatImpl;
import talent.Clown;
import talent.ClownImpl;
import talent.Elephant;
import talent.ElephantImpl;
import talent.FreakShow;
import talent.FreakShowImpl;
import talent.Horse;
import talent.HorseImpl;
import talent.HumanCannonball;
import talent.HumanCannonballImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

import game.AdvancedTwoPlayersGame;
import game.factory.GameFactory;

public class TwoPlayersGameJUnit {
	
	AdvancedTwoPlayersGame game;
	Player player1;
	Player player2;

	Acrobat AC;
	Horse H;
	HumanCannonball HC;
	BigCat BC;
	Clown C;
	Elephant E;
	FreakShow FS;
	
	@Before
	public void setUp(){
		game=new AdvancedTwoPlayersGame();
		player1=GameFactory.createPlayer("TestPlayer1");
		player2=GameFactory.createPlayer("TestPlayer2");
		AC=new AcrobatImpl();
		H=new HorseImpl();
		HC=new HumanCannonballImpl();
		BC=new BigCatImpl();
		C=new ClownImpl();
		E=new ElephantImpl();
		FS=new FreakShowImpl();
		
		List<Talent> player1Talents=CollectionsFactory.createListFactory().createList();
		List<Talent> player2Talents=CollectionsFactory.createListFactory().createList();
		List<Player> playerList=CollectionsFactory.createListFactory().createList();
		
		player1Talents.add(AC);player1Talents.add(H);player1Talents.add(HC);player1Talents.add(BC);
		player2Talents.add(BC);player2Talents.add(C);player2Talents.add(E);player2Talents.add(FS);
		
		player1.addMoney(35);
		player2.addMoney(50);
		
		player1.addTalent(player1Talents);//P1-> 1C,1AC,1H,1HC,1BC,  ,
		player2.addTalent(player2Talents);//P2-> 2C,   ,  ,   ,1BC,1E,1FS
		
		playerList.add(player1);playerList.add(player2);		
	}
	@Test
	public void testCompareTalentsCountAndAddVictoryPoints(){
		player1=game.getPlayerList().get(0);
		player2=game.getPlayerList().get(1);
		game.compareTalentsCountAndAddVictoryPoints();
		
		assert player1.getVictoryPoints()==3:"Fallo en comparePlayersAndAddVictoryPoints P1";
		assert player2.getVictoryPoints()==4:"Fallo en comparePlayersAndAddVictoryPoints P2";
	}
	
	@Test
	public void testComparePlayersAndAddVictoryPoints(){
		player2=game.getPlayerList().get(1);
		game.comparePlayersAndAddVictoryPoints();
		assert player2.getVictoryPoints()==8:"Fallo en comparePlayersAndAddVictoryPoints P2";
	}
	
	@Test
	public void testHigherClownNumber(){
		player2=game.getPlayerList().get(1);
		game.higherClownNumber();
		assert player2.getVictoryPoints()==3:"Fallo en HigherClownNumber";
	}
	@Test
	public void testHigherPerformancesNumber(){
		player2=game.getPlayerList().get(1);
		game.higherPerformancesNumber();
		assert player2.getVictoryPoints()==0:"Fallo en HigherPerformancesNumber";
	}
		
	@Test
	public void testNoClownsNoAnimals(){
		player1=game.getPlayerList().get(0);
		player2=game.getPlayerList().get(1);
		
		player1.addVictoryPoints(20);
		player2.addVictoryPoints(30);
		player1.discardTalent(C);
		player2.discardTalent(E);
		player2.discardTalent(BC);
		game.noClownsNoAnimals();
		
		assert player1.getVictoryPoints()==17:"Fallo en NoClownsNoAnimals P1";
		assert player2.getVictoryPoints()==27:"Fallo en NoClownsNoAnimals P2";
	}

}
