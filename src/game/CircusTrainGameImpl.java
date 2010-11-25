package game;

import game.factory.GameFactory;

import java.util.List;

import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;
import board.BoardImpl;

import player.Player;
import utiles.factoria.CollectionsFactory;

public class CircusTrainGameImpl implements CircusTrainGame{
	
	private List<Player> playerList;
	private static Integer week;
	private static String month;
	private Board board;
	private PerformanceBag performanceBag;
	private TalentBag talentBag;
	
	public CircusTrainGameImpl(){
		playerList=CollectionsFactory.createListFactory().createList();
		board=new BoardImpl();
		performanceBag= GameFactory.createPerformanceBag();
		talentBag = GameFactory.createTalentBag();
	}
	
	public String getMonth(){
		return month;
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runGame() {
		while(week<27){
			refreshMonth();			
			/*
			 * SECUENCIA DEL JUEGO
			 */
			week++;			
		}			
	}

	@Override
	public void startGame() {
		week=0;
		//TODO bucle de peticion de numero de jugadores
		//TODO constructores de los jugadores segun haya
		//TODO iniciacion de bolsas, tablero, y actuaciones
		//TODO opcion de cartas de evento
	}
	private void refreshMonth(){
		if(week>=0 && week<=3)month="APRIL";
		if(week>=4 && week<=8) month="MAY";
		if(week>=9 && week<=12)month = "JUNE";
		if(week>=13 && week<=17)month = "JULY";
		if(week>=18 && week<=21)month = "AUGUST";
		if(week>=22 && week<=26)month = "SEPTEMBER";		
	}
	
}
