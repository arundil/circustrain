package actionCards;


import game.TwoPlayersGame;

import java.util.List;

import commands.CommandPay;

import board.City;
import player.Player;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import card.CardImpl;

public class WagesImpl extends CardImpl implements ActionCard {
	Integer id;
	Player player;
	TwoPlayersGame ctg;
	
	public WagesImpl(Player player, TwoPlayersGame ctg) {
		super("SALARIOS", "Puedes moverte hasta 2 ciudades. Después tendrás que " +
				"pagar los salarios o eliminar talentos");
		this.id = 5;
		this.player = player;
		this.ctg = ctg;
	}

	public void execute() {

		System.out.println(player.getName()+" ha usado la carta ==> SALARIOS <== \n" );

		List<City> adjCities = CollectionsFactory.createListFactory().createList();
		City city = player.getCity();
		String mess = "Select the city below where you want to move: \n";
		String cond="";
		String resp="";
		Integer respuesta =0;
		adjCities = city.maxMovement(2);

		for(int i=1; i <= adjCities.size(); i++){
			mess = mess + i + ": " + adjCities.get(i-1).toString() + "\n";
			cond = cond + i+",";
		}
		resp = readDataFromKeyBoard.takeParametersToStringRestricted(mess, cond);
		respuesta = new Integer(resp);
		player.moveCity(adjCities.get(respuesta-1));

		CommandPay cmp = new CommandPay(player, ctg);
		cmp.execute();
		
	}

	public Integer getIdCard() {
		return id;
	}

		public String toString() {
		return "[" + id + "]" + super.toString();
	}

}
