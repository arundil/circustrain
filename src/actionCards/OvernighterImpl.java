package actionCards;


import java.util.List;

import board.City;
import player.Player;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;

public class OvernighterImpl extends ActionCardImpl implements ActionCard {
	private Player player;
	private Integer id;
	
	public OvernighterImpl(Player p) {
		super("DE NOCHE", "Puedes moverte hasta 2 ciudades y/o actuar/contratar");
		player=p;
		id = 6;
	}

	public void execute() {
		Integer answer = null;
		
		System.out.println(player.getName()+" ha usado la carta ==> DE NOCHE <== \n");
		//Calculo de las ciudades adyacentes con performance
		List<City> adjCities=player.getCity().maxMovement(2);
		List<City> adjCitiesWithPerformance = CollectionsFactory.createListFactory().createList();
		for (City c: adjCities){
			if (c.hasPerfomance()){
				adjCitiesWithPerformance.add(c);
			}
		}
		
		//Casos
		if (player.getCity().hasPerfomance() && adjCitiesWithPerformance.size()>0){
			String question="¿Que quieres hacer?: Viajar[1],Viajar Primero y luego Actuar/Contratar[2] o Actuar/Contratar[3]";
			answer = readDataFromKeyBoard.takeParametersToIntegerRestricted(question+"Opcion:","1,2,3");
		}
		if (player.getCity().hasPerfomance() && adjCitiesWithPerformance.size()==50){
			String restriction = "La ciudad actual tiene performance, pero no hay ciudades con Performance cercanas.";
			String question ="¿Que quieres hacer?: Viajar[1] o Actuar/Contratar[3]";
			answer = readDataFromKeyBoard.takeParametersToIntegerRestricted(restriction+question+"Opcion:","1,3");
		}
		if (!(player.getCity().hasPerfomance()) && adjCitiesWithPerformance.size()>0){
			String restriction ="La ciudad actual no tiene performance.\n";
			String question = "¿Que quieres hacer?: Viajar[1],Viajar Primero y luego Actuar/Contratar[2]\n";
			answer = readDataFromKeyBoard.takeParametersToIntegerRestricted(restriction+question+"Opcion:","1,2");
		}
		if (!(player.getCity().hasPerfomance())&& adjCitiesWithPerformance.size()==0){
			String restriction ="La ciudad actual no tiene performance y tampoco existen ciudades con performance cercanas.\n";
			String question = "¿Que quieres hacer?: Viajar[1]\n";
			answer = readDataFromKeyBoard.takeParametersToIntegerRestricted(restriction+question+"Opcion:","1");
		}
		
		if (answer == 1){
			super.movePlayer(player, 2);
		}
		
		if (answer == 2){
			System.out.println("Estas son las ciudades que poseen Performance.");
			//super.movePlayer(player,2,true);

			for (int i=0; i< adjCitiesWithPerformance.size() ; i++){
				System.out.println("--> ["+i+"]"+ adjCitiesWithPerformance.get(i));
			}
			answer= readDataFromKeyBoard.takeParametersToIntegerTopValue("Opcion:", adjCitiesWithPerformance.size());
			player.moveCity(adjCitiesWithPerformance.get(answer));
		}
		
		if (answer == 2 || answer ==3){
			super.performPlayer(player);
		}
	}
	
	public Integer getIdCard() {
		return id;
	}
	
	public String toString() {
		return "[" + id + "]" + super.toString();
	}
	
	
	

}
