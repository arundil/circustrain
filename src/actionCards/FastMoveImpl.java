package actionCards;

import gameState.GameState;
import player.Player;


public class FastMoveImpl extends ActionCardImpl{

	public FastMoveImpl(Player player) {//borrado atributo player		
		super("MOVIMIENTO RAPIDO","Puedes moverte hasta 5 ciudades",player);
	}

	public void execute(GameState gamestate) {
		//borrado atributo player
		movePlayer(5);
	}
}
