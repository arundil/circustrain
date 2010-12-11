package actionCards;

import game.CommandPerformance;
import game.CommandToHire;
import card.CardImpl;
import performance.BankruptCircus;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;
import utiles.factoria.readDataFromKeyBoard;

public class HoldImpl extends CardImpl implements ActionCard {
	private Player player;
	private Integer id;
	
	public HoldImpl (Player p){
		super("Hold","You can perform/contract");
		player = p;
		id = 8;
	}
	@Override
	public void execute() {
		Integer answer;
		System.out.println(player.getName()+" has used ==> HOLD <== \n" );
		System.out.println("What do you want to do? perform [0] or contract[1]");
		answer = readDataFromKeyBoard.takeParametersToIntegerRestricted("Option:","0,1");
		Performance p = player.getCity().getPerformance();
		if (answer ==0){
			if (p instanceof PerformanceDemand){
				CommandPerformance cp = new CommandPerformance(player,(PerformanceDemand) p);
				cp.execute();
			}
			else{
				System.out.print("This city has no performance\n");
			}
		}
		if (answer ==1){
			if(p instanceof BankruptCircus){
				CommandToHire ch = new CommandToHire((BankruptCircus)p, player);
				ch.execute();
			}
			else{
				System.out.print("This city has no BankruptCircus\n");
			}
		}
	}
	
	@Override
	public Integer getIdCard() {
		return id;
	}
	
	public String toString() {
		return "[" + id + "]" + super.toString();
	}
}
