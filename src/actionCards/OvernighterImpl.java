package actionCards;


import gameState.GameState;

import java.util.List;

import player.Player;
import tipos.CollectionsUtils;
import utiles.factoria.readDataFromKeyBoard;
import board.City;
import board.hasPerfomanceFilter;

public class OvernighterImpl extends ActionCardImpl{

	public OvernighterImpl(Player player) {
		super("DE NOCHE", "Puedes moverte hasta 2 ciudades y/o actuar/contratar",player);
	}

	public void execute(GameState gamestate) {
		Integer answer = null;
		//cambiado player por getPlayer()
		System.out.println(getPlayer().getName()+" ha usado la carta ==> DE NOCHE <== \n");
		//Calculo de las ciudades adyacentes con performance
		List<City> adjCities=getPlayer().getCity().maxMovement(2);
		List<City> adjCitiesWithPerformance =CollectionsUtils.filteredList(adjCities, new hasPerfomanceFilter());
		
		//Casos
		if (getPlayer().getCity().hasPerfomance() && adjCitiesWithPerformance.size()>0){
			String question="Que quieres hacer?: Viajar[1],Viajar Primero y luego Actuar/Contratar[2] o Actuar/Contratar[3]";
			answer = readDataFromKeyBoard.takeParametersToIntegerRestricted(question+"Opcion:","1,2,3");
		}
		if (getPlayer().getCity().hasPerfomance() && adjCitiesWithPerformance.size()==0){
			String restriction = "La ciudad actual tiene performance, pero no hay ciudades con Performance cercanas.";
			String question ="Que quieres hacer?: Viajar[1] o Actuar/Contratar[3]";
			answer = readDataFromKeyBoard.takeParametersToIntegerRestricted(restriction+question+"Opcion:","1,3");
		}
		if (!(getPlayer().getCity().hasPerfomance()) && adjCitiesWithPerformance.size()>0){
			String restriction ="La ciudad actual no tiene performance.\n";
			String question = "Que quieres hacer?: Viajar[1],Viajar Primero y luego Actuar/Contratar[2]\n";
			answer = readDataFromKeyBoard.takeParametersToIntegerRestricted(restriction+question+"Opcion:","1,2");
		}
		if (!(getPlayer().getCity().hasPerfomance())&& adjCitiesWithPerformance.size()==0){
			String restriction ="La ciudad actual no tiene performance y tampoco existen ciudades con performance cercanas.\n";
			String question = "Que quieres hacer?: Viajar[1]\n";
			answer = readDataFromKeyBoard.takeParametersToIntegerRestricted(restriction+question+"Opcion:","1");
		}
		
		if (answer == 1){
			//borrado player como parametro
			movePlayer( 2);
		}
		
		if (answer == 2){
			System.out.println("Estas son las ciudades que poseen Performance.");

			for (int i=0; i< adjCitiesWithPerformance.size() ; i++){
				System.out.println("["+i+"] "+ adjCitiesWithPerformance.get(i));
			}
			Integer answerCity= readDataFromKeyBoard.takeParametersToIntegerTopValue("Opcion:", adjCitiesWithPerformance.size());
			getPlayer().moveCity(adjCitiesWithPerformance.get(answerCity));
			
		}
		
		if (answer == 2 || answer ==3){
			//borrado player como parametro
			performPlayer(gamestate);
		}
	}
}
