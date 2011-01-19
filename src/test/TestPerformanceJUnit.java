package test;

import game.AdvancedTwoPlayersGame;
import gameState.GameState;
import gameState.GreenState;
import gameState.RedState;
import gameState.YellowState;

import org.junit.Before;
import org.junit.Test;

import performance.Performance;
import performance.VictoryPointsImpl;
import bag.PerformanceBag;
import bag.PerformanceBagImpl;
	

public class TestPerformanceJUnit {
	PerformanceBag p1;
	AdvancedTwoPlayersGame game;
	GameState redState;
	GameState yellowState;
	GameState greenState;
	@Before
	 public void setUp() throws Exception {
		p1 = new PerformanceBagImpl("/data/performancecfg.txt");
		game=new AdvancedTwoPlayersGame();
		redState=new RedState(game);
		yellowState=new YellowState(game);
		greenState=new GreenState(game);
	}
	@Test
	public void testAddPerformance(){
		Performance e = new VictoryPointsImpl("red", "", 3);
		p1.addPerformance(e);
		assert p1.getRedBag().size() == 22 : "Numero de actuaciones incorrecto. Hay "+p1.getRedBag().size();
	}
	@Test
	public void testGetPerformanceRed(){
		assert redState.getPerformance().getColor() == "red";
	}
	@Test
	public void testGetPerformanceGreen(){
		assert greenState.getPerformance().getColor() == "green";
	}
	@Test
	public void testGetPerformanceYellow(){
		assert yellowState.getPerformance().getColor() == "yellow";
	}
}
