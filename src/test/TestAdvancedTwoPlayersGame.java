package test;
//
//import game.factory.GameFactory;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import performance.Performance;
//import player.Player;
//import talent.Talent;
//import utiles.factoria.CollectionsFactory;
//import bag.PerformanceBag;
//
public class TestAdvancedTwoPlayersGame {
//	
//	Player player1;
//	Player player2;
//	TestClassAdvancedTwoPlayersGame game;
//	Talent AC,H,HC,BC,C,E,FS;
//	
//	@Before
//	public void SetUp(){
//		TestClassAdvancedTwoPlayersGame game= new TestClassAdvancedTwoPlayersGame();
//		player1=GameFactory.createPlayer("Oakenfold");
//		player2=GameFactory.createPlayer("Copon");
//		Talent AC=GameFactory.createTalent("ACROBAT");
//		Talent H=GameFactory.createTalent("HORSE");
//		Talent HC=GameFactory.createTalent("HUMAN CANNON BALL");
//		Talent BC=GameFactory.createTalent("BIG CAT");
//		Talent C=GameFactory.createTalent("CLOWN");
//		Talent E=GameFactory.createTalent("ELEPHANT");
//		Talent FS=GameFactory.createTalent("FREAKSHOW");
//		
//		List<Talent> player1Talents=CollectionsFactory.createListFactory().createList();
//		List<Talent> player2Talents=CollectionsFactory.createListFactory().createList();
//		
//		PerformanceBag performanceBag=GameFactory.createPerformanceBag();
//		Performance greenPerformance1=performanceBag.getPerformance("green");
//		Performance greenPerformance2=performanceBag.getPerformance("green");
//		Performance yellowPerformance1=performanceBag.getPerformance("yellow");
//		Performance yellowPerformance2=performanceBag.getPerformance("yellow");
//		Performance redPerformance1=performanceBag.getPerformance("red");
//		Performance redPerformance2=performanceBag.getPerformance("red");
//		Performance redPerformance3=performanceBag.getPerformance("red");
//		
//		player1Talents.add(AC);player1Talents.add(H);player1Talents.add(HC);player1Talents.add(BC);
//		player2Talents.add(BC);player2Talents.add(C);player2Talents.add(E);player2Talents.add(FS);
//		
//		player1.addMoney(35);
//		player2.addMoney(50);
//		
//		player1.addPerfomanceUsed(greenPerformance1);
//		player1.addPerfomanceUsed(yellowPerformance1);
//		player1.addPerfomanceUsed(redPerformance1);//P1-> 1green,1yellow,1red
//		player2.addPerfomanceUsed(greenPerformance2);//P2 ->1green,1yellow,2red
//		player2.addPerfomanceUsed(yellowPerformance2);
//		player2.addPerfomanceUsed(redPerformance2);
//		player2.addPerfomanceUsed(redPerformance3);
//		
//		player1.addPerformance(15);
//		player2.addPerformance(20);
//		
//		player1.addTalent(player1Talents);//P1-> 1C,1AC,1H,1HC,1BC,  ,
//		player2.addTalent(player2Talents);//P2-> 2C,   ,  ,   ,1BC,1E,1FS
//		
//		game.setPlayer(0, player1);
//		game.setPlayer(1, player2);		
//	}
//	
//	@Test
//	public void testCompareTalentsCountAndAddVictoryPoints(){
//		player1=game.getPlayerList().get(0);
//		player2=game.getPlayerList().get(1);
//		game.comparePlayersAndAddVictoryPoints();
//		assert player1.getVictoryPoints()==3:"Fallo en comparePlayersAndAddVictoryPoints P1";
//		assert player2.getVictoryPoints()==4:"Fallo en comparePlayersAndAddVictoryPoints P2";
//	}
//	
//	@Test
//	public void testComparePlayersAndAddVictoryPoints(){
//		player2=game.getPlayerList().get(1);
//		game.comparePlayersAndAddVictoryPoints();
//		assert player2.getVictoryPoints()==8:"Fallo en comparePlayersAndAddVictoryPoints P2";
//	}
//	
//	@Test
//	public void testRotatePlayers(){
//		Player previousPlayerOne= game.getPlayerList().get(0);
//		Player previousPlayerTwo= game.getPlayerList().get(1);
//		game.rotatePlayers();
//		Player newPlayerOne= game.getPlayerList().get(0);
//		Player newPlayerTwo= game.getPlayerList().get(1);
//		assert previousPlayerOne.equals(newPlayerTwo) && previousPlayerTwo.equals(newPlayerOne):"Fallo en rotatePlayers";
//	}
//	//Metodo gameOver
//	//Metodo finalWage
//	
//	@Test
//	public void testHigherClownNumber(){
//		player2=game.getPlayerList().get(1);
//		game.higherClownNumber();
//		assert player2.getVictoryPoints()==3:"Fallo en HigherClownNumber";
//	}
//	
//	@Test
//	public void testHigherMoneyAmount(){
//		player2=game.getPlayerList().get(1);
//		game.higherMoneyAmount();
//		assert player2.getVictoryPoints()==3:"Fallo en HigherMoneyAmount";
//	}
//	
//	@Test
//	public void testHigherPerformancesNumber(){
//		player2=game.getPlayerList().get(1);
//		game.higherPerformancesNumber();
//		assert player2.getVictoryPoints()==3:"Fallo en HigherPerformancesNumber";
//	}
//	//Metodo results
//	
//	@Test
//	public void testNoClownsNoAnimals(){
//		player1=game.getPlayerList().get(0);
//		player2=game.getPlayerList().get(1);
//		
//		player1.addVictoryPoints(20);
//		player2.addVictoryPoints(30);
//		player1.discardTalent(C);
//		player2.discardTalent(E);
//		player2.discardTalent(BC);
//		game.noClownsNoAnimals();
//		
//		assert player1.getVictoryPoints()==17:"Fallo en NoClownsNoAnimals P1";
//		assert player2.getVictoryPoints()==27:"Fallo en NoClownsNoAnimals P2";
//	}
//	
//	@Test
//	public void testStealTalent(){
//		player1=game.getPlayerList().get(0);
//		player2=game.getPlayerList().get(1);
//		
//		game.stealTalent(player2);
//		assert !player1.getTalents().containsKey(C) && (player2.getTalents().get(C)==3):"Fallo en StealTalent";
//	}
//	
//	@Test
//	public void testHigherReputation(){
//		player1=game.getPlayerList().get(0);
//		player2=game.getPlayerList().get(1);
//		
//		player1.addReputation(4);
//		player2.addReputation(2);		
//		game.higherReputation();		
//		assert player2.getVictoryPoints()==3:"Fallo en HigherReputation";
//		
//	}
}
