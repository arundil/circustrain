package performance;


import game.CircusTrainGame;
import gameState.GameState;

import java.util.List;
import java.util.Map;
import java.util.Set;

import player.Player;
import talent.Talent;


public class PerformanceDemandImpl extends performanceImpl implements PerformanceDemand{
		public PerformanceDemandImpl(String cardColor, String description,
			Integer basicPoints,
			Map<Talent, Integer> talentPoints, boolean twoWeeks) {
		super(cardColor, description);
		this.basicPoints = basicPoints;
		this.talentPoints = talentPoints;
		this.twoWeeks = twoWeeks;
	}

	private Integer basicPoints;
	private Map<Talent, Integer> talentPoints;
	private boolean twoWeeks;
	@Override
	public Integer getBasicPoints() {
		return basicPoints;
	}

	@Override
	public Map<Talent, Integer> getTalentPoints() {
		return talentPoints;
	}

	@Override
	public Boolean isTwoWeeks() {
		return twoWeeks;
	}
	
	@Override
	public String toString(){
		String stringToReturn=super.toString();
		if(this.isTwoWeeks()){
			stringToReturn=stringToReturn+" (DOS SEMANAS) ";
		}
		stringToReturn=stringToReturn+" "+this.getBasicPoints()+"+(";
		
		for(Talent t:this.getTalentPoints().keySet()){
			stringToReturn=stringToReturn+" "+t.toString()+":"+this.getTalentPoints().get(t);
		}
		stringToReturn=stringToReturn+")";
		return stringToReturn;
	}
	
	
	public void execute(Player player,GameState gamestate) {
		Integer weeksToPerformance=player.getWeeksToPerformance();
		
		if(!isTwoWeeks() || weeksToPerformance==0){
			Integer performancePoints=player.getPerformanceMax();
			Integer newPerformancePoints=0;
			Set<Talent> talents=player.getTalents().keySet();
			for(Talent t:talents){
				for(Talent talent:getTalentPoints().keySet()){
					if(t.equals(talent)){
						newPerformancePoints+=getTalentPoints().get(talent);
					}
				}
			}
			newPerformancePoints+=getBasicPoints();
			List<Performance> performancelist=player.getPerfomancesUsed();
			for(Performance performanc:performancelist){
				PerformanceDemand perfordemand=(PerformanceDemand) performanc;
				newPerformancePoints+=perfordemand.getBasicPoints();
			}
			if(performancePoints<newPerformancePoints){
				if(gamestate.getGame().getPlayerList().size()>1){
					player.addMoney(10);
					player.addPerformance(newPerformancePoints);
				}				
			}
			gamestate.addMoney(player);
			
			player.setWeeksToPerformance(1);
			
			player.addPerfomanceUsed(this);		
			//Quita la performance que usa en una ciudad.
			player.getCity().removePerformance();	
			
		}else{
			player.setWeeksToPerformance(player.getWeeksToPerformance()-1);
		}
			
	}
	
	public void land(Player p){
		
	}
	public void put(CircusTrainGame game){
		game.getBoard().addPerfomanceInRandomCity(this);
	}
}
