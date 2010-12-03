package actionCards;

import game.CommandPerformance;
import game.factory.GameFactory;
import card.CardImpl;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;

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
		answer = GameFactory.takeParametersToIntegerRestricted("Option:","0,1");
		if (answer ==0 && player.getCity().hasPerfomance()){
			Performance p = player.getCity().getPerformance();
			CommandPerformance cp = new CommandPerformance(player,(PerformanceDemand) p);
			cp.execute();
		}else{
			System.out.println("there isnt performance");
		}
		if (answer ==1){
			//Contratar
		}

	}
	
	@Override
	public Integer getIdCard() {
		return id;
	}
}
