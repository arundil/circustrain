package game;

import game.factory.GameFactory;
import gameState.GameState;
import gameState.GreenState;

import java.util.List;
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
	protected GameState gameState=null;
	
	protected abstract void gameOver();
	protected abstract void finalWage();
	protected abstract void results();
	public abstract void finalMonth();
	protected abstract void stealTalent(Player player);
	public abstract void stealTalentSelector();
	protected abstract void selectCase(Player player);
	protected abstract void rotatePlayers();
	protected abstract void executeCase(Player player);
	protected abstract void noClownsNoAnimals();
	
	
	public CircusTrainGame(){
		playerList=CollectionsFactory.createListFactory().createList();
		board=GameFactory.createBoard();
		performanceBag= GameFactory.createPerformanceBag();
		System.out.println(performanceBag.getGreenBag().size());
		talentBag = GameFactory.createTalentBag();
		theClown.add(clown);
		week=0;
		gameState=new GreenState(this);
	}

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
		return canadianCityList.get(citySelector-1);
	}
	
	public TalentBag getTalentBag(){
		return talentBag;
	}
	
	public List<Player> getPlayerList(){
		return playerList;
	}	
	
	public String getMonth(){
		return gameState.getMonth();
	}	
	
	public void setFollowingAction(String action){
		followingAction=action;
	}
		
	protected void showPerformanceSituation() {
		System.out.println("\n \n Ciudades con actuación: "+ board.getCitiesWithPerfomance() +"\n \n");
	}
	
	public void runGame(){
		System.out.println(performanceBag.getGreenBag().size());
		showPerformanceSituation();
		canadianSelector();
		
		while(gameState.getWeek()<27){
			
			//Mostrar ciudades con eventos
			showPerformanceSituation();
			System.out.println("\n \n Esta es la semana " + gameState.getWeek() + " del mes " + gameState.getMonth());
			
			for(Player currentPlayer : playerList){
				//Se muestra el estado del jugador
				System.out.println("\n \n Es tu turno, " + currentPlayer.getName());
				currentPlayer.playerState();
				
				//Se le pregunta al jugador que va a hacer segun sus condiciones actuales
				selectCase(currentPlayer);
				
				//Se lleva a cabo la accion que el jugador a elegido
				executeCase(currentPlayer);				
				
			}
			//Incrementa la semana y en caso de cambio de mes, ejecuta las acciones de final de mes;
			gameState.incrementTime();		
		}
		gameOver();
		results();
	}

	protected void canadianSelector() {
		for(Player playerSelectsCity:playerList){
			playerSelectsCity.moveCity(selectCanadianCity(playerSelectsCity));
		}
	}
		
	public PerformanceBag getPerformanceBag(){
		return performanceBag;
	}

	public Integer getWeek(){
		return week;
	}
	
	public void completeBoardPerformances(Integer maxNumberOfPerformances){
		while(getBoard().countCitiesWithPerfomance()<maxNumberOfPerformances){
			Performance randomPerformance = gameState.getPerformance();
			if(randomPerformance instanceof BankruptCircus){
				BankruptCircus bck = (BankruptCircus) randomPerformance;
				for(Talent t: bck.getTalentCircus()){
					if(getTalentBag().getNumTypeTalent(t)>0){
						getTalentBag().removeTalent(t);
					}else{
						bck.getTalentCircus().remove(t);
					}
				}
				getBoard().addPerfomanceInRandomCity(bck);
			}else{
				getBoard().addPerfomanceInRandomCity(randomPerformance);
			}	
		}
	}
}