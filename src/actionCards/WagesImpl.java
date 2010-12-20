package actionCards;


import game.CircusTrainGame;
import java.util.List;

import player.Player;
import commands.CommandPay;
import board.City;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import card.CardImpl;

public class WagesImpl extends CardImpl implements ActionCard {
	Integer id;
	CircusTrainGame ctg;
	//borrado player como atributo
	public WagesImpl(CircusTrainGame ctg,Player player) {
		super("SALARIOS", "Puedes moverte hasta 2 ciudades. Después tendrás que " +
				"pagar los salarios o eliminar talentos",player);
		this.id = 5;
		this.ctg = ctg;
	}

	public void execute() {
		//cambiado player por getPlayer()
		System.out.println(getPlayer().getName()+" ha usado la carta ==> SALARIOS <== \n" );

		List<City> adjCities = CollectionsFactory.createListFactory().createList();
		City city = getPlayer().getCity();
		String askCityToMove = "Selecciona la ciudad a la que vas a viajar: \n";
		String condition="";
		String answer="";
		Integer respuesta =0;
		adjCities = city.maxMovement(2);

		for(int i=1; i <= adjCities.size(); i++){
			askCityToMove = askCityToMove + i + ": " + adjCities.get(i-1).toString() + "\n";
			condition = condition + i+",";
		}
		answer = readDataFromKeyBoard.takeParametersToStringRestricted(askCityToMove, condition);
		respuesta = new Integer(answer);
		getPlayer().moveCity(adjCities.get(respuesta-1));

		CommandPay cmp = new CommandPay(getPlayer(), ctg);
		cmp.execute();
		
	}

	public Integer getIdCard() {
		return id;
	}

		public String toString() {
		return "[" + id + "]" + super.toString();
	}

}
