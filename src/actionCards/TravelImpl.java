package actionCards;


import java.util.List;

import player.Player;

import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import board.City;
import card.CardImpl;

public class TravelImpl extends CardImpl implements ActionCard {
	private Integer id;
	Player player;
	
	public TravelImpl(Player p) {
		super("Travel", "You can move until 3 cities");
		player=p;
		id =1;
	}

	@Override
	public void execute() {
		List<City> adjCities = CollectionsFactory.createListFactory().createList();
		Integer resp;
		
		System.out.println(player.getName()+" has used ==> TRAVEL <== \n" );
		System.out.println("Select the city below where you want to move:");

		 adjCities = player.getCity().maxMovement(3);

		for (int i=0;i<adjCities.size();i++){
			System.out.println("--> ["+i+"]"+ adjCities.get(i));
		}

		resp= readDataFromKeyBoard.takeParametersToIntegerTopValue("Option:", adjCities.size());
		
		player.moveCity(adjCities.get(resp));
		
	}

	@Override
	public Integer getIdCard() {
		return id;
	}
	
	public String toString() {
		return "[" + id + "]" + super.toString();
	}

}
