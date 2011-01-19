package game;

import game.factory.GameFactory;
import gameState.GameState;
import gameState.GreenState;

import java.util.List;
import java.util.Map;

import performance.BankruptCircus;
import performance.Performance;
import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import actionCards.ActionCard;
import actionCards.BasicMoveImpl;
import actionCards.FastMoveImpl;
import actionCards.HoldImpl;
import actionCards.OvernighterImpl;
import actionCards.RestImpl;
import actionCards.TravelImpl;
import actionCards.WagesImpl;
import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;
import board.City;

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
	protected Integer basicMoneyMultiplicator=1;
	
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
	
	protected abstract void refreshToFire(Player player);
	protected abstract void pointsConversor(Player player);
	public abstract void addRestActionCard();
	
	
	
	public CircusTrainGame(){
		playerList=CollectionsFactory.createListFactory().createList();
		board=GameFactory.createBoard();
		performanceBag= GameFactory.createPerformanceBag();
		talentBag = GameFactory.createTalentBag();
		theClown.add(clown);
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
		showPerformanceSituation();
		canadianSelector();
		
		while(gameState.getWeek()<27){
			
			//Mostrar ciudades con eventos
			showPerformanceSituation();
			System.out.println("\n \n Esta es la semana " + gameState.getHumanWeek() + " del mes " + gameState.getMonth());
			
			for(Player currentPlayer : playerList){
				//Se muestra el estado del jugador
				System.out.println("\n \n Es tu turno, " + currentPlayer.getName());
				currentPlayer.playerState();
				
				//Se le pregunta al jugador que va a hacer segun sus condiciones actuales
				selectCase(currentPlayer);
				
				//Se lleva a cabo la accion que el jugador a elegido
				executeCase(currentPlayer);	
				//Transforma puntos de victoria y puntos de actuacion en dinero según el caso
				pointsConversor(currentPlayer);
				//Comprueba si todas las cartas están descartadas y las restaura
				checkEmptyDeck(currentPlayer);
				
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
	
	public void toPay(Player player,Integer multiplicator){
		if(!player.getTalents().isEmpty()){
			Map<Talent,Integer> talentMap = player.getTalents();
			Integer totalMoneyToPay=0;
			String payAllTalentsQuestion="Tienes dinero suficiente para pagar a todos los talentos de una sola vez. ¿Quieres pagarles?:\n[1] Si\n[2] No";
			String payAllTalentsQuestionRestrictions="1,2";
			for(Talent talent: talentMap.keySet()){
				totalMoneyToPay=totalMoneyToPay+talent.getWage()*basicMoneyMultiplicator*multiplicator*talentMap.get(talent);
			}
			if(player.getMoney()-totalMoneyToPay>=0){
				String answer=readDataFromKeyBoard.takeParametersToStringRestricted(payAllTalentsQuestion, payAllTalentsQuestionRestrictions);
				if(answer.equals("1")){
					player.addMoney(-totalMoneyToPay);
				}else{
					toFire(player);
					toPay(player,multiplicator);
				}			
			}else{
				toFire(player);
				toPay(player,multiplicator);
			}
		}
	}
	
	protected void toFire(Player player){
		Map<Talent,Integer> talentMap=player.getTalents();
		List<Talent> talentList=CollectionsFactory.createListFactory().createList();
		String question="¿A qué talento vas a despedir?\n";
		String conditions="";
		Integer answerNumber=1;		
		
		for(Talent talent:talentMap.keySet()){
			conditions=conditions+answerNumber+",";
			talentList.add(talent);
			question=question+"["+answerNumber+"] "+talent.getName()+" Cantidad restante: "+talentMap.get(talent)+"\n";
			answerNumber++;
		}
		
		Integer answer=new Integer(readDataFromKeyBoard.takeParametersToStringRestricted(question, conditions));
		Talent talentToBeFired=talentList.get(answer-1);
		player.discardTalent(talentToBeFired);
		talentBag.addTalent(talentToBeFired);
		
		refreshToFire(player);		
	}
	
	protected void checkEmptyDeck(Player player){
		if(player.getActionCards().isEmpty()){
			player.getActionCards().addAll(player.getdiscartpile());
			player.getdiscartpile().clear();
		}
	}
	
	public static List<ActionCard> inicializateActionCards(CircusTrainGame ctg, Player player){
		List<ActionCard> ac = CollectionsFactory.createListFactory().createList();
		ac.add(new TravelImpl(player));
		ac.add(new BasicMoveImpl(player));
		ac.add(new BasicMoveImpl(player));
		ac.add(new FastMoveImpl(player));
		ac.add(new WagesImpl(ctg,player));
		ac.add(new OvernighterImpl(player));
		ac.add(new HoldImpl(player));
		return ac;
	}
	
	public void setPlayerList(List<Player> list){
		playerList=list;
	}

	
}