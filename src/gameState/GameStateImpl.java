package gameState;

import game.CircusTrainGame;

import java.util.List;

import performance.Performance;

public abstract class GameStateImpl implements GameState {
	
	protected static String month;
	protected CircusTrainGame game;
	protected static Integer week=0;
	protected static Integer humanWeek=1;
	
	public GameStateImpl(CircusTrainGame game){
		this.game=game;
	}
	
	@Override
	public GameState incrementTime() {
		GameState stateToReturn=this;
		week++;
		humanWeek++;
		completeBoard();
		if(week==1){
			game.addRestActionCard();
		}
		if (week==4){
			humanWeek=1;
			game.finalMonth();
			month="MAYO";
		}
		if (week==9){
			humanWeek=1;
			game.finalMonth();
			game.stealTalentSelector();
			month="JUNIO";
			game.getBoard().removeAllPerformances();
			stateToReturn=new YellowState(game);
		}
		if (week==13){
			humanWeek=1;
			game.finalMonth();
			month="JULIO";
			
		}
		if (week==18){
			humanWeek=1;
			game.finalMonth();
			game.stealTalentSelector();
			month="AGOSTO";
			game.getBoard().removeAllPerformances();
			stateToReturn=new RedState(game);
		}
		if (week==22){
			humanWeek=1;
			game.finalMonth();
			game.stealTalentSelector();
			month="SETPTIEMBRE";
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
	
	public Integer getHumanWeek(){
		return humanWeek;
	}
	
	public CircusTrainGame getGame(){
		return game;
	}
}
