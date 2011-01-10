package gameState;

import java.util.List;

import performance.Performance;
import player.Player;
import game.CircusTrainGame;

public class RedState extends GameStateImpl implements GameState {
	
	public RedState(CircusTrainGame game){
		super(game);
		completeBoard();
	}

	public void completeBoard() {
		completeBoardPerformances(10);
	}
	
	public Performance getPerformance(){
		List<Performance> bag=game.getPerformanceBag().getRedBag();
		return getPerformanceInList(bag);
	}
	
	public void discardPilePunishment(Player player) {
		player.addVictoryPoints(-4);
	}
}
