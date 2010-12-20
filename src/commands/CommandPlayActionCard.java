package commands;


import game.CircusTrainGame;
import game.TwoPlayersGame;

import java.util.List;
import java.util.Set;
import actionCards.ActionCard;
import actionCards.RestImpl;
import player.Player;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;


public class CommandPlayActionCard implements Command{
	
	private Player player;
	private CircusTrainGame ctg;
	
	public CommandPlayActionCard(Player player, CircusTrainGame ctg){
		this.player=player;
		this.ctg = ctg;
	}
	
	public void execute(){
		List<ActionCard> actionCardList=player.getActionCards();
		Set<Integer> actionCardIdSet=CollectionsFactory.createSetFactory().createSet();
		for(ActionCard c:actionCardList){
			actionCardIdSet.add(c.getIdCard());
		}
		System.out.println(actionCardList.toString());
		Integer cardIdToBePlayed=-1;
		while(!actionCardIdSet.contains(cardIdToBePlayed)){
			cardIdToBePlayed=readDataFromKeyBoard.takeParametersToInteger("Select the card: NUMBER");
		}
		for(ActionCard actionCard:actionCardList){
			if(actionCard.getIdCard()==cardIdToBePlayed){
				if(actionCard instanceof RestImpl){
					actionCard = new RestImpl(player, ctg);
				}
				actionCard.execute();
				
				player.discardActionCard(cardIdToBePlayed);
				
				break;
			}
		}
		if(player.getActionCards().isEmpty()){
			player.getActionCards().addAll(player.getdiscartpile());
			player.getdiscartpile().clear();
		}
	}
}
