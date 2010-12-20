package game;

import player.Player;
import utiles.factoria.readDataFromKeyBoard;

//creado metodo selectCase();
public class AdvancedSingleGame extends OnePlayerGame {
	
	protected void selectCase (Player player){
		String action1="1 : Jugar una carta de acción";
		String action2="2 : Jugar una carta de acción ya descartada";		
		String askBasicAction = "What are you going to do:" + "\n" + action1;
		String askActionsDiscardedNoMoney = askBasicAction + "\n" + action2;
		String action;
		if(player.getdiscartpile().isEmpty()){
			action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, "1");
		}else{
			action=readDataFromKeyBoard.takeParametersToStringRestricted(askActionsDiscardedNoMoney, "1,2");
		}
		this.setFollowingAction(action);
	}
}
