package gameState;

import performance.Performance;
import player.Player;

public interface GameState {
	public void completeBoard();
	public GameState incrementTime();
	public String getMonth();
	public Performance getPerformance();
	public void discardPilePunishment(Player player);
	public Integer getWeek();
	public void addMoney(Player player);
	public Integer getHumanWeek();
}
