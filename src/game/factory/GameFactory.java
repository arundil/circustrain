package game.factory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.Set;

import bag.EventBag;
import bag.PerformanceBag;
import bag.PerformanceBagImpl;
import bag.TalentBag;
import bag.TalentBagImpl;
import board.Board;
import board.BoardImpl;
import player.Player;
import player.PlayerImpl;
import talent.BigCatImpl;
import talent.ClownImpl;
import talent.ElephantImpl;
import talent.FreakShowImpl;
import talent.HorseImpl;
import talent.HumanCannonballImpl;
import talent.Talent;
import tipos.Cadenas;
import utiles.factoria.CollectionsFactory;

public class GameFactory {
	
	//PARAMETROS: parametros de los distintos constructores. A partir de ahi se
	// podria poner el create con la ruta del archivo. Ejemplo: 
	// Board board=GameFactory.createBoard().create("C:\tablero.txt")
	
	public static Player createPlayer(String name,Boolean play_mode, Boolean firstp){
		return new PlayerImpl(name,play_mode,firstp);
	}
	
//	public static EventBag createEventBag(){
//		return new EventBagImpl(/*PARAMETROS*/);
//	}
	
	// A LA ESPERA DE UN CONVENIO PARA ESTO.
	
	
	public static PerformanceBag createPerformanceBag(){
		return new PerformanceBagImpl();
	}
	
	public static TalentBag createTalentBag(){
		return new TalentBagImpl();
		/*
		 * NOTA DE FRANCIS:
		 * el constructor TalentBagImpl no existía como tal, había creado un método llamado
		 * createInitialTalentBag(). Lo he modificado de nombre para que pudiera llamarse
		 * como está aquí.
		 */
	}
	
	public static Board createBoard(){
		return new BoardImpl("/data/boardcfg.txt");
	}
	
	public static String takeParametersToString(String message){
		String line=null;
		try {
			System.out.print(message.toString());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (Exception e) {
		}
		return line;
	}
	
	public static Integer takeParametersToInteger(String message){
		Integer number=-1;
		try {
			System.out.print(message.toString());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String linea = br.readLine();
			number = Integer.parseInt(linea);
		} catch (Exception e) {
		}
		return number;
	}
	
	public static Integer throwDice(){
		Random random = new Random();
		int tiradaDado = (Math.abs(random.nextInt()) % 6) + 1;
		return new Integer(tiradaDado);
	}
	
	public static String takeParametersToStringRestricted(String message,String condition){
		List<String> conditions=Cadenas.separaElementos(condition,",");
		String line="";
		while(!conditions.contains(line)){
			line= GameFactory.takeParametersToString(message);
		}
		return line;		
	}
	
	public static Integer takeParametersToIntegerRestricted(String message, String condition){
		Integer number = -1;
		List<String> conditions=Cadenas.separaElementos(condition,",");
		while(!conditions.contains(number.toString())){
			number= takeParametersToInteger(message);
		}
		return number;		
	}
	public static Integer takeParametersToIntegerTopValue(String message, Integer top){
		Integer number = -1;
		while(!(number >= 0 && number <= top)){
			number= takeParametersToInteger(message);
		}
		return number;		
	}
	
	public static Talent createTalent(String talentToCreate){
		talentToCreate=talentToCreate.toUpperCase();
		
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
}
