package actionCards;

import player.Player;
import card.CardImpl;

public class OvernighterImpl extends CardImpl implements ActionCard {
	private Player player;
	private Integer id;
	
	public OvernighterImpl(Player p) {
		super("OvernighterImpl", "You can move toward 2 cities and/or perform/contract");
		player=p;
		id = 6;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}

	@Override
	public Integer getIdCard() {
		return id;
	}

}
