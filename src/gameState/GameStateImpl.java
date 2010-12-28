package gameState;

import java.util.List;

import performance.BankruptCircus;
import performance.Performance;
import talent.Talent;
import game.CircusTrainGame;

public abstract class GameStateImpl implements GameState {
	
	protected String month;
	protected CircusTrainGame game;
	
	public GameStateImpl(CircusTrainGame game){
		this.game=game;
	}
	
	@Override
	public GameState incrementTime() {
		GameState stateToReturn=this;
		game.incrementWeek();
		Integer week=game.getWeek();
		completeBoard();
		if (week==4){
			month="MAY";
		}
		if (week==9){
			month="JUNE";
			game.getBoard().removeAllPerformances();
			stateToReturn=new YellowState(game);
		}
		if (week==13){
			month="JULY";
			
		}
		if (week==18){
			month="AUGUST";
			game.getBoard().removeAllPerformances();
			stateToReturn=new RedState(game);
		}
		if (week==22){
			month="SEPTEMBER";
		}
		return stateToReturn;

	}
	
	public String getMonth(){
		return month;
	}
	
	public Performance getPerformanceInList(List<Performance> bag){
		Performance performanceToReturn;
		performanceToReturn = bag.get(1);
		bag.get(1);
		bag.remove(1);
		return performanceToReturn;
	}
	
	public String toString(){
		return this.getClass().getName();
	}
	
	public void completeBoardPerformances(Integer maxNumberOfPerformances){
		while(game.getBoard().countCitiesWithPerfomance()<maxNumberOfPerformances){
			Performance randomPerformance = getPerformance();
			if(randomPerformance instanceof BankruptCircus){
				BankruptCircus bck = (BankruptCircus) randomPerformance;
				for(Talent t: bck.getTalentCircus()){
					if(game.getTalentBag().getNumTalents(t)>0){
						game.getTalentBag().removeTalent(t);
					}else{
						bck.getTalentCircus().remove(t);
					}
				}
				game.getBoard().addPerfomanceInRandomCity(bck);
			}else{
				game.getBoard().addPerfomanceInRandomCity(randomPerformance);
			}	
		}
	}
}
