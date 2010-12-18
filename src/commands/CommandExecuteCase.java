package commands;

import game.AbstractCommand;
import game.CircusTrainGame;
import game.TwoPlayersGame;
import player.Player;

public class CommandExecuteCase extends AbstractCommand{
	
	private Player player;
	private CircusTrainGame game;
	
	public CommandExecuteCase(Player player,CircusTrainGame game){
		this.player=player;
		this.game=game;
	}
	
	public void execute(){
		if(game.getFollowingAction().equals("1")){
			CommandPlayActionCard playActionCard=new CommandPlayActionCard(player,game);
			playActionCard.execute();
		}else{
			if(game.getFollowingAction().equals("2")){
				CommandPlayDiscardActionCard playDiscardActionCard=new CommandPlayDiscardActionCard(player, game);
				playDiscardActionCard.execute();
			}
			if(game.getFollowingAction().equals("3")){
				CommandCollectMoney collectMoney=new CommandCollectMoney(player);
				collectMoney.execute();
			}
		}
	}

}
