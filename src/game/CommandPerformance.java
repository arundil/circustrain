package game;

import counter.PerformanceCounter;
import player.Player;

public class CommandPerformance extends AbstractCommand{
	
	private Player player;
	private PerformanceCounter performance;
	
	public CommandPerformance(Player player, PerformanceCounter performance){
		this.player=player;
		this.performance=performance;
	}
	
	public void execute(){
		Integer performancePoints=player.getPerformanceMax();
		Integer newPerformancePoints
	}

}
