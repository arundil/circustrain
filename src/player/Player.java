package player;

import java.util.List;
import java.util.Map;
import card.ActionCard;
import game.Talent;

public interface Player {
	
	public Integer getMoney();
	public Integer getPerformance();
	public Map<Talent,Integer> getTalents ();
	
	public boolean addTalent(Talent t);
	public boolean addMoney(Integer m);
	public boolean addPerformance(Integer p);
	
	public List<ActionCard> getActionCards();
	public List<ActionCard> discardActionCard(Integer id);
	
	public Integer getReputation();
	public boolean addReputation();
	public Integer getVictoryPoints();
	
	public boolean addVictoryPoints(Integer vp);
	public boolean isFirstPlayer();
	
}
