package player;

import java.util.List;
import java.util.Map;
import card.ActionCard;
import game.Talent;

public interface SinglePlayer {
	public Integer getMoney();
	public Integer getActuation();
	public Map<Talent,Integer> getTalents ();
	
	public boolean addTalent(Talent t);
	public boolean addMoney(Integer m);
	public boolean addActuation(Integer a);
	
	public List<ActionCard> getActionCards();
	public List<ActionCard> discartActionCard(Integer id);
	
}
