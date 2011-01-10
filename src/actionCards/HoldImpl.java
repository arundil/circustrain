package actionCards;

import player.Player;

public class HoldImpl extends ActionCardImpl implements ActionCard {

	public HoldImpl (Player player){
		super("PERMANECER","Puedes Actuar/Contratar en la ciudad actual",player);
	}
	@Override
	public void execute() {
		if(this.getPlayer().getCity().hasPerfomance()){
			super.performPlayer();
		}
	}
}
