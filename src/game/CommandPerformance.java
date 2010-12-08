package game;

import java.awt.Color;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
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
			Set<Entry<Talent,Integer>> performanceTalents=performance.getTalentPoints().entrySet();
			
			for(Talent t:talents){
				for(Entry<Talent,Integer> entry:performanceTalents){
					if(t.equals(entry.getKey())){
						newPerformancePoints+=entry.getValue();
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
	}
	
	private void refresh(){
		if(performance.getColor().equals(Color.GREEN)){
			player.addMoney(5);
		}else{
			if(performance.getColor().equals(Color.YELLOW)){
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
