package actionCards;


import player.Player;

public class TravelImpl extends ActionCardImpl implements ActionCard {
	private Integer id;
	Player player;
	
	public TravelImpl(Player p) {
		super("VIAJE", "Puedes viajar hasta 3 ciudades");
		player=p;
		id =1;
	}

	@Override
	public void execute() {
		super.movePlayer(player, 3);
	}

	@Override
	public Integer getIdCard() {
		return id;
	}
	
	public String toString() {
		return "[" + id + "]" + super.toString();
	}

}
