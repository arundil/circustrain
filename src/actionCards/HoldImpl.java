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
		Integer resp;
		System.out.println("What do you want to do? perform [0] or contract[1]");
		resp = GameFactory.takeParametersToIntegerRestricted("Option:","0,1");
		if (resp ==0){
			Performance p = player.getCity().getPerformance();
			CommandPerformance cp = new CommandPerformance(player,(PerformanceDemand) p);
			cp.execute();
		}
		if (resp ==1){
			//Contratar
		}

	}
	
	@Override
	public Integer getIdCard() {
		return id;
	}
}
