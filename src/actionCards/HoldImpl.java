package actionCards;

import gameState.GameState;
import player.Player;

public class HoldImpl extends ActionCardImpl implements ActionCard {

	public HoldImpl (Player player){
		super("PERMANECER","Puedes Actuar/Contratar en la ciudad actual",player);
	}
	
	public void execute(GameState gamestate) {
		if(this.getPlayer().getCity().hasPerfomance()){
			super.performPlayer(gamestate);
		}
	}
}
