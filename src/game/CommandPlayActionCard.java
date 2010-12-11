package game;


import java.util.List;
import java.util.Set;
import actionCards.ActionCard;
import player.Player;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;


public class CommandPlayActionCard extends AbstractCommand{
	
	private Player player;
	
	public CommandPlayActionCard(Player player){
		this.player=player;
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
				actionCard.execute();
				player.discardActionCard(cardIdToBePlayed);
				break;
			}
		}
	}
}
