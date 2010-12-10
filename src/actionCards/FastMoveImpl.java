package actionCards;

import java.util.List;

import board.City;
import player.Player;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import card.CardImpl;

public class FastMoveImpl extends CardImpl implements ActionCard {
	private Integer id;
	Player player;

	public FastMoveImpl(Player p) {
		super("Fast Move","You can move until 5 cities");
		id = 4;
		player = p;
	}

	@Override
	public void execute() {
		List<City> adjCities = CollectionsFactory.createListFactory().createList();
		Integer answer;
		
		System.out.println(player.getName()+" has used ==> FAST MOVE <== ");
		System.out.println("Select the city below where you want to move:");

		 adjCities = player.getCity().maxMovement(5);

		for (int i=0;i<adjCities.size();i++){
			System.out.println("--> ["+i+"]"+ adjCities.get(i));
		}

		answer= readDataFromKeyBoard.takeParametersToIntegerTopValue("Option:", adjCities.size());
		
		player.moveCity(adjCities.get(answer));
	}

	@Override
	public Integer getIdCard() {
		return id;
	}

}
