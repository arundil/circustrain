package player;

import java.util.List;
import java.util.Map;

import performance.Performance;
import performance.PerformanceDemand;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import actionCards.ActionCard;
import board.City;


public class PlayerImpl implements Player {
	
	private String name;
	private Integer money,reputation,victoryPoints,perfomance_max;
	
	private List<ActionCard> action_cards,discart_pile;
	private List<Performance> perfomance_list;
	private Map<Talent,Integer> talents;
	private City city;
	
	private List<Integer> reputationList;
	private Integer weeksToPerformance; //Semanas restantes para poder puntuar en una actuacion
	
	public PlayerImpl (String name){
		this.name=name;
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
		//Aseguro que reputation esta entre 0 y 7.
		Boolean res = false;
		Integer newReputation = reputation + reputationIncrement;
		if(newReputation<8 && newReputation>-1){
			reputation = newReputation;
			res = true;
		}
		return res;
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
		if(city.hasPerfomance()){
			city.getPerformance().land(this);
		}
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

	public void collectMoney(){
		Boolean ok = true;
		Integer level = 0;
		while(ok){
			String question="¿Cuántos niveles de reputación deseas bajar?: \n";
			String restriction="0,1,2,3,4,5,6,7";
			level = readDataFromKeyBoard.takeParametersToIntegerRestricted(question, restriction);
			if(addReputation(1*level)){
				addMoney(5*level);
				ok = false;
			}
		}
	}
	
	public void playerState() {
		String messageForTwoWeeksPerformance = 
			"Debes actuar " + getWeeksToPerformance()+" vez/veces más para puntuar.";
		if(getCity().hasPerfomance()){
			
			//TODO: Peste, peste, peste..... pues se quita y santas pascuas que cada jugador se acuerde de donde esta
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
