package commands;

import game.AbstractCommand;

import java.util.List;
import java.util.Set;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;
import talent.Talent;


public class CommandPerformance extends AbstractCommand{
	
	private Player player;
	private PerformanceDemand performance;
	
	public CommandPerformance(Player player, PerformanceDemand performance){
		this.player=player;
		this.performance=performance;
	}
	
	public void execute(){
		Integer weeksToPerformance=player.getWeeksToPerformance();
		
		if(!performance.isTwoWeeks() || weeksToPerformance==0){
			Integer performancePoints=player.getPerformanceMax();
			Integer newPerformancePoints=0;
			Set<Talent> talents=player.getTalents().keySet();
			for(Talent t:talents){
				for(Talent talent:performance.getTalentPoints().keySet()){
					if(t.equals(talent)){
						newPerformancePoints+=performance.getTalentPoints().get(talent);
					}
				}
			}
			newPerformancePoints+=performance.getBasicPoints();
			List<Performance> performancelist=player.getPerfomancesUsed();
			for(Performance performanc:performancelist){
				PerformanceDemand perfordemand=(PerformanceDemand) performanc;
				newPerformancePoints+=perfordemand.getBasicPoints();
			}
			if(performancePoints<newPerformancePoints){
				player.addMoney(10);
				player.addPerformance(newPerformancePoints);
			}
			refresh();
			player.addPerfomanceUsed(performance);		
			
		}else{
			player.setWeeksToPerformance(player.getWeeksToPerformance()-1);
		}
		//Quita la performance que usa en una ciudad.
		player.getCity().removePerformance();
	}
	
	private void refresh(){
		if(performance.getColor().equals("green")){
			player.addMoney(5);
		}else{
			if(performance.getColor().equals("yellow")){
				player.addMoney(10);
			}else{
				player.addMoney(20);
			}				
		}
		if(player.getWeeksToPerformance()==0){
			player.setWeeksToPerformance(1);
		}
	}
}
