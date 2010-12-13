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
	private Integer money,reputation,victorypoints,perfomance_max;
	private Boolean play_mode;
	private List<ActionCard> action_cards,discart_pile;
	private List<Performance> perfomance_list;
	private Map<Talent,Integer> talents;
	private City city;
	private List<Integer> reputationList;
	private Integer higherDiceScore; //Tirada de dado maxima asociada a la reputacion
	private Integer weeksToPerformance; //Semanas restantes para poder puntuar en una actuacion
	
	public PlayerImpl (String n,Boolean p_mode){ //basic = 0 Advanced =1
		
		name=n;
		play_mode = p_mode;
		money = 0;
		perfomance_max =0;
		victorypoints = 0;

		discart_pile = CollectionsFactory.createListFactory().createList();
		talents = CollectionsFactory.createMapFactory().createSortedMap();
		perfomance_list = CollectionsFactory.createListFactory().createList();
		reputationList=initializeReputation();
		if (!play_mode){
			reputation = 2;
			higherDiceScore=reputationList.get(2);
		}
		else {
			reputation = 1;
			higherDiceScore= reputationList.get(1);
		}
		city = null;
		weeksToPerformance=1;
	}
	
	public PlayerImpl (String n){
		name = n;
		money =0;
		discart_pile = CollectionsFactory.createListFactory().createList();
		talents = CollectionsFactory.createMapFactory().createMap();
		perfomance_list = CollectionsFactory.createListFactory().createList();
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
	
	public Boolean getPlay_Mode(){
		return play_mode;
	}
	
	public Integer getHigherDiceScore(){
		return higherDiceScore;
	}
	public void addActionCards(List<ActionCard> actioncards){
		action_cards = actioncards; 
	}

	@Override
	public ActionCard discardActionCard(Integer id) {
		ActionCard ac =null;
		for (ActionCard e : action_cards){
			if (e.getIdCard().equals(id)){
				ac= e;
				discart_pile.add(e);
				action_cards.remove(e);
				break;
			}
		}
		return ac;
	}
	
	@Override
	public boolean addActionCard(ActionCard ac) { //metodo para rescatar una carta de la pila.
		boolean res =false;
		if(discart_pile.contains(ac)){
			discart_pile.remove(ac);
			action_cards.add(ac);
			res =true;
		}
		return res;
	}

	@Override
	public boolean addMoney(Integer m) {
		money = money+m;
		return true;
	}

	@Override
	public boolean addPerfomanceUsed(Performance p) {
		return perfomance_list.add(p);
	}

	@Override
	public boolean addPerformance(Integer p) {
		perfomance_max = Math.max(perfomance_max,p);
		return true;
	}

	@Override
	public boolean addReputation(Integer r) {
		Integer newReputation=reputation-r;
		if(newReputation<0 || newReputation>7){
			throw new IllegalArgumentException("Reputation is wrong");
		}
		reputation=newReputation;
		reputation = reputation+r;
		
		return true;
	}

	@Override
	public void addTalent(List<Talent> t) {
		
		for (Talent e :t){
			if (talents.containsKey(e)){
				Integer n = talents.get(e);
				talents.put(e, n+1);
			}
			else{
				talents.put(e, 1);
			}
		}
	}

	@Override
	public boolean addVictoryPoints(Integer vp) {
		victorypoints = victorypoints +vp;
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
		return victorypoints;
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
	public void moveCity(City c) {
		city = c;
	}
	
	public void discardTalent(Talent t){
		if(talents.get(t)<=1){
			talents.remove(t);			
		}else{
			talents.put(t, talents.get(t)-1);
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
