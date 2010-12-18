package actionCards;

import commands.CommandPerformance;
import commands.CommandToHire;

import card.CardImpl;
import performance.BankruptCircus;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;
import utiles.factoria.readDataFromKeyBoard;

public class HoldImpl extends ActionCardImpl implements ActionCard {
	private Player player;
	private Integer id;

	public HoldImpl (Player p){
		super("Hold","You can perform/contract");
		player = p;
		id = 7;
	}
	@Override
	public void execute() {
		super.performPlayer(player);
	}

	@Override
	public Integer getIdCard() {
		return id;
	}

	public String toString() {
		return "[" + id + "]" + super.toString();
	}
}
