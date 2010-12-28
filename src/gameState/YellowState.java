package gameState;

import java.util.List;

import performance.Performance;
import game.CircusTrainGame;

public class YellowState extends GameStateImpl implements GameState {

	public YellowState(CircusTrainGame game){
		super(game);
		completeBoard();
	}
	public void completeBoard() {
		completeBoardPerformances(10);
	}
	public Performance getPerformance(){
		List<Performance> bag=game.getPerformanceBag().getYellowBag();
		return getPerformanceInList(bag);
	}

}
