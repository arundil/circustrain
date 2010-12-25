package gameState;

import game.CircusTrainGame;

public interface GameState {
	public void completePerfomances(CircusTrainGame game);
	public GameState incrementTime();
	public Integer getWeek();
	public String getMonth();
}
