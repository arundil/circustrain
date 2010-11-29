package game;

import player.Player;

public class CommandCollectMoney extends AbstractCommand{

	private Player player;
	
	public CommandCollectMoney(Player player){
		this.player=player;
	}
	@Override
	public void execute() {
		player.addMoney(5);
		player.addReputation(1);
	}

}
