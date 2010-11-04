package card;

import java.util.List;

import player.PlayerBasic;

public class EventCardImpl extends CardImpl{
	
	// a medio empezar 
	private int points;
	private int moves;
	private int month;
	private int week;
	private List<PlayerBasic> lp;
	

	public EventCardImpl(String name, String des) {
		super(name, des);
		
	}
	

}
