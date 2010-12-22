package player;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.Math;
import actionCards.ActionCard;
import board.City;
import performance.Performance;
import performance.PerformanceDemand;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;


public class PlayerImpl implements Player {
	
	private String name;
	private Integer money,reputation,victoryPoints,perfomance_max;
	
	private List<ActionCard> action_cards,discart_pile;
	private List<Performance> perfomance_list;
	private Map<Talent,Integer> talents;
	private City city;
	
	private List<Integer> reputationList;
	private Integer weeksToPerformance; //Semanas restantes para poder puntuar en una actuacion
	
	public PlayerImpl (String n){
		name=n;
		money = 0;
		perfomance_max =0;
		victoryPoints = 0;

		discart_pile = CollectionsFactory.createListFactory().createList();
		talents = CollectionsFactory.createMapFactory().createSortedMap();
		perfomance_list = CollectionsFactory.createListFactory().createList();
		reputationList=initializeReputation();
		reputation = 1;
		city = null;
		weeksToPerformance=1;
	}
	
	public Integer getWeeksToPerformance(){
		return weeksToPerformance;
	}
	
	public void setWeeksToPerformance(Integer weeks){
		weeksToPerformance=weeks;
	}
	
	@Override
	public String getName() {
		return name;
	}
		
	public Integer getHigherDiceScore(){
		return reputationList.get(this.getReputation());
	}
	public void addActionCards(List<ActionCard> actioncards){
		action_cards = actioncards; 
	}

	@Override
	public ActionCard discardActionCard(Integer id) {
		ActionCard descartedCard =null;
		for (ActionCard card : action_cards){
			if (card.getIdCard().equals(id)){
				descartedCard= card;
				discart_pile.add(card);
				action_cards.remove(card);
				break;
			}
		}
		return descartedCard;
	}
	
	@Override
	public boolean addActionCard(ActionCard card) { //metodo para rescatar una carta de la pila.
		boolean addedCard =false;
		if(discart_pile.contains(card)){
			discart_pile.remove(card);
			action_cards.add(card);
			addedCard =true;
		}
		return addedCard;
	}

	@Override
	public boolean addMoney(Integer money) {
		this.money = this.money+money;
		return true;
	}

	@Override
	public boolean addPerfomanceUsed(Performance performance) {
		return perfomance_list.add(performance);
	}

	@Override
	public boolean addPerformance(Integer performancePoints) {
		perfomance_max = Math.max(perfomance_max,performancePoints);
		return true;
	}

	@Override
	public boolean addReputation(Integer reputationIncrement) {
		reputation = reputation+reputationIncrement;
		return true;
	}

	@Override
	public void addTalent(List<Talent> talentsToAdd) {
		
		for (Talent talent :talentsToAdd){
			if (talents.containsKey(talent)){
				Integer numberOfTalents = talents.get(talent);
				talents.put(talent, numberOfTalents+1);
			}
			else{
				talents.put(talent, 1);
			}
		}
	}

	@Override
	public boolean addVictoryPoints(Integer victoryPointsToAdd) {
		victoryPoints = victoryPoints +victoryPointsToAdd;
		return true;
	}



	@Override
	public List<ActionCard> getActionCards() {
		return action_cards;
	}

	@Override
	public Integer getMoney() {
		return money;
	}

	@Override
	public List<Performance> getPerfomancesUsed() {
		return perfomance_list;
	}

	@Override
	public Integer getPerformanceMax() {
		return perfomance_max;
	}

	@Override
	public Integer getReputation() {
		return reputation;
	}

	@Override
	public Map<Talent, Integer> getTalents() {
		return talents;
	}

	@Override
	public Integer getVictoryPoints() {
		return victoryPoints;
	}

	@Override
	public List<ActionCard> getdiscartpile() {
		return discart_pile;
	}

	@Override
	public City getCity() {
		return city;
	}

	@Override
	public void moveCity(City cityToGo) {
		city = cityToGo;
	}
	
	public void discardTalent(Talent talentToDiscard){
		if(talents.get(talentToDiscard)<=1){
			talents.remove(talentToDiscard);			
		}else{
			talents.put(talentToDiscard, talents.get(talentToDiscard)-1);
		}
	}
	@Override
	
	public String toString() {
		return "Your turn "+getName()+ ". You are now in " +getCity()+ ".You have $"+getMoney();
	}

	public void playActionCard(){
		List<ActionCard> actionCardList=this.getActionCards();
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

				actionCard.execute();
				
				discardActionCard(cardIdToBePlayed);
				
				break;
			}
		}
		if(getActionCards().isEmpty()){
			getActionCards().addAll(getdiscartpile());
			getdiscartpile().clear();
		}
	}
	
	public void playDiscardActionCards(String month){
		List<ActionCard> discardActionCardList=getdiscartpile();
		System.out.println(discardActionCardList.toString());
		Integer cardIdToBePlayed=readDataFromKeyBoard.takeParametersToInteger("Seleccione una carta: ");
		for(ActionCard actionCard:discardActionCardList){
			if(actionCard.getIdCard()==cardIdToBePlayed){
				actionCard.execute();
				if((month).equals("AUGUST") || (month).equals("SEPTEMBER")){
					addVictoryPoints(-4);
				}else{
					addReputation(2);
				}
			}
		}
	}
	
	public void collectMoney(){
		addMoney(5);
		addReputation(1);
	}
	
	public void playerState() {
		String messageForTwoWeeksPerformance = 
			"Debes actuar " + getWeeksToPerformance()+" vez/veces más para puntuar.";
		if(getCity().hasPerfomance()){
			
			//TODO: Peste, peste, peste.....
			if(getCity().getPerformance() instanceof PerformanceDemand){
				PerformanceDemand performance =(PerformanceDemand)getCity().getPerformance();
				if(performance.isTwoWeeks()){			
					System.out.println("Recuerda que estás en una ciudad que tiene una demanda de actuación de dos semanas."+"\n"+messageForTwoWeeksPerformance);
				}
			}
		}
		String actionCardList=getActionCards().toString();
		System.out.println("Tienes la/s siguiente/s carta/s de acción: \n "+actionCardList);
		if(!getdiscartpile().isEmpty()){
			String discardActionCardList=getdiscartpile().toString();			
			System.out.println("Tienes la/s siguiente/s carta/s de acción en tu pila de cartas descartadas: "+discardActionCardList);
		}
		System.out.println("Tienes los siguientes talentos: "+getTalents().toString());
		System.out.println("Tu reputación es "+getReputation());			
	//No haria falta si mostramo el tablero.
		System.out.println("Tu tirada de dado máxima es: "+getHigherDiceScore());
		
		System.out.println("Actualmente estás en: "+getCity().toString());
		System.out.println("Tienes "+getMoney()+" $");
	}
	
	
	//=========================================================================
	//==						Métodos Privados							 ==
	//=========================================================================
	
	


	
	private List<Integer> initializeReputation(){
		List<Integer> list=CollectionsFactory.createListFactory().createList();
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(1);
		
		return list;		
	}


	
}
