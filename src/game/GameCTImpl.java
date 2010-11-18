package game;

import game.factory.GameFactory;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

import card.ActionCard;
import performance.BankruptCircus;
import performance.Performance;
import performance.PerformanceDemand;
import performance.VictoryPoints;
import player.Player;
import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;
import board.City;

public class GameCTImpl implements GameCT {
	private Board board;
	private Player one, two;
	private PerformanceBag perfobag;
	private TalentBag talentbag;
	private Boolean basic;
	
	public GameCTImpl (){
//		board = new BoardImpl();)
		one=null;
		two=null;
		perfobag=GameFactory.createPerformanceBag();
		talentbag=GameFactory.createTalentBag();
		
		
	}
	
	public void startGame() {
		//metodos create de los objetos inicializados en el constructor.
		
		//preguntar modo de juego usa el metodo readI(): Integer
		Integer mode=1;
		Integer players=1;
		try {
			System.out.print("Select game mode: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String linea = br.readLine();
			mode = Integer.parseInt(linea);
		} catch (Exception e) {
		}
		
		//crear one y two dependiendo de la eleccion y lo que haga Marc
		try {
			System.out.print("Select number of players: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String linea = br.readLine();
			players = Integer.parseInt(linea);
		} catch (Exception e) {
		}
		board.create();
		if(players==1){
			one=GameFactory.createPlayer();
		}
		if(players==2){
			one=GameFactory.createPlayer();
			two=GameFactory.createPlayer();
		}
		
		
		//modificar basic
	}

	
	public void runGame() {
		Color col = new Color(0);
		addPerformanceBoard(col.GREEN);
		
		for(int week = 1;week<28;week++){
			System.out.println(); //Mostrar el estado de las ciudades
			
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

			if(week < 10){
				addPerformanceBoard(col.GREEN);				
			}
			if(week < 19 && week > 10){
				addPerformanceBoard(col.YELLOW);				
			}
			if(week > 20){
				addPerformanceBoard(col.RED);				
			}
		}
	}
	
	
	public void finishGame() {
	}
	
	
	//---------------------------- X -------------------------------------
	
	//TODO
	private void turnPlayer(Player p){	
		System.out.println(p.getActionCards());
			if(basic){
				System.out.println("Select card for used: ");
				Integer card = readI();
//				ActionCard acard = p.discardActionCard(card);   
				//Hablar con Marc sobre el método.
				ActionCard acard = p.getActionCards().get(card);
				
				usedActionCard(p, acard);
							
			}else{
				System.out.println(p.getdiscartpile());
				System.out.println("Select action: ");
				System.out.println("DuviDuviDuvi");
				Integer x = readI();
			}		
	}
	
	private void finishMounth(Boolean large){
		
	}
	
	
	
	
	//TODO Hablar para el código de las ciudades. 
	private void usedActionCard(Player p, ActionCard ac){
		City city =null;// = p.getCity();
		if(ac.getMove() != 0){
			//Preferiblemente que sea en List para poder sacar por indice la ciudad.
			Set<City> citys = city.maxMovement(ac.getMove());
			
			System.out.println(citys.toString());
			System.out.println("Select city(1--N): ");
			
			Integer cit = readI();
			//Adaptar a la factoria
			//p.moveCity(citys.get(cit-1));
		}
		
		if(ac.isAction()){
			if(city.hasPerfomance()){
				Performance perfor = city.getPerformance();
				if(perfor instanceof VictoryPoints){
					VictoryPoints vp = (VictoryPoints) perfor;
					p.addVictoryPoints(vp.getVictoryPoints());
				}else if(perfor instanceof BankruptCircus){
					BankruptCircus bk = (BankruptCircus) perfor;
//				p.addTalent(bk.getTypeTalentCard());
				}else {
					PerformanceDemand pfd = (PerformanceDemand) perfor;
					p.addPerfomanceUsed(pfd);
				}
			}
		}
		
		if(ac.isWage()){
//			p.wage(basic);
		}
		
	}
	
	//TODO
	private void addPerformanceBoard(Color c) {
		
	}
}
