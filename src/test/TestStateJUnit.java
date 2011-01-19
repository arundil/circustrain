package test;

import game.AdvancedTwoPlayersGame;
import gameState.GameState;
import gameState.GreenState;
import gameState.RedState;
import gameState.YellowState;

import org.junit.Before;
import org.junit.Test;

import bag.PerformanceBag;
	

public class TestStateJUnit {
	PerformanceBag p1;
	AdvancedTwoPlayersGame game;
	GameState redState;
	GameState yellowState;
	GameState greenState;
	GameState nuevoEstado=null;
	@Before
	 public void setUp() throws Exception {
		game=new AdvancedTwoPlayersGame();
		redState=new RedState(game);
		yellowState=new YellowState(game);
		greenState=new GreenState(game);
		
	}
	@Test
	public void testIncrementTime(){
		nuevoEstado=greenState.incrementTime();
		assert nuevoEstado.getWeek()==1;
		
	}
	@Test
	public void testCambiaEstado(){
			nuevoEstado=greenState;
		for(int i=0;i<10;i++){
			nuevoEstado=nuevoEstado.incrementTime();
		}
		assert nuevoEstado instanceof YellowState;
		for(int i=0;i<10;i++){
			nuevoEstado=nuevoEstado.incrementTime();
		}
		assert nuevoEstado instanceof RedState;
	}
	@Test
	public void testCompleteBoard(){
			nuevoEstado=new GreenState(new AdvancedTwoPlayersGame());
			assert nuevoEstado.getGame().getBoard().getCitiesWithPerfomance().size()==8 : "Vale "+nuevoEstado.getGame().getBoard().getCitiesWithPerfomance().size()+nuevoEstado.getClass();
			
			nuevoEstado=new YellowState(new AdvancedTwoPlayersGame());
			assert nuevoEstado.getGame().getBoard().getCitiesWithPerfomance().size()==10;
			
			nuevoEstado=new RedState(new AdvancedTwoPlayersGame());
			System.out.print(nuevoEstado.getGame().getBoard().getCitiesWithPerfomance());
			assert nuevoEstado.getGame().getBoard().getCitiesWithPerfomance().size()==12: "Vale "+nuevoEstado.getGame().getBoard().getCitiesWithPerfomance().size()+nuevoEstado.getClass();
	}
}
