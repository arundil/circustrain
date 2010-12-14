package game;

import game.factory.GameFactory;
import player.Player;
import utiles.factoria.readDataFromKeyBoard;

public class AdvancedTwoPlayersGame extends CircusTrainGameImpl {
	
	public AdvancedTwoPlayersGame(){
		super();
		for(int i=0;i<2;i++){
			String name=readDataFromKeyBoard.takeParametersToString("Player name: ");
			Player player=GameFactory.createPlayer(name,true);
			player.addTalent(theClown);
			talentBag.removeTalent(clown);
			player.addActionCards(GameFactory.inicializateActionCards(this, player));
			playerList.add(player);
		}
	}

}
