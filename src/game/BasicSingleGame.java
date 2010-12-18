package game;

import commands.CommandExecuteCase;
import commands.CommandPlayerState;
import player.Player;
import utiles.factoria.readDataFromKeyBoard;

//Mandamos al padre el constructor
//Creado el metodo selectCase();
public class BasicSingleGame extends OnePlayerGame {
	
	public BasicSingleGame(){
		super();
		//Quitar la carta rest en basico
		player.discardActionCard(8);
		player.getdiscartpile().clear();
	}

	public void runGame(){

		System.out.println("\n \n Ciudades con actuaciones: "+ board.getCitiesWithPerfomance() +"\n \n");

		playerList.get(0).moveCity(selectCanadianCity());

		while(week<27){
			String oldMonth=this.getMonth();
			refreshMonth();
			String newMonth=this.getMonth();
			//Si hay cambio de mes se llevaran a cabo las acciones de fin de mes
			if(!(oldMonth.equals(newMonth))){
				finalMonth();
				rotatePlayers();
			}
			//Mostrar ciudades con eventos
			System.out.println(board.getCitiesWithPerfomance().toString());
			System.out.println("\n \n This is the Week " + week + " and Mounth " + month);

			for(Player currentPlayer : playerList){
				//Se muestra el estado del jugador
				System.out.println("\n \n Its you turn, " + currentPlayer.getName());
				CommandPlayerState playerState = new CommandPlayerState(currentPlayer);				
				playerState.execute();

				//Se le pregunta al jugador que va a hacer segun sus condiciones actuales
				selectCase(player);

				//Se lleva a cabo la accion que el jugador a elegido
				CommandExecuteCase executeCase=new CommandExecuteCase(currentPlayer, this);
				executeCase.execute();				
			}
			//Se mira el número de ciudades y se añaden si es el caso
			completeBoardPerformances();					
			week++;			
		}
	}
	
	void selectCase(Player p){
		String action1="1 : Play one Action card from my hand";
		String askBasicAction = "What are you going to do:" + "\n" + action1;
		String askBasicActionCondition = "1";
		String action="1";
		action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, askBasicActionCondition);
		this.setFollowingAction(action);
	}
}
