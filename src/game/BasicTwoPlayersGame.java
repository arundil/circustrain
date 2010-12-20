package game;

import game.factory.GameFactory;
import player.Player;
import utiles.factoria.readDataFromKeyBoard;

public class BasicTwoPlayersGame extends TwoPlayersGame{
	
	public BasicTwoPlayersGame(){
		super();
		for(int i=0;i<2;i++){
			String name=readDataFromKeyBoard.takeParametersToString("Nombre del jugador: ");
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
	

	protected void selectCase(Player player){
//		Si solo hay una opcion, para que preguntar;
//		String action1="1 : Play one Action card from my hand";
//		String askBasicAction = "What are you going to do:" + "\n" + action1;
//		String askBasicActionCondition = "1";
		String action="1";
//		action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, askBasicActionCondition);
		this.setFollowingAction(action);
	}
}
