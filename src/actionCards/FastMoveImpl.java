package actionCards;

import player.Player;


public class FastMoveImpl extends ActionCardImpl implements ActionCard {

	public FastMoveImpl(Player player) {//borrado atributo player		
		super("MOVIMIENTO RAPIDO","Puedes moverte hasta 5 ciudades",player);
	}

	@Override
	public void execute() {
		//borrado atributo player
		movePlayer(5);
	}
}
