package gameState;

import game.CircusTrainGame;

import java.util.List;

import performance.Performance;
import player.Player;

public class RedState extends GameStateImpl implements GameState {
	
	public RedState(CircusTrainGame game){
		super(game);
		game.getBoard().removeAllPerformances();
		completeBoard();
	}

	public void completeBoard() {
		completeBoardPerformances(12);
	}
	
	public Performance getPerformance(){
		List<Performance> bag=game.getPerformanceBag().getRedBag();
		return getPerformanceInList(bag);
	}
	
	public void discardPilePunishment(Player player) {
		player.addVictoryPoints(-4);
	}

	@Override
	public void addMoney(Player player) {
		player.addMoney(15);
		
	}
}
