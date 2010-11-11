package card;

import java.util.List;

import player.Player;

public class EventCardImpl extends CardImpl{
	
	// a medio pensar. se dejará para lo último.
	private int points;
	private int moves;
	private int month;
	private int week;
	private List<Player> lp;

	public EventCardImpl(String name, String des) {
		super(name, des);
		
	}
	

}
