package game;

import java.util.List;

import actionCards.ActionCard;
import actionCards.RestImpl;
import player.Player;

public class BasicTwoPlayersGame extends TwoPlayersGame{
	
	public BasicTwoPlayersGame(){
		super();
		for(Player player: playerList){
			ActionCard rest = new RestImpl(this,player);
			player.getActionCards().remove(rest);
		}
	}

	@Override
	protected void selectCase(Player player){
		String action="1";
		this.setFollowingAction(action);
	}
	
	@Override
	public void finalMonth(){
		//Puntos de victoria segun el nº de talentos
		comparePlayersAndAddVictoryPoints();			
		//Robar talentos
		stealTalentsSelector();
	}
	
	public void stealTalentsSelector(){
		Integer playerOneVictoryPoints=playerList.get(0).getVictoryPoints();
		Integer playerTwoVictoryPoints=playerList.get(1).getVictoryPoints();
		Integer comparator=playerOneVictoryPoints.compareTo(playerTwoVictoryPoints);
		if(comparator>0){
			stealTalent(playerList.get(1));
		}
		if(comparator<0){
			stealTalent(playerList.get(0));
		}
	}

	@Override
	protected void executeCase(Player player) {
		List<ActionCard> actionCards=player.getActionCards();
		Integer selectedCard=selectCard(actionCards);
		player.getdiscartpile().add(actionCards.get(selectedCard));
		player.getActionCards().remove(actionCards.get(selectedCard));
	}
	
	protected void refreshToFire(Player player){
		//No hace nada en modo básico
	}
}
