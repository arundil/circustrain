package actionCards;

import player.Player;


public class FastMoveImpl extends ActionCardImpl implements ActionCard {
	private Integer id;
	Player player;

	public FastMoveImpl(Player p) {
		super("Fast Move","You can move until 5 cities");
		id = 4;
		player = p;
	}

	@Override
	public void execute() {
		super.movePlayer(player, 5,false);
	}

	@Override
	public Integer getIdCard() {
		return id;
	}
	
	public String toString() {
		return "[" + id + "]" + super.toString();
	}

}
