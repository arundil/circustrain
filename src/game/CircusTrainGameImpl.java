package game;

import game.factory.GameFactory;

import java.util.List;

import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;
import player.Player;
import utiles.factoria.CollectionsFactory;

public class CircusTrainGameImpl implements CircusTrainGame{
	
	private List<Player> playerList;
	private static Integer week;
	private static String month;
	private Board board;
	private PerformanceBag performanceBag;
	private TalentBag talentBag;
	private Integer numberOfPlayers;
	
	public CircusTrainGameImpl(){
		playerList=CollectionsFactory.createListFactory().createList();
		board=GameFactory.createBoard();
		performanceBag= GameFactory.createPerformanceBag();
		talentBag = GameFactory.createTalentBag();
	}
	
	public String getMonth(){
		return month;
	}

	@Override
	public void gameOver() {
		// TODO Reglas de fin de juego		
	}
	
	public void finalMonth(){
		//TODO Reglas de fin de mes
	}
	
	@Override
	public void runGame() {
		Integer playerSelector=0;
		String action1="1 : Play one Action card from my hand";
		String action2="2 : Play one Action card from my discard pile";		
		String action3="3 : Collect money from the bank";
		String askActions="What are you going to do:"+"\n"+action1+"\n"+action2+"\n";
		String askActionsWithMoney=askActions+"\n"+action3;
		String askActionsCondition="1,2";
		String askActionsWithMoneyCondition="1,2,3";
		String followingAction="";
		while(week<27){
			String oldMonth=this.getMonth();
			refreshMonth();
			String newMonth=this.getMonth();
			//Si hay cambio de mes se llevaran a cabo las acciones de fin de mes
			if(!oldMonth.equals(newMonth)){
				finalMonth();
			}
			while(playerSelector<numberOfPlayers){
				Player currentPlayer=playerList.get(playerSelector);
				CommandPlayerState playerState=new CommandPlayerState(currentPlayer);	
				
				System.out.println("Its you turn, "+currentPlayer.getName());				
				playerState.execute();
				//Si no es ni agosto ni septiembre se activara la opcion de coger dinero del banco
				//TODO Restringir el obtener dinero del banco y el usar una carta de accion segun la reputacion
				if(!this.getMonth().equals("AUGUST") || !this.getMonth().equals("SEPTEMBER")){
					followingAction=GameFactory.takeParametersToStringRestricted(askActionsWithMoney, askActionsWithMoneyCondition);
				}else{
					followingAction=GameFactory.takeParametersToStringRestricted(askActions, askActionsCondition);
				}
				
				if(followingAction.equals("1")){
					CommandPlayActionCard playActionCard=new CommandPlayActionCard(currentPlayer);
					playActionCard.execute();
				}else{
					if(followingAction.equals("2")){
						CommandPlayDiscardActionCard playDiscardActionCard=new CommandPlayDiscardActionCard(currentPlayer, this);
						playDiscardActionCard.execute();
					}
					if(followingAction.equals("3")){
						CommandCollectMoney collectMoney=new CommandCollectMoney(currentPlayer);
						collectMoney.execute();
					}
				}			
				playerSelector++;
			}
			playerSelector=0;
			//Intercambiar orden de jugadores: ¿Haria falta el atributo first_player?
			rotatePlayers();			
			week++;			
		}			
		gameOver();
	}

	@Override
	public void startGame() {
		week=0;
		System.out.println("Welcome to Circus Train!");
		//TODO peticion de numero de jugadores
		String askNumberOfPlayers="How many players are going to play: ";
		//Habria que poner que estuviera entre 1 y 2, por ahora
		numberOfPlayers=GameFactory.takeParametersToInteger(askNumberOfPlayers);
		//TODO constructores de los jugadores segun haya
		String selectGameMode="Select game mode: BASIC, ADVANCED";
		String selectGameModeCondition="BASIC,ADVANCED";
		String gameMode=GameFactory.takeParametersToStringRestricted(selectGameMode,selectGameModeCondition);
		Boolean advancedMode=gameMode.equals("ADVANCED");
		
		if(numberOfPlayers==1){
			String name=GameFactory.takeParametersToString("Player name: ");
			Player player=GameFactory.createPlayer(name,advancedMode, true);	
			playerList.add(player);
		}else{		
			for(int i=0;i<numberOfPlayers;i++){
				Boolean firstPlayer=i==0;
				String name=GameFactory.takeParametersToString("Player name: ");
				Player player=GameFactory.createPlayer(name,advancedMode, firstPlayer);
				playerList.add(player);
			}
		}
		//TODO iniciacion de bolsas, tablero, y actuaciones
		//TODO opcion de cartas de evento
		String withEventCards="Are you going to play using Event Cards?: YES, NO";
		String withEventCardsCondition="YES,NO";
		String eventCards=GameFactory.takeParametersToStringRestricted(withEventCards, withEventCardsCondition);
		Boolean playEventCards=eventCards.equals("YES");
	}	
	
	
	private void refreshMonth(){
		if(week>=0 && week<=3)month = "APRIL";
		if(week>=4 && week<=8) month = "MAY";
		if(week>=9 && week<=12)month = "JUNE";
		if(week>=13 && week<=17)month = "JULY";
		if(week>=18 && week<=21)month = "AUGUST";
		if(week>=22 && week<=26)month = "SEPTEMBER";		
	}
	
	private void rotatePlayers(){
		List<Player> newPlayerList=CollectionsFactory.createListFactory().createList();
		for(int i=0;i<playerList.size();i++){
			newPlayerList.add(playerList.get(i+1));	
		}
		newPlayerList.add(playerList.get(0));
		playerList.clear();
		playerList.addAll(newPlayerList);
	}
	
}
