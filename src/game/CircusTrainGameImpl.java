package game;

import game.factory.GameFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import commands.CommandExecuteCase;
import commands.CommandPay;
import commands.CommandPlayerState;
import commands.CommandSelectCanadianCity;
import commands.CommandSelectCase;
import commands.CommandStealTalent;

import actionCards.ActionCard;
import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;
import performance.Performance;
import player.Player;
import talent.Clown;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;

public class CircusTrainGameImpl implements CircusTrainGame{
	
	private List<Player> playerList;
	private static Integer week;
	private static String month;
	private Board board;
	private PerformanceBag performanceBag;
	private TalentBag talentBag;
	private Integer numberOfPlayers;
	private String followingAction;	
	private Boolean advancedMode;
	
	public CircusTrainGameImpl(){
		playerList=CollectionsFactory.createListFactory().createList();
		board=GameFactory.createBoard();
		performanceBag= GameFactory.createPerformanceBag();
		talentBag = GameFactory.createTalentBag();
	}
	
	public void startGame() {
		List<Talent> theClown=CollectionsFactory.createListFactory().createList();
		Talent clown = GameFactory.createTalent("CLOWN");

		theClown.add(clown);
		
		System.out.println("Welcome to Circus Train!");
		
		//Peticion de numero de jugadores
		String askNumberOfPlayers="How many players are going to play: ";
		String askNumberOfPlayersCondition="1,2";
		numberOfPlayers=readDataFromKeyBoard.takeParametersToIntegerRestricted(askNumberOfPlayers,askNumberOfPlayersCondition);
		
		//Seleccion de modo de juego
		String selectGameMode="Select game mode:"+"\n"+"1 : Basic mode"+"\n"+"2 : Advanced mode";
		String selectGameModeCondition="1,2";
		String gameMode=readDataFromKeyBoard.takeParametersToStringRestricted(selectGameMode,selectGameModeCondition);
		
		if(gameMode.equals("1")){
			advancedMode = false;
		}else{
			advancedMode = true;
		}
		
		if(numberOfPlayers==1){
			String name = readDataFromKeyBoard.takeParametersToString("Player name: ");
			Player player = GameFactory.createPlayer(name,advancedMode);	
			player.addTalent(theClown);
			talentBag.removeTalent(clown);
			playerList.add(player);
		}else{		
			for(int i=0;i<numberOfPlayers;i++){
				String name=readDataFromKeyBoard.takeParametersToString("Player name: ");
				Player player=GameFactory.createPlayer(name,advancedMode);
				player.addTalent(theClown);
				talentBag.removeTalent(clown);
				playerList.add(player);
			}
		}
		for(Player p: playerList){
			p.addActionCards(GameFactory.inicializateActionCards(this, p));
		}
		//opcion de cartas de evento
//		String withEventCards="Are you going to play using Event Cards?:"+"\n"+"1 : Yes, I'm pro"+"\n"+"2 : No";
//		String withEventCardsCondition="1,2";
//		String eventCards=readDataFromKeyBoard.takeParametersToStringRestricted(withEventCards, withEventCardsCondition);
	}	
	
	
	public void runGame() {
		week = 0;
		refreshMonth();
		
		performanceBag.createGreenBag();
		addCities();
		System.out.println("\n \n Cities with performance: "+ board.getCitiesWithPerfomance() +"\n \n");
		
		for(Player playerSelectsCity:playerList){
			CommandSelectCanadianCity selectCanadianCity=new CommandSelectCanadianCity(playerSelectsCity, this);
			selectCanadianCity.execute();
		}
		
		while(week<27){
			String oldMonth=this.getMonth();
			refreshMonth();
			String newMonth=this.getMonth();
			
			
			//Si hay cambio de mes se llevaran a cabo las acciones de fin de mes
			if(!(oldMonth == newMonth)){
				finalMonth();
				rotatePlayers();
			}
			System.out.println(board.getCitiesWithPerfomance().toString());
			System.out.println("\n \n This is the Week " + week + " and Mounth " + month);
			
			for(Player currentPlayer : playerList){
								
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
			addCities();					
			week++;			
		}
		System.out.println("\n \n Weeeee final del juego a irse a cenar");
		if(playerList.size()>1){
			gameOver2();			
		}else{
			gameOver1();
		}
	}
	
	public void finalMonth(){
		//Puntos de victoria segun el nº de talentos
		compareTalentsCountAndAddVictoryPoints();
		//Puntos de victoria segun actuacion maxima
		int comparatorPerformancePoints =playerList.get(0).getPerformanceMax().compareTo(playerList.get(1).getPerformanceMax());
		if(comparatorPerformancePoints>0)
			playerList.get(0).addVictoryPoints(4);
		if(comparatorPerformancePoints<0)
			playerList.get(1).addVictoryPoints(4);			
		//Robar talentos
		//En modo basico solo puede robar el que tenga menos puntos de victoria
		//Habria que invalidar lo de la reputacion si esta en modo basico				
		if(playerList.get(0).getReputation()>playerList.get(1).getReputation()){
			CommandStealTalent stealTalent=new CommandStealTalent(playerList.get(0), this);
			stealTalent.execute();
		}
		if(playerList.get(1).getReputation()>playerList.get(0).getReputation()){
			CommandStealTalent stealTalent=new CommandStealTalent(playerList.get(1), this);
			stealTalent.execute();
		}		
		//si es junio o agosto cambiar las bolsas de actuacion
		if(month.equals("JUNE")){
			performanceBag.createYellowBag();
		}
		if(month.equals("AUGUST")){
			performanceBag.createRedBag();
		}
	}
	
	
	public void gameOver1(){
		//TODO Reglas de un solo jugador.
	}
	
	//Game over de dos players.
	public void gameOver2() {
		wageCardNoDiscarded();
		higherClownNumber();
		higherMoneyAmount();
		higherPerformancesNumber();
		higherReputation();
		noClownsNoAnimals();
		results();
	}

	


	public TalentBag getTalentBag(){
		return talentBag;
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
	
	public Board getBoard(){
		return board;
	}
	
	//====================================== X =====================================
	
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
	private void compareTalentsCountAndAddVictoryPoints(){
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
	}
	private void addCities(){
		if(month.equals("APRIL") || month.equals("MAY")){
			while(board.getCitiesWithPerfomance().size()<8){
				Performance randomPerformance = performanceBag.getPerformance("green");
				board.addPerfomanceInRandomCity(randomPerformance);
				performanceBag.removePerformance(randomPerformance);
			}
		}
		if(month.equals("JUNE") || month.equals("JULY")){
			while(board.getCitiesWithPerfomance().size()<10){
				Performance randomPerformance=performanceBag.getPerformance("yellow");
				board.addPerfomanceInRandomCity(randomPerformance);
				performanceBag.removePerformance(randomPerformance);
			}
		}
		if(month.equals("AUGUST") || month.equals("SEPTEMBER")){
			while(board.getCitiesWithPerfomance().size()<12){
				Performance randomPerformance=performanceBag.getPerformance("red");
				board.addPerfomanceInRandomCity(randomPerformance);
				performanceBag.removePerformance(randomPerformance);
			}
		}
	}
	
	private void wageCardNoDiscarded() {
		for(Player player: playerList){
			for(ActionCard actioncard : player.getActionCards()){
				if(actioncard.getIdCard() == 5){
					player.addVictoryPoints(-3);
					CommandPay cmp = new CommandPay(player, this, 2);
					cmp.execute();
				}
			}
		}
		
	}
	private void higherClownNumber(){
		Integer playerClownNumber=0;
		Integer maximumClownNumber=-1;
		Integer sameClownNumberTimes=0;
		Integer previousClownNumber=0;
		List<Integer> clownNumber=CollectionsFactory.createListFactory().createList();
		for(int i=0;i<playerList.size();i++){
			Player thisPlayer=playerList.get(i);
			Map<Talent,Integer> thisPlayerTalents = thisPlayer.getTalents();
			if(thisPlayerTalents.containsKey(Clown.class)){
				playerClownNumber=thisPlayer.getTalents().get(Clown.class);			
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
					previousClownNumber=thisPlayer.getTalents().get(Clown.class);			
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
	}
	
	private void noClownsNoAnimals(){
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
	}
	
	private void higherMoneyAmount(){
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
	}
	
	private void higherPerformancesNumber(){
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
	private void results(){
		String winner="";
		Integer maxVictoryPoints=0;
		Integer drawGame=0;
		Integer previousPlayerVictoryPoints=0;
		List<Integer> playerPoints=CollectionsFactory.createListFactory().createList();
		for(int i=0;i<playerList.size();i++){
			Player player=playerList.get(i);
			if(i>0){
				previousPlayerVictoryPoints=playerList.get(i-1).getVictoryPoints();
			}
			playerPoints.add(player.getVictoryPoints());
			if(maxVictoryPoints<player.getVictoryPoints()){
				maxVictoryPoints=player.getVictoryPoints();				
			}
			if(player.getVictoryPoints()==previousPlayerVictoryPoints){
				drawGame=1;
			}
		}
		if(drawGame==1){
			winner="There's no winner."+"\n"+"============= DRAW GAME =============";
		}else{
			Integer winnerIndex=playerPoints.indexOf(maxVictoryPoints);
			Player winnerPlayer=playerList.get(winnerIndex);
			winner="Here's your winner! The winner is"+"\n"+"============= "+winnerPlayer.getName()+" =============";
		}
		System.out.println(winner+"\n"+"\n"+"---=== Thank you for playing Train Circus! ===---");
	}
	
}
