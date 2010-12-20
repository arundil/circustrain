package commands;

import player.Player;

public class CommandCollectMoney implements Command{

	private Player player;
	
	public CommandCollectMoney(Player player){
		this.player=player;
	}
	@Override
	public void execute() {
		//TODO INCOMPLETO
		player.addMoney(5);
		player.addReputation(1);
	}

}
