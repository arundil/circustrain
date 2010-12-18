package actionCards;

import player.Player;

public class HoldImpl extends ActionCardImpl implements ActionCard {
	private Player player;
	private Integer id;

	public HoldImpl (Player p){
		super("PERMANECER","Puedes Actuar/Contratar en la ciudad actual");
		player = p;
		id = 7;
	}
	@Override
	public void execute() {
		super.performPlayer(player);
	}

	@Override
	public Integer getIdCard() {
		return id;
	}

	public String toString() {
		return "[" + id + "]" + super.toString();
	}
}
