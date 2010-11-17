package player;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
	private City city;
	
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
		city = null;
	}
	
	public PlayerImpl (String n){
		name = n;
		money =0;
		action_cards = inicializateActionCards();
		discart_pile = CollectionsFactory.createListFactory().createList();
		talents = CollectionsFactory.createMapFactory().createMap();
		perfomance_list = CollectionsFactory.createListFactory().createList();
		city = null;
	}
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean addActionCard(ActionCard ac) { //metodo para rescatar una carta de la pila.
		//TODO en proyecto de decisión si se coge el ID o la carta
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
		return city;
	}

	@Override
	public void moveCity(City c) {
		city = c;
	}
	
	@Override
	public Integer wage() {
		Integer wages=0;
		Set<TypeTalentCard> s = talents.keySet();
		for (TypeTalentCard t : s){
			Integer n= talents.get(t);
			wages=wages+(t.getWage()*n);				
			}
		return wages;
	}
	
	public boolean wage (TypeTalentCard ttc){
		//TODO a petición de javi
		return false;
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
		// (nombre,descripcion,idCarta,numeroMovimientos,esCartaAccion,esCartaSalario)
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
	
	private Integer calculate_VP() {
		Integer res =0;

		return res;
	}

	
	//private void CleanData_new_Month (){
		
	//}
	
}
