package player;

import java.util.List;
import java.util.Map;

import actionCards.ActionCard;
import board.City;

import performance.Performance;
import talent.Talent;

public interface Player {	
	public Integer getMoney();
	public Integer getPerformanceMax();
	public Map<Talent,Integer> getTalents ();
	public Integer getReputation();
	public Integer getVictoryPoints();
	public String getName();
	public City	getCity();
	public Integer getHigherDiceScore();
	//public Boolean getPlay_Mode();
	
	
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
	public void addActionCards(List<ActionCard> actioncards);
	
	public void playActionCard();
	public void playDiscardActionCards(String month);
	public void collectMoney();
	public void playerState();

	public Integer getWeeksToPerformance();
	public void setWeeksToPerformance(Integer weeks);
	
}
