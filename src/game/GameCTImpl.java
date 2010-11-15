package game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import player.Player;
//import player.PlayerImpl;
import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;

public class GameCTImpl implements GameCT {
	private Board board;
	private Player one, two;
	private PerformanceBag perfobag;
	private TalentBag talentbag;
	private Boolean basic;
	
	public GameCTImpl (){
//		board = new BoardImpl();
//		perfobag = new PerformanceBagImpl();
//		talentbag = new TalentBagImpl();
	}
	
	public void startGame() {
		//metodos create de los objetos inicializados en el constructor.
		//preguntar modo de juego
		//crear one y two dependiendo de la eleccion
		//modificar basic
	}

	
	public void runGame() {
		for(int week = 1;week<28;week++){
			if(one.isFirstPlayer()){
				turnPlayer(one);
				turnPlayer(two);
			}else{
				turnPlayer(two);
				turnPlayer(one);
			}
			

			if(week == 4 || week == 13 || week == 27){
				finishMounth(false);
			}

			if(week == 9 ||  week == 18 || week == 23){
				finishMounth(true);
			}
		}
	}
	
	
	public void finishGame() {
	}
	
	
	
	private void turnPlayer(Player p){	
		System.out.println(p.getActionCards());
		try {
			if(basic){
				System.out.print("Select card for used: ");
				BufferedReader card = new BufferedReader(new InputStreamReader(System.in));
				String linea = card.readLine();
				Integer carduse = Integer.parseInt(linea);
				
			
			}else{
				System.out.println(p.getdiscartpile());
			
			}
		} catch (Exception e) {		}
		
		
	}
	
	private void finishMounth(Boolean large){
		
	}

}
