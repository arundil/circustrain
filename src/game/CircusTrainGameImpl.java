package game;

import game.factory.GameFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;
import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

public class CircusTrainGameImpl implements CircusTrainGame{
	
	private List<Player> playerList;
	private static Integer week;
	private static String month;
	private Board board;
	private PerformanceBag performanceBag;
	private TalentBag talentBag;
	private Integer numberOfPlayers;
	private String followingAction;	
	
	public CircusTrainGameImpl(){
		playerList=CollectionsFactory.createListFactory().createList();
		board=GameFactory.createBoard();
		performanceBag= GameFactory.createPerformanceBag();
		talentBag = GameFactory.createTalentBag();
	}
	
	public List<Player> getPlayerList(){
		return playerList;
	}	
	
	public String getMonth(){
		return month;
	}	
	
	public void setFollowingAction(String action){
		followingAction=action;
	}
	
	public String getFollowingAction() {
		return followingAction;
	}
	
	public void gameOver() {
		// TODO Reglas de fin de juego		
	}
	
	public void finalMonth(){
		//Acciones de final de mes independientemente del mes que sea ¿Podria ser un comando?
		List<Map<Talent,Integer>> playersTalentsList=CollectionsFactory.createListFactory().createList();
		for(Player player:playerList){
			playersTalentsList.add(player.getTalents());
		}
		//TODO List<Player>
		Set<Entry<Talent,Integer>> numberOfTalents1=playersTalentsList.get(0).entrySet();			
		Set<Entry<Talent,Integer>> numberOfTalents2=playersTalentsList.get(1).entrySet();
		
		for(Entry<Talent,Integer> entry1:numberOfTalents1){
			for(Entry<Talent,Integer> entry2:numberOfTalents2){
				if(entry1.getKey().equals(entry2.getKey())){
					int compare=entry1.getValue().compareTo(entry2.getValue());
					if(compare>0)
						playerList.get(0).addVictoryPoints(entry1.getValue());
					if(compare<0)
						playerList.get(1).addVictoryPoints(entry2.getValue());						
					break;
				}
			}
		}
//		TODO List<Player>
		int comparatorPerformancePoints =playerList.get(0).getPerformanceMax().compareTo(playerList.get(1).getPerformanceMax());
		if(comparatorPerformancePoints>0)
			playerList.get(0).addVictoryPoints(4);
		if(comparatorPerformancePoints<0)
			playerList.get(1).addVictoryPoints(4);
			
		//TODO Robar talentos
		
		
		
		//TODO Reglas de fin de mes
	}
	
	public void runGame() {
		Integer playerSelector=0;		
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
				//Se le pregunta al jugador que va a hacer segun sus condiciones actuales
				CommandSelectCase selectCase=new CommandSelectCase(currentPlayer, this);
				selectCase.execute();				
				//Se lleva a cabo la accion que el jugador a elegido
				CommandExecuteCase executeCase=new CommandExecuteCase(currentPlayer, this);
				executeCase.execute();				
				playerSelector++;
			}
			playerSelector=0;
			//Intercambiar orden de jugadores: �Haria falta el atributo first_player?
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
		if(numberOfPlayers!=1){
			List<Player> newPlayerList=CollectionsFactory.createListFactory().createList();
			for(int i=1;i<playerList.size();i++){
				newPlayerList.add(playerList.get(i));	
			}
			newPlayerList.add(playerList.get(0));
			playerList.clear();
			playerList.addAll(newPlayerList);
		}
	}

	
}
