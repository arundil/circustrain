package game.factory;

import game.AdvancedSingleGame;
import game.AdvancedTwoPlayersGame;
import game.BasicSingleGame;
import game.CircusTrainGame;
import game.TwoPlayersGame;
import game.TwoPlayersGame;
import game.BasicTwoPlayersGame;

import java.util.List;
import java.util.Random;

import actionCards.ActionCard;
import actionCards.BasicMoveImpl;
import actionCards.FastMoveImpl;
import actionCards.HoldImpl;
import actionCards.OvernighterImpl;
import actionCards.RestImpl;
import actionCards.TravelImpl;
import actionCards.WagesImpl;
import bag.PerformanceBag;
import bag.PerformanceBagImpl;
import bag.TalentBag;
import bag.TalentBagImpl;
import board.Board;
import board.BoardImpl;
import player.Player;
import player.PlayerImpl;
import talent.AcrobatImpl;
import talent.BigCatImpl;
import talent.ClownImpl;
import talent.ElephantImpl;
import talent.FreakShowImpl;
import talent.HorseImpl;
import talent.HumanCannonballImpl;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;

//Para no tener que hacer if( x instanceof w) he hecho que cada juego llame a su propio runGame().
public class GameFactory {
	
	public static Player createPlayer(String name){
		return new PlayerImpl(name);
	}
	
//	public static EventBag createEventBag(){
//		return new EventBagImpl(/*PARAMETROS*/);
//	}
	
	// A LA ESPERA DE UN CONVENIO PARA ESTO.
	
	
	public static PerformanceBag createPerformanceBag(){
		return new PerformanceBagImpl("/data/performancecfg.txt");
	}
	
	public static TalentBag createTalentBag(){
		return new TalentBagImpl();
	}
	
	public static Board createBoard(){
		return new BoardImpl("/data/boardcfg.txt");
	}
	
	public static Integer throwDice(){
		Random random = new Random();
		int tiradaDado = (Math.abs(random.nextInt()) % 6) + 1;
		return new Integer(tiradaDado);
	}
	
	public static Talent createTalent(String talentToCreate){
		talentToCreate=talentToCreate.toUpperCase();
		
		if(talentToCreate.equals("ACROBAT")){
			return new AcrobatImpl();
		}
		if(talentToCreate.equals("CLOWN")){
			return new ClownImpl();
		}
		if(talentToCreate.equals("BIG CAT")){
			return new BigCatImpl();
		}
		if(talentToCreate.equals("ELEPHANT")){
			return new ElephantImpl();
		}
		if(talentToCreate.equals("FREAK SHOW")){
			return new FreakShowImpl();
		}
		if(talentToCreate.equals("HORSE")){
			return new HorseImpl();
		}
		if(talentToCreate.equals("HUMAN CANNON BALL")){
			return new HumanCannonballImpl();
		}
		return null;
	}
	
	public static List<ActionCard> inicializateActionCards(CircusTrainGame ctg, Player player){
		List<ActionCard> ac = CollectionsFactory.createListFactory().createList();
		ac.add(new TravelImpl(player));
		ac.add(new BasicMoveImpl(2, player));
		ac.add(new BasicMoveImpl(3, player));
		ac.add(new FastMoveImpl(player));
		ac.add(new WagesImpl(player,ctg));
		ac.add(new OvernighterImpl(player));
		ac.add(new HoldImpl(player));
		ac.add(new RestImpl(player,ctg));			
		return ac;
	}
	
	public static void createCircusTrainGame(){
		System.out.println("Welcome to Circus Train!");
		
		//Peticion de numero de jugadores
		String askNumberOfPlayers="How many players are going to play: ";
		String askNumberOfPlayersCondition="1,2";
		Integer numberOfPlayers=readDataFromKeyBoard.takeParametersToIntegerRestricted(askNumberOfPlayers,askNumberOfPlayersCondition);

		
		//Seleccion de modo de juego
		String selectGameMode="Select game mode:"+"\n"+"1 : Basic mode"+"\n"+"2 : Advanced mode";
		String selectGameModeCondition="1,2";
		String gameMode=readDataFromKeyBoard.takeParametersToStringRestricted(selectGameMode,selectGameModeCondition);

		
		if(numberOfPlayers==1){
			if(gameMode=="1"){
				BasicSingleGame game=new BasicSingleGame();
				game.runGame();				
			}else if(gameMode=="2"){
				AdvancedSingleGame game=new AdvancedSingleGame();
				game.runGame();
			}
		}else if (numberOfPlayers==2){
			if(gameMode=="1"){
				BasicTwoPlayersGame game=new BasicTwoPlayersGame();
				game.runGame();
			}else if(gameMode=="2"){
				AdvancedTwoPlayersGame game=new AdvancedTwoPlayersGame();
				game.runGame();
			}
		}
	}
}
