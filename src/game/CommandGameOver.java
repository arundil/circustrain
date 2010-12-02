package game;

import java.util.List;
import java.util.Map;

import player.Player;
import talent.Clown;
import talent.Talent;

public class CommandGameOver extends AbstractCommand{
	
	//Posiblemente no haga falta este comando. Seria un metodo dentro de la clase game

	//SOLO PARA 2 JUGADORES
	
	private CircusTrainGame game;
	
	public CommandGameOver(CircusTrainGame game){
		this.game=game;
	}	
	
	public void execute() {
		List<Player> playerList=game.getPlayerList();
		Player player1=playerList.get(0);
		Player player2=	playerList.get(1);	
		Map<Talent,Integer> playerTalents = player1.getTalents();
		Map<Talent,Integer> otherPlayerTalents = player2.getTalents();
		//TODO si hay carta de salario sin jugar: restar 3 ptos de victoria y pagar el doble de los salarios
		
		
		
		
		//TODO si el jugador es el que tiene mas payasos: suma 3 ptos de victoria
		Integer player1ClownNumber;
		Integer player2ClownNumber;
		if(playerTalents.containsKey(Clown.class)){
			player1ClownNumber=playerTalents.get(Clown.class);			
		}else{
			player1ClownNumber=0;
		}
		
		if(otherPlayerTalents.containsKey(Clown.class)){
			player2ClownNumber=otherPlayerTalents.get(Clown.class);
		}else{
			player2ClownNumber=0;
		}
		Integer comparePlayer1ClownWithPlayer2Clowns=player1ClownNumber.compareTo(player2ClownNumber);
		if(comparePlayer1ClownWithPlayer2Clowns>0){
			player1.addVictoryPoints(3);
		}
		if(comparePlayer1ClownWithPlayer2Clowns<0){
			player2.addVictoryPoints(3);
		}
		
		//De esta manera se puede hacer para mas de 2 jugadores		
//		Integer playerClownNumber;
//		Integer maximumClownNumber=-1;
//		Integer sameClownNumberTimes=0;
//		List<Integer> clownNumber=CollectionsFactory.createListFactory().createList();
//		for(Player thisPlayer:playerList){
//			Map<Talent,Integer> thisPlayerTalents = thisPlayer.getTalents();
//			if(thisPlayerTalents.containsKey(Clown.class)){
//				playerClownNumber=playerTalents.get(Clown.class);			
//			}else{
//				playerClownNumber=0;
//			}
//			clownNumber.add(playerClownNumber);
//			if(maximumClownNumber<playerClownNumber){
//				maximumClownNumber=playerClownNumber;
//			}
//			if(maximumClownNumber==playerClownNumber){
//				sameClownNumberTimes++;
//			}
//		}
//		if(sameClownNumberTimes==0){
//			Integer playerIndex= clownNumber.indexOf(maximumClownNumber);
//			playerList.get(playerIndex).addVictoryPoints(3);
//		}
		
		
			
		//TODO si no tiene payasos: resta 3 ptos de victoria
		//TODO si no tiene animales (caballos, grandes felinos o elefantes): resta 3 ptos de victoria
		for(Player thisPlayer:playerList){
			Map<Talent,Integer> thisPlayerTalents = thisPlayer.getTalents();
			if(!thisPlayerTalents.containsKey(talent.Clown.class)){
				thisPlayer.addVictoryPoints(-3);
			}
			
			Boolean noAnimals=(!thisPlayerTalents.containsKey(talent.BigCat.class))&&
			(!thisPlayerTalents.containsKey(talent.Elephant.class))&&
			(!thisPlayerTalents.containsKey(talent.Horse.class));
			if(noAnimals){
				thisPlayer.addVictoryPoints(-3);
			}
			
		}
		//TODO si tiene mas dinero: suma 3 ptos de victoria. Si hay empate no suma
		Integer player1Money=player1.getMoney();
		Integer player2Money=player2.getMoney();
		Integer comparePlayer1MoneyWithPlayer2Money=player1Money.compareTo(player2Money);
		if(comparePlayer1MoneyWithPlayer2Money>0){
			player1.addVictoryPoints(3);
		}
		if(comparePlayer1MoneyWithPlayer2Money<0){
			player2.addVictoryPoints(3);
		}
		
		//TODO si tiene mas actuaciones: suma 3 ptos de victoria. Si hay empate no suma
		Integer player1Performances=player1.getPerfomancesUsed().size();
		Integer player2Performances=player2.getPerfomancesUsed().size();
		Integer comparePlayer1PerformancesWithPlayer2Performances=player1Performances.compareTo(player2Performances);
		if(comparePlayer1PerformancesWithPlayer2Performances>0){
			player1.addVictoryPoints(3);
		}
		if(comparePlayer1PerformancesWithPlayer2Performances<0){
			player2.addVictoryPoints(3);
		}
		//TODO si tiene mas reputacion: suma 3 ptos de victoria. Si hay empate no suma
		Integer player1Reputation=player1.getReputation();
		Integer player2Reputation=player2.getReputation();
		Integer comparePlayer1ReputationWithPlayer2Reputation=player1Reputation.compareTo(player2Reputation);
		if(comparePlayer1ReputationWithPlayer2Reputation>0){
			player1.addVictoryPoints(3);
		}
		if(comparePlayer1ReputationWithPlayer2Reputation<0){
			player2.addVictoryPoints(3);
		}
	}
	

}
