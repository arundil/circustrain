package actionCards;

import player.Player;

public class HoldImpl extends ActionCardImpl implements ActionCard {
	private Integer id;
	//borrado atributo player

	public HoldImpl (Player player){
		super("PERMANECER","Puedes Actuar/Contratar en la ciudad actual",player);
		id = 7;
	}
	@Override
	public void execute() {
		super.performPlayer();
	}

	@Override
	public Integer getIdCard() {
		return id;
	}

}
