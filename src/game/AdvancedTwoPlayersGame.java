package game;

import java.util.List;

import commands.CommandExecuteCase;
import commands.CommandPlayerState;
import commands.CommandSelectCanadianCity;
import commands.CommandSelectCase;
import commands.CommandStealTalent;

import game.factory.GameFactory;
import player.Player;
import utiles.factoria.CollectionsFactory;
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
	public void finalMonth(){
		super.finalMonth();
		
		if(playerList.get(0).getReputation()>playerList.get(1).getReputation()){
			CommandStealTalent stealTalent=new CommandStealTalent(playerList.get(0), this);
			stealTalent.execute();
		}
		if(playerList.get(1).getReputation()>playerList.get(0).getReputation()){
			CommandStealTalent stealTalent=new CommandStealTalent(playerList.get(1), this);
			stealTalent.execute();
		}
	}
	
	public void gameOver(){
		super.wageCardNoDiscarded();
		super.higherClownNumber();
		super.higherMoneyAmount();
		super.higherPerformancesNumber();
		this.higherReputation();
		super.noClownsNoAnimals();
		super.results();
	}
	
	public void runGame(){
		super.refreshMonth();		
		super.completeBoardPerformances();
		System.out.println("\n \n Cities with performance: "+ board.getCitiesWithPerfomance() +"\n \n");
		
		for(Player playerSelectsCity:playerList){
			CommandSelectCanadianCity selectCanadianCity=new CommandSelectCanadianCity(playerSelectsCity, this);
			selectCanadianCity.execute();
		}
		
		while(week<27){
			String oldMonth=this.getMonth();
			super.refreshMonth();
			String newMonth=this.getMonth();
			//Si hay cambio de mes se llevaran a cabo las acciones de fin de mes
			if(!(oldMonth == newMonth)){
				finalMonth();
				super.rotatePlayers();
			}
			//Mostrar ciudades con eventos
			System.out.println(board.getCitiesWithPerfomance().toString());
			System.out.println("\n \n This is the Week " + week + " and Mounth " + month);
			
			for(Player currentPlayer : playerList){
				//Se muestra el estado del jugador
				System.out.println("\n \n Its you turn, " + currentPlayer.getName());
				CommandPlayerState playerState = new CommandPlayerState(currentPlayer);				
				playerState.execute();
				
				//Se le pregunta al jugador que va a hacer segun sus condiciones actuales
				CommandSelectCase selectCase = new CommandSelectCase(currentPlayer, this);
				selectCase.execute();
				
				//Se lleva a cabo la accion que el jugador a elegido
				CommandExecuteCase executeCase=new CommandExecuteCase(currentPlayer, this);
				executeCase.execute();				
			}
			//Se mira el número de ciudades y se añaden si es el caso
			completeBoardPerformances();					
			week++;			
		}
		this.gameOver();
	}
	
	
	
	private void higherReputation(){
		List<Integer> playersReputation=CollectionsFactory.createListFactory().createList();
		Integer sameReputationTimes=0;
		Integer maximumReputation=-1;
		Integer previousReputation=0;
		for(int i=0;i<playerList.size();i++){
			if(i>0){
				previousReputation=playerList.get(i-1).getReputation();
			}
			Player thisPlayer=playerList.get(i);
			playersReputation.add(thisPlayer.getReputation());
			if(maximumReputation<thisPlayer.getReputation()){
				maximumReputation=thisPlayer.getReputation();
			}
			if(previousReputation==thisPlayer.getReputation()){
				sameReputationTimes++;
			}
		}
		if(sameReputationTimes==0){
			Integer playerIndex=playersReputation.indexOf(maximumReputation);
			playerList.get(playerIndex).addVictoryPoints(3);
		}
	}

}
