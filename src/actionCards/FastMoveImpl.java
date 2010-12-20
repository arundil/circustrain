package actionCards;

import player.Player;


public class FastMoveImpl extends ActionCardImpl implements ActionCard {
	private Integer id;

	public FastMoveImpl(Player player) {//borrado atributo player		
		super("MOVIMIENTO RAPIDO","Puedes moverte hasta 5 ciudades",player);
		id = 4;
	}

	@Override
	public void execute() {
		//borrado atributo player
		movePlayer(5);
	}

	@Override
	public Integer getIdCard() {
		return id;
	}
	
	public String toString() {
		return "[" + id + "]" + super.toString();
	}

}
