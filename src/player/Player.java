package player;

import java.util.List;
import java.util.Map;

import performance.Performance;
import card.ActionCard;
import card.TalentCard;

public interface Player {
	//Boolean Es circoFamoso, lo tengo que tener en cuenta para después.
	
	public Integer getMoney();
	public Integer getPerformanceMax();
	public Map<TalentCard,Integer> getTalents ();
	public Integer getReputation();
	public Integer getVictoryPoints();
	
	public boolean addTalent(List<TalentCard> t);
	public boolean addMoney(Integer m);
	public boolean addPerformance(Integer p);
	public boolean addVictoryPoints(Integer vp);
	public boolean addReputation();
	
	public List<Performance> getPerfomancesUsed();
	public List<ActionCard> getActionCards(); 
	public List<ActionCard> getdiscartpile();
	public boolean addActionCard(ActionCard ac);
	public boolean addPerfomanceUsed(Performance p);
	public boolean discardActionCard(Integer id);
	
	public boolean isFirstPlayer();
	
	//private Integer PVCalculate(); [pa dentro de la clase]
	//private List<Talent> addAditionalsTalents(); [pa dentro de la clase] 
	
}
