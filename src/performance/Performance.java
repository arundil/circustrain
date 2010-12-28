package performance;

import game.CircusTrainGame;
import player.Player;


public interface Performance {
	public String getColor();
	public String getDescription();
	public void execute(Player player);
	public void land(Player player);
	public void put(CircusTrainGame circus);
}
