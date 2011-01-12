package game;

import player.Player;

//Mandamos al padre el constructor
//Creado el metodo selectCase();
public class BasicSingleGame extends OnePlayerGame {
	
	@Override
	protected void selectCase(Player p){
		//Si la unica opción que puede usar es jugar una carta de acción, ¿para que preguntarle lo que quiere hacer, ir directamente a preguntarle que carta quiere jugar
		
		
//		String action1="1 : Play one Action card from my hand";
//		String askBasicAction = "What are you going to do:" + "\n" + action1;
//		String askBasicActionCondition = "1";
		String action="1";
//		action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, askBasicActionCondition);
		this.setFollowingAction(action);
	}

	@Override
	protected void executeCase(Player player) {
		selectCard(player.getActionCards());
	}
	
	protected void refreshToFire(Player player){
		//No hace nada en modo básico
	}
	
}
