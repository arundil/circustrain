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
		while(week<27){
			refreshMonth();			
			/*
			 * SECUENCIA DEL JUEGO
			 */
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
		Integer numberOfPlayers=GameFactory.takeParametersToInteger(askNumberOfPlayers);
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
		String whitEventCards="Are you going to play using Event Cards?: YES, NO";
		String whitEventCardsCondition="YES,NO";
		String eventCards=GameFactory.takeParametersToStringRestricted(whitEventCards, whitEventCardsCondition);
		Boolean playEventCards=eventCards.equals("YES");
	}
	
	
	
	
	
	
	
	private void refreshMonth(){
		if(week>=0 && week<=3)month="APRIL";
		if(week>=4 && week<=8) month="MAY";
		if(week>=9 && week<=12)month = "JUNE";
		if(week>=13 && week<=17)month = "JULY";
		if(week>=18 && week<=21)month = "AUGUST";
		if(week>=22 && week<=26)month = "SEPTEMBER";		
	}
	
}
