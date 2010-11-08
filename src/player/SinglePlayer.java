package player;

import java.util.List;
import java.util.Map;
import card.ActionCard;
import game.TalentImpl;

public interface SinglePlayer {
	public Integer getMoney();
	public Integer getActuation();
	public Map<TalentImpl,Integer> getTalents ();
	
	public boolean addTalent(TalentImpl t);
	public boolean addMoney(Integer m);
	public boolean addActuation(Integer a);
	
	public List<ActionCard> getActionCards();
	public List<ActionCard> discartActionCard(Integer id);
	
}
