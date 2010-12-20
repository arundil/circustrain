package actionCards;

import player.Player;

public class TravelImpl extends ActionCardImpl implements ActionCard {
	private Integer id;
	//borrado player como atributo
	public TravelImpl(Player player) {
		super("VIAJE", "Puedes viajar hasta 3 ciudades",player);
		id =1;
	}

	@Override
	public void execute() {
		super.movePlayer(3);
	}

	@Override
	public Integer getIdCard() {
		return id;
	}
	
	public String toString() {
		return "[" + id + "]" + super.toString();
	}

}
