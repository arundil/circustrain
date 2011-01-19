package gameState;

import game.CircusTrainGame;

import java.util.List;

import performance.Performance;
import player.Player;

public class GreenState extends GameStateImpl implements GameState {
	
	public GreenState(CircusTrainGame game){
		super(game);
		month="ABRIL";
		game.getBoard().removeAllPerformances();
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

	@Override
	public void addMoney(Player player) {
		player.addMoney(5);
		
	}


}
