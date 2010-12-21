package game;

import game.factory.GameFactory;

import java.util.List;
import commands.CommandExecuteCase;
import commands.CommandPlayerState;
import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;
import board.City;
import performance.BankruptCircus;
import performance.Performance;
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
	private Integer numberOfPlayers = 2;
	
	protected abstract void gameOver();
	protected abstract void finalWage();
	protected abstract void results();
	protected abstract void finalMonth();
	protected abstract void selectCase(Player player);
	//REDEFINIR EL EXECUTECASE!! URGENTE
	protected abstract void executeCase(Player player,CircusTrainGame game);
	
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
	
	protected void rotatePlayers(){
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
				CommandPlayerState playerState = new CommandPlayerState(currentPlayer);				
				playerState.execute();
				
				//Se le pregunta al jugador que va a hacer segun sus condiciones actuales
				selectCase(currentPlayer);
				
				//Se lleva a cabo la accion que el jugador a elegido
				CommandExecuteCase executeCase=new CommandExecuteCase(currentPlayer, this);
				executeCase.execute();				
				
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
}