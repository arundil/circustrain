package player;

import java.util.List;
import java.util.Map;

import board.City;

import performance.Performance;
import card.ActionCard;
import card.TypeTalentCard;

public interface Player {
	//Boolean Es circoFamoso, lo tengo que tener en cuenta para después.
	
	public Integer getMoney();
	public Integer getPerformanceMax();
	public Map<TypeTalentCard,Integer> getTalents ();
	public Integer getReputation();
	public Integer getVictoryPoints();
	public String getName();
	public City	getCity();
	
	
	public void addTalent(List<TypeTalentCard> t);
	public boolean addMoney(Integer m);
	public boolean addPerformance(Integer p);
	public boolean addVictoryPoints(Integer vp);
	public boolean addReputation(Integer r);
	public boolean moveCity(City c);
	
	public List<Performance> getPerfomancesUsed();
	public List<ActionCard> getActionCards(); 
	public List<ActionCard> getdiscartpile();
	public boolean addActionCard(ActionCard ac);
	public boolean addPerfomanceUsed(Performance p);
	public ActionCard discardActionCard(Integer id);
	
	public void changeFirstPlayer();
	
	public void wage();//-> paga los salarios....
	//
	
	//private Integer PVCalculate(); [pa dentro de la clase]
	//private List<Talent> addAditionalsTalents(); [pa dentro de la clase] 
	
}
