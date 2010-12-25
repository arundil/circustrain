package gameState;

import game.CircusTrainGame;

public abstract class GameStateImpl implements GameState {
	
	private String month="APRIL";
	private Integer week=0;
	
	public abstract void completePerfomances(CircusTrainGame game);
	
	public GameStateImpl(Integer week,String month){
		this.week=week;
		this.month=month;
	}


	@Override
	public String getMonth() {
		return month;
	}

	@Override
	public Integer getWeek() {
		return week;
	}
	
	protected void setMonth(String month){
		this.month=month;
	}
	
	protected void setWeek(Integer week){
		this.week=week;
	}

	@Override
	public GameState incrementTime() {
		GameState stateToReturn=this;
		week++;
		if (week==4){
			month="MAY";
			
		}
		if (week==9){
			month="JUNE";
			stateToReturn=new OrangeState(week,month);
		}
		if (week==13){
			month="JULY";
			
		}
		if (week==18){
			month="AUGUST";
			stateToReturn=new RedState(week,month);
		}
		if (week==22){
			month="SEPTEMBER";
		}
		return stateToReturn;

	}
}
