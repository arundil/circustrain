package game;

import java.util.List;

import player.Player;
import utiles.factoria.readDataFromKeyBoard;
import actionCards.ActionCard;
import actionCards.RestImpl;

//creado metodo selectCase();
public class AdvancedSingleGame extends OnePlayerGame {
	

	@Override
	protected void selectCase (Player player){
		String action1="[1] Jugar una carta de accion";
		String action2="[2] Jugar una carta de accion ya descartada";		
		String askBasicAction = "�Que vas a hacer?:" + "\n" + action1;
		String askActionsDiscardedNoMoney = askBasicAction + "\n" + action2;
		String action;
		//Si la pila de cartas descartadas no esta vacia y tiene una cantidad 
		//de dinero mayor o igual a 15 podrá además utilizar una carta de accion descartada
		if(!player.getdiscartpile().isEmpty() && player.getMoney()>=15){
			action=readDataFromKeyBoard.takeParametersToStringRestricted(askActionsDiscardedNoMoney, "1,2");
		}else{
			action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, "1");
		}
		this.setFollowingAction(action);
	}

	@Override
	protected void executeCase(Player player) {
		if(getFollowingAction().equals("1")){
			List<ActionCard> actionCards=player.getActionCards();
			Integer selectedCard=selectCard(actionCards);
			player.getdiscartpile().add(actionCards.get(selectedCard));
			player.getActionCards().remove(actionCards.get(selectedCard));
		}else{
			if(getFollowingAction().equals("2")){
				selectCard(player.getdiscartpile());
				player.addMoney(-15);
			}
		}
	}
	
	protected void refreshToFire(Player player){
		if(player.getReputation()<7){
			player.addReputation(1);
			assert player.getReputation()<7:"Reputacion fuera de rango";
		}
	}

	public void addRestActionCard() {
		ActionCard restCard=new RestImpl(this, this.getPlayerList().get(0));
		this.getPlayerList().get(0).getActionCards().add(restCard);
	}

}
