package game;

import game.factory.GameFactory;

import java.util.List;

import player.Player;
import card.ActionCard;

public class CommandPlayDiscardActionCard extends AbstractCommand{
	
private Player player;
	
	public CommandPlayDiscardActionCard(Player player){
		this.player=player;
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
	
	public void refresh(){
		if(/*ES AGOSTO O SEPTIEMBRE*/){´
			//RESTAR PUNTOS DE VICTORIA
		}else{
			if(player.getReputation()==6)player.addReputation(+);
		}
		
	}

}
