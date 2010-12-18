package actionCards;

import commands.CommandPerformance;
import commands.CommandToHire;

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
		id = 7;
	}
	@Override
	public void execute() {
		Integer answer;
		Performance p = player.getCity().getPerformance();
		if (p instanceof PerformanceDemand){
			System.out.println("This City has this PerformanceDemand : "+ p +" .You perform at "+player.getCity());
			answer = 0;
		}else if (p instanceof BankruptCircus){
			System.out.println("In this City there is this BankruptCircus: "+ p + "\n");
			answer =1;
		} else {
			throw new IllegalArgumentException("No puedes instanciar otra cosa que no sea Performance or BankruptCircus");
		}
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
