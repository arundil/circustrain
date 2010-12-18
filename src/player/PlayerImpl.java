package player;

import java.util.List;
import java.util.Map;
import java.lang.Math;
import actionCards.ActionCard;
import board.City;
import performance.Performance;
import talent.Talent;
import utiles.factoria.CollectionsFactory;


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
