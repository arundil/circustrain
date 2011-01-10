package gameState;

import java.util.List;

import performance.Performance;
import player.Player;
import game.CircusTrainGame;

public class GreenState extends GameStateImpl implements GameState {
	
	public GreenState(CircusTrainGame game){
		super(game);
		month="APRIL";
		completeBoard();
	}
	
	public void completeBoard() {
		completeBoardPerformances(8);
	}
	
	public Performance getPerformance(){
		List<Performance> bag=game.getPerformanceBag().getGreenBag();
		return getPerformanceInList(bag);
	}

	public void discardPilePunishment(Player player) {
		player.addReputation(2);
	}


}
