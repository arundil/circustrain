package game;

import player.Player;

public class EarnMoneyCommand extends AbstractCommand{

	private Player player;
	
	public EarnMoneyCommand(Player player){
		this.player=player;
	}
	@Override
	public void execute() {
		player.addMoney(5);
		player.addReputation(1);
	}

}
