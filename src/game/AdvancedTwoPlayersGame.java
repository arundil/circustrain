package game;

import game.factory.GameFactory;

import java.util.List;
import player.Player;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import commands.CommandExecuteCase;
import commands.CommandPlayerState;
import commands.CommandStealTalent;

public class AdvancedTwoPlayersGame extends TwoPlayersGame {
	
	public AdvancedTwoPlayersGame(){
		super();
		for(int i=0;i<2;i++){
			String name=readDataFromKeyBoard.takeParametersToString("Player name: ");
			Player player=GameFactory.createPlayer(name);
			player.addTalent(theClown);
			talentBag.removeTalent(clown);
			player.addActionCards(GameFactory.inicializateActionCards(this, player));
			playerList.add(player);
		}
	}

	

	public void runGame(){
		System.out.println("\n \n Cities with performance: "+ board.getCitiesWithPerfomance() +"\n \n");
		
		for(Player playerSelectsCity:playerList){
			playerSelectsCity.moveCity(selectCanadianCity());
		}
		
		while(week<27){
			String oldMonth=this.getMonth();
			super.refreshMonth();
			String newMonth=this.getMonth();
			//Si hay cambio de mes se llevaran a cabo las acciones de fin de mes
			if(!(oldMonth.equals(newMonth))){
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
				selectCase(currentPlayer);
				
				//Se lleva a cabo la accion que el jugador a elegido
				CommandExecuteCase executeCase=new CommandExecuteCase(currentPlayer, this);
				executeCase.execute();				
			}
			//Se mira el número de ciudades y se añaden si es el caso
			completeBoardPerformances();					
			week++;			
		}
		this.gameOver();
		results();
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
	
	@Override
	public void gameOver(){
		finalWage();
		higherClownNumber();
		higherMoneyAmount();
		higherPerformancesNumber();
		higherReputation();
		noClownsNoAnimals();
		results();
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
	
	void selectCase(Player player){
		String action1="1 : Play one Action card from my hand";
		String action2="2 : Play one Action card from my discard pile";		
		String action3="3 : Collect money from the bank";

		String askBasicAction = "What are you going to do:" + "\n" + action1;
		String askAllActions = askBasicAction + "\n" + action2+"\n" + action3;
		String askActionsDiscardedNoMoney = askBasicAction + "\n" + action2;
		String askActionsNoDiscardedMoney = askBasicAction + "\n" + action3;

		String askBasicActionCondition = "1";
		String askAllActionsCondition = "1,2,3";
		String askActionsDiscardedNoMoneyCondition = "1,2";
		String askActionsNoDiscardedMoneyCondition = "1,3";

		String action="1";
		
		
		if(!this.getMonth().equals("AUGUST") || !this.getMonth().equals("SEPTEMBER")){
			//Si puede perder 2 puntos de reputacion y tiene cartas descartadas,podra optar a jugar una carta de accion de su mano,
			//jugar una carta de accion descartada o a obtener dinero del banco
			if(player.getReputation()<=6 && !player.getdiscartpile().isEmpty()){
				action=readDataFromKeyBoard.takeParametersToStringRestricted(askAllActions, askAllActionsCondition);

			}else{	
				//Si solo puede perder 1 punto de reputacion solo podra optar a jugar una carta de accion de su mano o a coger dinero del banco
				if(player.getReputation()<=7){
					action=readDataFromKeyBoard.takeParametersToStringRestricted(askActionsNoDiscardedMoney, askActionsNoDiscardedMoneyCondition);

				}else{
					action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, askBasicActionCondition);
				}
			}						
		}else{
			//Si puede perder 4 puntos de victoria, podra optar a jugar una carta de accion de su mano o a jugar una carta de accion descartada
			if(player.getVictoryPoints()>=4){
				action=readDataFromKeyBoard.takeParametersToStringRestricted(askActionsDiscardedNoMoney, askActionsDiscardedNoMoneyCondition);
			}else{
				action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, askBasicActionCondition);
			}
		}
		this.setFollowingAction(action);
	}

}
