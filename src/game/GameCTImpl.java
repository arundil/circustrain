package game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

import card.ActionCard;
import card.TypeTalentCard;

import performance.Bankrupt;
import performance.Performance;
import performance.PerformanceDemand;
import performance.VictoryPoints;
import player.Player;
//import player.PlayerImpl;
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
	
	
	//---------------------------- X -------------------------------------
	
	//TODO
	private void turnPlayer(Player p){	
		System.out.println(p.getActionCards());
			if(basic){
				System.out.print("Select card for used: ");
				Integer card = readI();
//				ActionCard acard = p.discardActionCard(card);   
				//Hablar con Marc sobre el método.
				ActionCard acard = p.getActionCards().get(card);
				usedActionCard(p, acard);
				
			
			}else{
				System.out.println(p.getdiscartpile());
			
			}		
	}
	
	private void finishMounth(Boolean large){
		
	}
	
	
	
	private Integer readI(){
		Integer x = 0;
		try{
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			String linea = read.readLine();
			x = Integer.parseInt(linea);
		}catch (Exception e) {		}
		return x;
	}
	
	//TODO Hablar para el código de las ciudades. 
	private void usedActionCard(Player p, ActionCard ac){
		City city =null;// = p.getCity();
		if(ac.getMove() != 0){
			//Preferiblemente que sea en List para poder sacar por indice la ciudad.
			Set<City> citys = city.maxMovement(ac.getMove());
			System.out.print("Select city: ");
			Integer cit = readI();
			//p.moveCity(citys.get(cit));
		}
		
		if(ac.isAction()){
			if(city.hasPerfomance()){
				Performance perfor = city.getPerformance();
				if(perfor instanceof VictoryPoints){
					VictoryPoints vp = (VictoryPoints) perfor;
					p.addVictoryPoints(vp.getVictoryPoints());
				}else if(perfor instanceof Bankrupt){
					Bankrupt bk = (Bankrupt) perfor;
//				p.addTalent(bk.getTypeTalentCard());
				}else {
					PerformanceDemand pfd = (PerformanceDemand) perfor;
					p.addPerfomanceUsed(pfd);
				}
			}
		}
		
		if(ac.isWage()){
//			p.wage();
		}
		
	}
}
