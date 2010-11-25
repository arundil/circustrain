package game;

import game.factory.GameFactory;

import java.util.List;

import player.Player;
import card.ActionCard;

public class CommandPlayDiscardActionCard extends AbstractCommand{
	
private Player player;
private CircusTrainGame game;
	
	public CommandPlayDiscardActionCard(Player player, CircusTrainGame game){
		this.player=player;
		this.game=game;
	}
	
	public void execute(){
		List<ActionCard> discardActionCardList=player.getdiscartpile();
		System.out.println(discardActionCardList.toString());
		Integer cardIdToBePlayed=GameFactory.takeParametersToInteger("Select the card: NUMBER");
		for(ActionCard actionCard:discardActionCardList){
			if(actionCard.getIdCard()==cardIdToBePlayed){
				actionCard.execute();
				refresh();
			}
		}
	}
	
	private void refresh(){
		if((game.getMonth()).equals("AUGUST") || (game.getMonth()).equals("SEPTEMBER")){
			player.addVictoryPoints(-4);
		}else{
			player.addReputation(2);
		}
		
	}

}
