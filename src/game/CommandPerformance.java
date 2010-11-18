package game;

import java.awt.Color;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import card.TypeTalentCard;
import counter.PerformanceCounter;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;

public class CommandPerformance extends AbstractCommand{
	
	private Player player;
	private PerformanceDemand performance;
	
	public CommandPerformance(Player player, PerformanceDemand performance){
		this.player=player;
		this.performance=performance;
	}
	
	public void execute(){
		Integer performancePoints=player.getPerformanceMax();
		Integer newPerformancePoints=0;
		Set<TypeTalentCard> talents=player.getTalents().keySet();
		Set<Entry<TypeTalentCard,Integer>> performanceTalents=
			performance.getTalentPoints().entrySet();
		
		for(TypeTalentCard t:talents){
			for(Entry<TypeTalentCard,Integer> entry:performanceTalents){
				if(t.equals(entry.getKey())){
					newPerformancePoints+=entry.getValue();
				}
		}
		newPerformancePoints+=performance.getBasicPoints();
		List<PerformanceDemand> performancelist=player.getPerfomancesUsed();
		for(PerformanceDemand performanc:performancelist){
			newPerformancePoints+=performanc.getBasicPoints();
		}
		if(performancePoints<newPerformancePoints){
			player.addMoney(10);
			player.setPerformanceMax(newPerformancePoints);
		}
		refresh();
		player.addPerfomanceUsed(performance);		
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
	}
}
