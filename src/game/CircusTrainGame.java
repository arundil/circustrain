package game;

import game.factory.GameFactory;

import java.util.List;
import java.util.Set;

import actionCards.ActionCard;
import actionCards.RestImpl;
import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;
import board.City;
import performance.BankruptCircus;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;

public abstract class CircusTrainGame{
	protected static String month;
	protected static Integer week;
	protected Board board;
	protected PerformanceBag performanceBag;
	protected String followingAction;
	protected List<Talent> theClown=CollectionsFactory.createListFactory().createList();
	protected Talent clown = GameFactory.createTalent("CLOWN");
	protected TalentBag talentBag;
	protected List<Player> playerList;
	
	protected abstract void gameOver();
	protected abstract void finalWage();
	protected abstract void results();
	protected abstract void finalMonth();
	protected abstract void selectCase(Player player);
	protected abstract void rotatePlayers();
	protected abstract void collectMoney(Player player);
	protected abstract void playerState(Player player);

	
	public CircusTrainGame(){
		playerList=CollectionsFactory.createListFactory().createList();
		board=GameFactory.createBoard();
		performanceBag= GameFactory.createPerformanceBag();
		talentBag = GameFactory.createTalentBag();
		theClown.add(clown);
		week = 0;
		month = "APRIL";
		refreshMonth();	
		completeBoardPerformances();
	}



	public void refreshMonth(){
		if(week>=0 && week<=3)month = "APRIL";
		if(week>=4 && week<=8) month = "MAY";
		if(week>=9 && week<=12)month = "JUNE";
		if(week>=13 && week<=17)month = "JULY";
		if(week>=18 && week<=21)month = "AUGUST";
		if(week>=22 && week<=26)month = "SEPTEMBER";	
	}

	public void completeBoardPerformances(){
		if(month.equals("APRIL") || month.equals("MAY")){
			while(board.getCitiesWithPerfomance().size()<8){
				Performance randomPerformance = performanceBag.getPerformance("green");
				
				if(randomPerformance instanceof BankruptCircus){
					BankruptCircus bck = (BankruptCircus) randomPerformance;
					for(Talent t: bck.getTalentCircus()){
						if(talentBag.getNumTalents(t)>0){
							talentBag.removeTalent(t);
						}else{
							bck.getTalentCircus().remove(t);
						}
					}
					board.addPerfomanceInRandomCity(bck);
				}else
					board.addPerfomanceInRandomCity(randomPerformance);

				performanceBag.removePerformance(randomPerformance);
			}
		}
		
		if(month.equals("JUNE") || month.equals("JULY")){
			while(board.getCitiesWithPerfomance().size()<10){
				Performance randomPerformance=performanceBag.getPerformance("yellow");
				if(randomPerformance instanceof BankruptCircus){
					BankruptCircus bck = (BankruptCircus) randomPerformance;
					for(Talent t: bck.getTalentCircus()){
						if(talentBag.getNumTalents(t)>0){
							talentBag.removeTalent(t);
						}else{
							bck.getTalentCircus().remove(t);
						}
					}
					board.addPerfomanceInRandomCity(bck);
				}else
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
	

	
	public abstract void noClownsNoAnimals();
	
	public Board getBoard(){
		return board;
	}
	
	public String getFollowingAction(){
		return followingAction;
	}
	
	protected City selectCanadianCity(Player selectorPlayer){
		List<City> canadianCityList=board.getCanadianCities();
		String askCanadianCity=selectorPlayer.getName()+", Seleccione una ciudad canadiense: "+"\n";
		String askCanadianCityConditions="";
		
		for(int i=0;i<canadianCityList.size();i++){
			Integer optionsCount=i+1;
			askCanadianCityConditions=askCanadianCityConditions+(optionsCount)+",";
			askCanadianCity=askCanadianCity+"["+(optionsCount)+"] "+canadianCityList.get(i).getName()+"\n";
		}
		String selectedCanadianCity=readDataFromKeyBoard.takeParametersToStringRestricted(askCanadianCity, askCanadianCityConditions);
		Integer citySelector=new Integer(selectedCanadianCity);
		return canadianCityList.get(citySelector);
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
	
	
	protected void showPerformanceSituation() {
		System.out.println("\n \n Ciudades con actuación: "+ board.getCitiesWithPerfomance() +"\n \n");
	}
	
	public void runGame(){

		showPerformanceSituation();
		canadianSelector();
		
		while(week<27){
			//Comprueba si se ha cambiado de mes y en caso positivo, ejecuta las acciones de cambio de mes.
			monthChangeComprobator();
			//Mostrar ciudades con eventos
			showPerformanceSituation();
			System.out.println("\n \n Esta es la semana " + week + " del mes " + month);
			
			for(Player currentPlayer : playerList){
				//Se muestra el estado del jugador
				System.out.println("\n \n Es tu turno, " + currentPlayer.getName());
				playerState(currentPlayer);
				
				//Se le pregunta al jugador que va a hacer segun sus condiciones actuales
				selectCase(currentPlayer);
				
				//Se lleva a cabo la accion que el jugador a elegido
				executeCase(currentPlayer);				
				
				//Se mira el número de ciudades y se añaden si es el caso
				completeBoardPerformances();					
			}
			week++;			
		}
		gameOver();
		results();
	}
	private void monthChangeComprobator() {
		String oldMonth=this.getMonth();
		refreshMonth();
		String newMonth=this.getMonth();
		//Si hay cambio de mes se llevaran a cabo las acciones de fin de mes
		if(!(oldMonth.equals(newMonth))){
			finalMonth();
			rotatePlayers();
		}
	}
	protected void canadianSelector() {
		for(Player playerSelectsCity:playerList){
			playerSelectsCity.moveCity(selectCanadianCity(playerSelectsCity));
		}
	}
	
	protected void executeCase(Player player){
		if(getFollowingAction().equals("1")){
			
			playActionCard(player);
		}else{
			if(getFollowingAction().equals("2")){
				
				playDiscardActionCards(player);
			}
			if(getFollowingAction().equals("3")){
				collectMoney(player);
			}
		}
	}
	
	protected void commonPlayerState(Player player) {
		String messageForTwoWeeksPerformance = 
			"Debes actuar " + player.getWeeksToPerformance()+" vez/veces más para puntuar.";
		if(player.getCity().hasPerfomance()){
			
			//TODO: Peste, peste, peste.....
			if(player.getCity().getPerformance() instanceof PerformanceDemand){
				PerformanceDemand performance =(PerformanceDemand) player.getCity().getPerformance();
				if(performance.isTwoWeeks()){			
					System.out.println("Recuerda que estás en una ciudad que tiene una demanda de actuación de dos semanas."+"\n"+messageForTwoWeeksPerformance);
				}
			}
		}
		String actionCardList=player.getActionCards().toString();
		System.out.println("Tienes la/s siguiente/s carta/s de acción: \n "+actionCardList);
		if(!player.getdiscartpile().isEmpty()){
			String discardActionCardList=player.getdiscartpile().toString();			
			System.out.println("Tienes la/s siguiente/s carta/s de acción en tu pila de cartas descartadas: "+discardActionCardList);
		}
		System.out.println("Tienes los siguientes talentos: "+player.getTalents().toString());
		System.out.println("Tu reputación es "+player.getReputation());			
	//No haria falta si mostramo el tablero.
		System.out.println("Tu tirada de dado máxima es: "+player.getHigherDiceScore());
		
		System.out.println("Actualmente estás en: "+player.getCity().toString());
		System.out.println("Tienes "+player.getMoney()+" $");
	}
	
	protected void playActionCard(Player player){
		List<ActionCard> actionCardList=player.getActionCards();
		Set<Integer> actionCardIdSet=CollectionsFactory.createSetFactory().createSet();
		for(ActionCard c:actionCardList){
			actionCardIdSet.add(c.getIdCard());
		}
		System.out.println(actionCardList.toString());
		Integer cardIdToBePlayed=-1;
		while(!actionCardIdSet.contains(cardIdToBePlayed)){
			cardIdToBePlayed=readDataFromKeyBoard.takeParametersToInteger("Selecciona una carta:");
		}
		for(ActionCard actionCard:actionCardList){
			if(actionCard.getIdCard()==cardIdToBePlayed){
				if(actionCard instanceof RestImpl){
					actionCard = new RestImpl(this,player);
				}
				actionCard.execute();
				
				player.discardActionCard(cardIdToBePlayed);
				
				break;
			}
		}
		if(player.getActionCards().isEmpty()){
			player.getActionCards().addAll(player.getdiscartpile());
			player.getdiscartpile().clear();
		}
	}
	
	protected void playDiscardActionCards(Player player){
		List<ActionCard> discardActionCardList=player.getdiscartpile();
		System.out.println(discardActionCardList.toString());
		Integer cardIdToBePlayed=readDataFromKeyBoard.takeParametersToInteger("Seleccione una carta: ");
		for(ActionCard actionCard:discardActionCardList){
			if(actionCard.getIdCard()==cardIdToBePlayed){
				actionCard.execute();
				if((getMonth()).equals("AUGUST") || (getMonth()).equals("SEPTEMBER")){
					player.addVictoryPoints(-4);
				}else{
					player.addReputation(2);
				}
			}
		}
	}

	
}