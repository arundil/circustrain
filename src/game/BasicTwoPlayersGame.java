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
		String action="1";
		this.setFollowingAction(action);
	}
	
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
}
