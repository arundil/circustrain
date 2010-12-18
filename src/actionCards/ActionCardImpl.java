package actionCards;

import java.util.List;

import player.Player;

import board.City;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import card.CardImpl;

public abstract class ActionCardImpl extends CardImpl implements ActionCard {

	public ActionCardImpl(String name, String des) {
		super(name, des);
	}
	
	public void movePlayer(Player player){
		Integer answer;
		List<City> adjCities = CollectionsFactory.createListFactory().createList();

		System.out.println("Select the city below where you want to move:");
		adjCities=player.getCity().maxMovement(1);

		for (int i=0;i<adjCities.size();i++){
			System.out.println("--> ["+i+"]"+ adjCities.get(i));
		}

		answer= readDataFromKeyBoard.takeParametersToIntegerTopValue("Option:", adjCities.size());
		
		player.moveCity(adjCities.get(answer));
	}
}