package gameState;

import performance.Performance;

public interface GameState {
	public void completeBoard();
	public GameState incrementTime();
	public String getMonth();
	public Performance getPerformance();
}
