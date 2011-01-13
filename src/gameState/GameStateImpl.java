package gameState;

import game.CircusTrainGame;

import java.util.List;

import performance.Performance;

public abstract class GameStateImpl implements GameState {
	
	protected static String month;
	protected CircusTrainGame game;
	protected static Integer week=0;
	
	public GameStateImpl(CircusTrainGame game){
		this.game=game;
	}
	
	@Override
	public GameState incrementTime() {
		GameState stateToReturn=this;
		week++;
		completeBoard();
		if (week==4){
			game.finalMonth();
			month="MAY";
		}
		if (week==9){
			game.finalMonth();
			game.stealTalentSelector();
			month="JUNE";
			game.getBoard().removeAllPerformances();
			stateToReturn=new YellowState(game);
		}
		if (week==13){
			game.finalMonth();
			month="JULY";
			
		}
		if (week==18){
			game.finalMonth();
			game.stealTalentSelector();
			month="AUGUST";
			game.getBoard().removeAllPerformances();
			stateToReturn=new RedState(game);
		}
		if (week==22){
			game.finalMonth();
			game.stealTalentSelector();
			month="SEPTEMBER";
		}
		return stateToReturn;

	}
	
	public String getMonth(){
		return month;
	}
	
	public Performance getPerformanceInList(List<Performance> bag){
		Performance performanceToReturn;
		Integer random=(int)(Math.random()*bag.size()); 
		performanceToReturn = bag.get(random);
		bag.remove(random);
		return performanceToReturn;
	}
	
	@Override
	public String toString(){
		return this.getClass().getName();
	}
	
	public void completeBoardPerformances(Integer maxNumberOfPerformances){
		while(game.getBoard().countCitiesWithPerfomance()<maxNumberOfPerformances){
			Performance randomPerformance = getPerformance();
			randomPerformance.put(game);
		}
	}
	public Integer getWeek(){
		return week;
	}
}
