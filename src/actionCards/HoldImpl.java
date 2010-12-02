package actionCards;

import card.CardImpl;
import player.Player;

public class HoldImpl extends CardImpl implements ActionCard {
	private Player player;
	private Integer id;
	
	public HoldImpl (Player p){
		super("Hold","You can perform/contract");
		player = p;
		id = 8;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer getIdCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
