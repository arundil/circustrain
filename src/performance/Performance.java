package performance;

import game.CircusTrainGame;
import gameState.GameState;
import player.Player;


public interface Performance {
	public String getColor();
	public String getDescription();
	public void execute(Player player,GameState gamestate);
	public void land(Player player);
	public void put(CircusTrainGame circus);
}
