package player;

import java.util.Map;

import game.Talent;

public interface SinglePlayer {
	public Integer getMoney();
	public Integer getActuation();
	public Map<Talent,Integer> getTalents ();
	
	public boolean addTalent(Talent t);
	public boolean addMoney(Integer m);
	public boolean addActuation(Integer a);
	

	
}
