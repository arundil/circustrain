package game;

import commands.CommandExecuteCase;
import commands.CommandPlayerState;
import player.Player;
import utiles.factoria.readDataFromKeyBoard;

//Mandamos al padre el constructor
//Creado el metodo selectCase();
public class BasicSingleGame extends OnePlayerGame {
	
	public BasicSingleGame(){
		super();
		//Quitar la carta rest en basico
		player.discardActionCard(8);
		player.getdiscartpile().clear();
	}

	public void runGame(){

		
	}
	
	void selectCase(Player p){
		String action1="1 : Play one Action card from my hand";
		String askBasicAction = "What are you going to do:" + "\n" + action1;
		String askBasicActionCondition = "1";
		String action="1";
		action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, askBasicActionCondition);
		this.setFollowingAction(action);
	}
}
