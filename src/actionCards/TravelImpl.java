package actionCards;

import player.Player;

public class TravelImpl extends ActionCardImpl implements ActionCard {
	//borrado player como atributo
	public TravelImpl(Player player) {
		super("VIAJE", "Puedes viajar hasta 3 ciudades",player);
	}

	@Override
	public void execute() {
		super.movePlayer(3);
	}
}
