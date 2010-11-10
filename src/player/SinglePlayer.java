package player;

import java.util.List;
import java.util.Map;
import card.ActionCard;
import game.Talent;
import game.TalentImpl;

public interface SinglePlayer {
	public Integer getMoney();
	public Integer getPerformance();
	public Map<Talent,Integer> getTalents ();
	
	public boolean addTalent(Talent t);
	public boolean addMoney(Integer m);
	public boolean addPerformance(Integer p);
	
	public List<ActionCard> getActionCards();
	public List<ActionCard> discardActionCard(Integer id);
	
}
