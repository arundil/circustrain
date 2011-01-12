package actionCards;

import gameState.GameState;

import java.util.List;

import performance.Performance;
import player.Player;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import board.City;
import card.CardImpl;

public abstract class ActionCardImpl extends CardImpl implements ActionCard {

	public ActionCardImpl(String name, String description,Player player) {
		super(name,description,player);
	}

	public void movePlayer(Integer move){
		Integer answer;
		List<City> adjCities = CollectionsFactory.createListFactory().createList();

		String mens="Selecciona la ciudad a la que quieres viajar:";
		//cambio de player a getPlayer()
		adjCities=getPlayer().getCity().maxMovement(move);
		for (int i=0;i<adjCities.size();i++){
			System.out.println("--> ["+i+"]"+ adjCities.get(i));
		}
		answer= readDataFromKeyBoard.takeParametersToIntegerTopValue(mens+"\nOpcion:", adjCities.size());
		getPlayer().moveCity(adjCities.get(answer));
	}
	//borrado parametro player
	public void performPlayer(GameState gamestate){
		//cambio de player a getPlayer()
		Performance p = getPlayer().getCity().getPerformance();
		//MUAHAHAHAHAHA vivan los commands!!! borrado todo el tocho
		if(p!=null){
			p.execute(getPlayer(),gamestate);
		}
	}
}