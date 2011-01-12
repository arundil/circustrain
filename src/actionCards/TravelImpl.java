package actionCards;

import gameState.GameState;
import player.Player;

public class TravelImpl extends ActionCardImpl implements ActionCard {
	//borrado player como atributo
	public TravelImpl(Player player) {
		super("VIAJE", "Puedes viajar hasta 3 ciudades",player);
	}

	public void execute(GameState gamestate) {
		super.movePlayer(3);
	}
}
