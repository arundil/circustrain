package performance;

import player.Player;


public interface Performance {
	public String getColor();
	public String getDescription();
	public void execute(Player player);
}
