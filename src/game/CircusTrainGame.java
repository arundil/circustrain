package game;

import game.factory.GameFactory;

import java.util.List;
import java.util.Map;

import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;
import performance.Performance;
import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;

public abstract class CircusTrainGame{
	protected static String month;
	protected static Integer week;
	protected Board board;
	protected PerformanceBag performanceBag;
	protected String followingAction;
	protected List<Talent> theClown=CollectionsFactory.createListFactory().createList();
	protected Talent clown = GameFactory.createTalent("CLOWN");
	protected TalentBag talentBag;
	protected List<Player> playerList;
	
	public CircusTrainGame(){
		playerList=CollectionsFactory.createListFactory().createList();
		board=GameFactory.createBoard();
		performanceBag= GameFactory.createPerformanceBag();
		talentBag = GameFactory.createTalentBag();
		theClown.add(clown);
	}	
	
	public void refreshMonth(){
			if(week>=0 && week<=3)month = "APRIL";
			if(week>=4 && week<=8) month = "MAY";
			if(week>=9 && week<=12)month = "JUNE";
			if(week>=13 && week<=17)month = "JULY";
			if(week>=18 && week<=21)month = "AUGUST";
			if(week>=22 && week<=26)month = "SEPTEMBER";	
		
	}
	
	public void completeBoardPerformances(){
		if(month.equals("APRIL") || month.equals("MAY")){
			while(board.getCitiesWithPerfomance().size()<8){
				Performance randomPerformance = performanceBag.getPerformance("green");
				board.addPerfomanceInRandomCity(randomPerformance);
				performanceBag.removePerformance(randomPerformance);
			}
		}
		if(month.equals("JUNE") || month.equals("JULY")){
			while(board.getCitiesWithPerfomance().size()<10){
				Performance randomPerformance=performanceBag.getPerformance("yellow");
				board.addPerfomanceInRandomCity(randomPerformance);
				performanceBag.removePerformance(randomPerformance);
			}
		}
		if(month.equals("AUGUST") || month.equals("SEPTEMBER")){
			while(board.getCitiesWithPerfomance().size()<12){
				Performance randomPerformance=performanceBag.getPerformance("red");
				board.addPerfomanceInRandomCity(randomPerformance);
				performanceBag.removePerformance(randomPerformance);
			}
		}
	}
	
	protected abstract void gameOver();
	protected abstract void wageCardNoDiscarded();
	protected abstract void results();
	
	public abstract void noClownsNoAnimals();
	
	public Board getBoard(){
		return board;
	}
	
	public String getFollowingAction(){
		return followingAction;
	}
}