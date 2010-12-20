package actionCards;

import java.util.List;

import commands.CommandPerformance;
import commands.CommandToHire;

import performance.BankruptCircus;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;

import board.City;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import card.CardImpl;

public abstract class ActionCardImpl extends CardImpl implements ActionCard {

	public ActionCardImpl(String name, String description,Player player) {
		super(name,description,player);
	}

	public void movePlayer(Integer move){//usamos el jugador usado como parametro en el constructor
		Integer answer;
		List<City> adjCities = CollectionsFactory.createListFactory().createList();

		System.out.println("Selecciona la ciudad a la que quieres viajar:");
		//cambio de player a getPlayer()
		adjCities=getPlayer().getCity().maxMovement(move);
		for (int i=0;i<adjCities.size();i++){
			System.out.println("--> ["+i+"]"+ adjCities.get(i));
		}
		answer= readDataFromKeyBoard.takeParametersToIntegerTopValue("Option:", adjCities.size());
		getPlayer().moveCity(adjCities.get(answer));
	}
	//borrado parametro player
	public void performPlayer(){
		//cambio de player a getPlayer()
		Performance p = getPlayer().getCity().getPerformance();
		if (p instanceof PerformanceDemand){
			System.out.println("La ciudad de "+getPlayer().getCity()+" agradece tu actuación de : "+ p );
			if (p instanceof PerformanceDemand){
				CommandPerformance cp = new CommandPerformance(getPlayer(),(PerformanceDemand) p);
				cp.execute();
			}
		}else if (p instanceof BankruptCircus){
			System.out.println("Por la calles de esta ciudad deambula un Circo en Bancarrota: "+ p + "\n");
			if(p instanceof BankruptCircus){
				CommandToHire ch = new CommandToHire((BankruptCircus)p, getPlayer());
				ch.execute();
			} else {
				throw new IllegalArgumentException("No puedes instanciar otra cosa que no sea Performance or BankruptCircus");
			}

		}
	}
}