package player;

import java.util.List;
import java.util.Map;
import java.lang.Math;

import board.City;
import performance.Performance;
import utiles.factoria.CollectionsFactory;
import card.ActionCard;
import card.ActionCardImpl;
import card.TypeTalentCard;


public class PlayerImpl implements Player {
	
	private String name;
	private Integer money,reputation,victorypoints,perfomance_max;
	private Boolean first_player;
	private List<ActionCard> action_cards,discart_pile;
	private List<Performance> perfomance_list;
	private Map<TypeTalentCard,Integer> talents;
	
	public PlayerImpl (String n,Boolean play_mode, Boolean firstp){ //basic = 0 Advanced =1
		
		name=n;
		money = 0;
		perfomance_max =0;
		victorypoints = 0;
		first_player=firstp;
		action_cards= inicializateActionCards();
		discart_pile = CollectionsFactory.createListFactory().createList();
		talents = CollectionsFactory.createMapFactory().createSortedMap();
		perfomance_list = CollectionsFactory.createListFactory().createList();
		if (play_mode == false){
			reputation = -1;
		}
		else {
			reputation = 6;
		}
	}
	
	public PlayerImpl (String n){
		name = n;
		money =0;
		action_cards = inicializateActionCards();
		discart_pile = CollectionsFactory.createListFactory().createList();
		talents = CollectionsFactory.createMapFactory().createMap();
		perfomance_list = CollectionsFactory.createListFactory().createList();
		
	}
	
	//otro constructor para juego solitario.
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean addActionCard(ActionCard ac) {
		return false; // para rellenar las cartas de acción...
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
		reputation = reputation+r;
		return true;
	}

	@Override
	public void addTalent(List<TypeTalentCard> t) {
		
		for (TypeTalentCard e :t){
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ActionCard discardActionCard(Integer id) {
		// TODO Auto-generated method stub
		
		return null;
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
	public Map<TypeTalentCard, Integer> getTalents() {
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
	public void changeFirstPlayer() {
		first_player= !first_player;
	}
	
	@Override
	public City getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean moveCity(City c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void wage() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isFirstPlayer() {
		return first_player;
	}
	
	
	
	//=========================================================================
	//==						Métodos Privados							 ==
	//=========================================================================
	
	
	private List<ActionCard> inicializateActionCards(){
		List<ActionCard> l = CollectionsFactory.createListFactory().createList();
		
		ActionCard ac1 = new ActionCardImpl("Travel","You can move until 3 cities", 1, 3, false, false);
		ActionCard ac2 = new ActionCardImpl("Basic movement","You can move towards 1 city or perform/contract" , 2, 1, true, false);
		ActionCard ac3 = new ActionCardImpl("Basic movement","You can move towards 1 city or perform/contract" , 3, 1, true, false);
		ActionCard ac4 = new ActionCardImpl("Fast movement", "You can move until 5 cities", 4, 5, false, false);
		ActionCard ac5 = new ActionCardImpl("Wages", "You can move until 2 cities. Then, you have to pay the wages or eliminate Talents", 5, 2, false, true);
		ActionCard ac6 = new ActionCardImpl("At Nigth", "You can move toward 2 cities and/or perform/contract", 6, 2, true, false);
		ActionCard ac7 = new ActionCardImpl("No Performance","If you are in Canada (Winnipeg, Montreal or Toronto), " +
				"you can take one clown, one acrobat, or rise your reputation in one level" , 7, 0, false, false);
		ActionCard ac8 = new ActionCardImpl("Hold", "You can perform/actuar", 8, 0, true, false);
		
		l.add(ac1);
		l.add(ac2);
		l.add(ac3);
		l.add(ac4);
		l.add(ac5);
		l.add(ac6);
		l.add(ac7);
		l.add(ac8);
		
		return l;
	}

	
	//private void CleanData_new_Month (){
		
	//}
	
}