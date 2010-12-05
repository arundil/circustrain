package player;

import java.util.List;
import java.util.Map;

import actionCards.ActionCard;
import board.City;

import performance.Performance;
import talent.Talent;

public interface Player {
	//Boolean Es circoFamoso, lo tengo que tener en cuenta para después.
	
	public Integer getMoney();
	public Integer getPerformanceMax();
	public Map<Talent,Integer> getTalents ();
	public Integer getReputation();
	public Integer getVictoryPoints();
	public String getName();
	public City	getCity();
	public Integer getHigherDiceScore();
	
	
	public void addTalent(List<Talent> t);
	public boolean addMoney(Integer m);
	public boolean addPerformance(Integer p);
	public boolean addVictoryPoints(Integer vp);
	public boolean addReputation(Integer r);
	public void moveCity(City c);
	
	public List<Performance> getPerfomancesUsed();
	public List<ActionCard> getActionCards(); 
	public List<ActionCard> getdiscartpile();
	public boolean addActionCard(ActionCard ac);
	public boolean addPerfomanceUsed(Performance p);
	public ActionCard discardActionCard(Integer id);
	public void discardTalent(Talent t);
	public boolean isFirstPlayer();
	
	public void changeFirstPlayer();
	
	public Integer wage();//-> paga los salarios....
	public boolean wage(Talent ttc);
	
	public Integer getWeeksToPerformance();
	public void setWeeksToPerformance(Integer weeks);
	
	//22 métodos
	
	//private Integer PVCalculate(); [pa dentro de la clase]
	//private List<Talent> addAditionalsTalents(); [pa dentro de la clase] 
	
}
