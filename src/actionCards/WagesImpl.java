package actionCards;


import game.CircusTrainGame;
import player.Player;
import commands.CommandPay;


public class WagesImpl extends ActionCardImpl implements ActionCard {
	CircusTrainGame ctg;
	//borrado player como atributo
	public WagesImpl(CircusTrainGame ctg,Player player) {
		super("SALARIOS", "Puedes moverte hasta 2 ciudades. Después tendrás que " +
				"pagar los salarios o eliminar talentos",player);
		this.ctg = ctg;
	}

	public void execute() {
		//cambiado player por getPlayer()
		System.out.println(getPlayer().getName()+" ha usado la carta ==> SALARIOS <== \n" );
		//Refactorizado...
		super.movePlayer(2);
		
		CommandPay cmp = new CommandPay(getPlayer(), ctg);
		cmp.execute();
		
	}
}
