package actionCards;

import gameState.GameState;
import player.Player;
import utiles.factoria.readDataFromKeyBoard;


public class BasicMoveImpl extends ActionCardImpl implements ActionCard {

//borrado atributo player
	public BasicMoveImpl(Player player) {
		super("MOVIMIENTO BÁSICO", "Puedes moverte hacia una ciudad adyacente o Actuar/Contratar",player);
	}


	public void execute(GameState gamestate) {
		Integer answer;
//sustituido player por getPlayer()
		System.out.println(getPlayer().getName()+" ha usado la carta ==> MOVIMIENTO BÁSICO <== \n");
		
		if (getPlayer().getCity().hasPerfomance()){
			String mens="¿Que quieres hacer, Viajar[1] o Actuar/Contratar[2]";
			answer=readDataFromKeyBoard.takeParametersToIntegerRestricted(mens+"\nOption:","1,2");
		}else{
			System.out.println(getPlayer().getCity()+" no tiene Performance");
			answer=1;
		}
//borrado atributo player
		if (answer ==1){
			super.movePlayer(1);
		}else if(answer==2){ 	
			super.performPlayer(gamestate);
		}
	}
}