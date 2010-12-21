package game;

import player.Player;
import utiles.factoria.readDataFromKeyBoard;

//creado metodo selectCase();
public class AdvancedSingleGame extends OnePlayerGame {
		
	protected void selectCase (Player player){
		String action1="[1] Jugar una carta de acción";
		String action2="[2] Jugar una carta de acción ya descartada";		
		String askBasicAction = "¿Qué vas a hacer?:" + "\n" + action1;
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
}
