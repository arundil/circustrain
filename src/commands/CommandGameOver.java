package commands;

import game.AbstractCommand;
import game.CircusTrainGame;

import java.util.List;
import java.util.Map;

import player.Player;
import talent.Clown;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

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
		Map<Talent,Integer> playerTalents = player1.getTalents();
		//De esta manera se puede hacer para mas de 2 jugadores		
		Integer playerClownNumber=0;
		Integer maximumClownNumber=-1;
		Integer sameClownNumberTimes=0;
		Integer previousClownNumber=0;
		List<Integer> clownNumber=CollectionsFactory.createListFactory().createList();
		for(int i=0;i<playerList.size();i++){
			Player thisPlayer=playerList.get(i);
			Map<Talent,Integer> thisPlayerTalents = thisPlayer.getTalents();
			if(thisPlayerTalents.containsKey(Clown.class)){
				playerClownNumber=playerTalents.get(Clown.class);			
			}else{
				playerClownNumber=0;
			}
			clownNumber.add(playerClownNumber);
			if(maximumClownNumber<playerClownNumber){
				maximumClownNumber=playerClownNumber;
			}
			if(i>0){
				Player previousPlayer=playerList.get(i-1);
				if(previousPlayer.getTalents().containsKey(Clown.class)){
					previousClownNumber=playerTalents.get(Clown.class);			
				}else{
					previousClownNumber=0;
				}
			}
			if(maximumClownNumber==previousClownNumber){
				sameClownNumberTimes++;
			}
		}
		if(sameClownNumberTimes==0){
			Integer playerIndex= clownNumber.indexOf(maximumClownNumber);
			playerList.get(playerIndex).addVictoryPoints(3);
		}
		
		
			
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
//		Integer player1Money=player1.getMoney();
//		Integer player2Money=player2.getMoney();
//		Integer comparePlayer1MoneyWithPlayer2Money=player1Money.compareTo(player2Money);
//		if(comparePlayer1MoneyWithPlayer2Money>0){
//			player1.addVictoryPoints(3);
//		}
//		if(comparePlayer1MoneyWithPlayer2Money<0){
//			player2.addVictoryPoints(3);
//		}
		
		List<Integer> playersMoney=CollectionsFactory.createListFactory().createList();
		Integer sameMoneyTimes=0;
		Integer maximumMoney=-1;
		Integer previousMoney=0;
		for(int i=0;i<playerList.size();i++){
			if(i>0){
				previousMoney=playerList.get(i-1).getMoney();
			}
			Player thisPlayer=playerList.get(i);
			playersMoney.add(thisPlayer.getMoney());
			if(maximumMoney<thisPlayer.getMoney()){
				maximumMoney=thisPlayer.getMoney();
			}
			if(previousMoney==thisPlayer.getMoney()){
				sameMoneyTimes++;
			}
		}
		if(sameMoneyTimes==0){
			Integer playerIndex=playersMoney.indexOf(maximumMoney);
			playerList.get(playerIndex).addVictoryPoints(3);
		}
		
		
		//TODO si tiene mas actuaciones: suma 3 ptos de victoria. Si hay empate no suma
//		Integer player1Performances=player1.getPerfomancesUsed().size();
//		Integer player2Performances=player2.getPerfomancesUsed().size();
//		Integer comparePlayer1PerformancesWithPlayer2Performances=player1Performances.compareTo(player2Performances);
//		if(comparePlayer1PerformancesWithPlayer2Performances>0){
//			player1.addVictoryPoints(3);
//		}
//		if(comparePlayer1PerformancesWithPlayer2Performances<0){
//			player2.addVictoryPoints(3);
//		}
		
		List<Integer> playersNumberOfPerformances=CollectionsFactory.createListFactory().createList();
		Integer sameNumberOfPerformancesTimes=0;
		Integer maximumNumberOfPerformances=-1;
		Integer previousNumberOfPerformances=0;
		for(int i=0;i<playerList.size();i++){
			if(i>0){
				previousNumberOfPerformances=playerList.get(i-1).getPerfomancesUsed().size();
			}
			Player thisPlayer=playerList.get(i);
			playersNumberOfPerformances.add(thisPlayer.getPerfomancesUsed().size());
			if(maximumNumberOfPerformances<thisPlayer.getPerfomancesUsed().size()){
				maximumNumberOfPerformances=thisPlayer.getPerfomancesUsed().size();
			}
			if(previousNumberOfPerformances==thisPlayer.getPerfomancesUsed().size()){
				sameNumberOfPerformancesTimes++;
			}
		}
		if(sameNumberOfPerformancesTimes==0){
			Integer playerIndex=playersNumberOfPerformances.indexOf(maximumNumberOfPerformances);
			playerList.get(playerIndex).addVictoryPoints(3);
		}
		//TODO si tiene mas reputacion: suma 3 ptos de victoria. Si hay empate no suma
//		Integer player1Reputation=player1.getReputation();
//		Integer player2Reputation=player2.getReputation();
//		Integer comparePlayer1ReputationWithPlayer2Reputation=player1Reputation.compareTo(player2Reputation);
//		if(comparePlayer1ReputationWithPlayer2Reputation>0){
//			player1.addVictoryPoints(3);
//		}
//		if(comparePlayer1ReputationWithPlayer2Reputation<0){
//			player2.addVictoryPoints(3);
//		}
		
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
