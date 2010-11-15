package utiles.factoria;

import bag.EventBag;
import bag.PerformanceBag;
import bag.TalentBag;
import board.Board;
import player.Player;

public class GameFactory {
	
	//PARAMETROS: parametros de los distintos constructores. A partir de ahi se
	// podria poner el create con la ruta del archivo. Ejemplo: 
	// Board board=GameFactory.createBoard().create("C:\tablero.txt")
	
	public static Player createPlayer(){
		return new PlayerImpl(PARAMETROS);
	}
	
	public static EventBag createEventBag(){
		return new EventBagImpl(PARAMETROS);
	}
	
	public static PerformanceBag createPerformanceBag(){
		return new PerformanceBagImpl(PARAMETROS);
	}
	
	public static TalentBag createTalentBag(){
		return new TalentBag(PARAMETROS);
	}
	
	public static Board createBoard(){
		return new BoardImpl(PARAMETROS);
	}
	
}
