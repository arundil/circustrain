package game;

import commands.CommandExecuteCase;
import commands.CommandPlayerState;
import game.factory.GameFactory;
import player.Player;
import utiles.factoria.readDataFromKeyBoard;

public class BasicTwoPlayersGame extends TwoPlayersGame{
	
	public BasicTwoPlayersGame(){
		super();
		for(int i=0;i<2;i++){
			String name=readDataFromKeyBoard.takeParametersToString("Player name: ");
			Player player=GameFactory.createPlayer(name);
			player.addTalent(theClown);
			talentBag.removeTalent(clown);
			player.addActionCards(GameFactory.inicializateActionCards(this, player));
			playerList.add(player);
			//Quitar la carta rest en basico
			player.discardActionCard(8);
			player.getdiscartpile().clear();
			
		}
	}
	
public void runGame(){
		

		gameOver();
		results();
	}
	
	void selectCase(Player player){
		String action1="1 : Play one Action card from my hand";
		String askBasicAction = "What are you going to do:" + "\n" + action1;
		String askBasicActionCondition = "1";
		String action="1";
		action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, askBasicActionCondition);
		this.setFollowingAction(action);
	}
}
