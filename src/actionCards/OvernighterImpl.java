package actionCards;

import game.CommandPerformance;
import game.CommandToHire;
import game.factory.GameFactory;

import java.util.List;

import board.City;
import performance.BankruptCircus;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;
import utiles.factoria.CollectionsFactory;
import card.CardImpl;

public class OvernighterImpl extends CardImpl implements ActionCard {
	private Player player;
	private Integer id;
	
	public OvernighterImpl(Player p) {
		super("OvernighterImpl", "You can move toward 2 cities and/or perform/contract");
		player=p;
		id = 6;
	}

	@Override
	public void execute() {
		Integer answer, answer_city;
		List<City> adjCities = CollectionsFactory.createListFactory().createList();

		System.out.println(player.getName()+" has used ==> OVERNIGHTER <== \n" +
		"What do you want to do?, move[0], perform/contract[1] or both[2]");
		answer = GameFactory.takeParametersToIntegerRestricted("Option:","0,1,2");
		
		if (answer == 0 || answer ==2){
			System.out.println("Select the city below where you want to move:");
			adjCities=player.getCity().maxMovement(2);

			for (int i=0;i<adjCities.size();i++){
				System.out.println("--> ["+i+"]"+ adjCities.get(i));
			}

			answer_city= GameFactory.takeParametersToIntegerTopValue("Option:", adjCities.size());
			player.moveCity(adjCities.get(answer_city));
		}
		if (answer == 1 || answer ==2){
			System.out.println("What do you want to do? perform [0] or contract[1]");
			answer = GameFactory.takeParametersToIntegerRestricted("Option:","0,1");
			if (answer ==0){
				Performance p = player.getCity().getPerformance();
				CommandPerformance cp = new CommandPerformance(player,(PerformanceDemand) p);
				cp.execute();
			}
			if (answer ==1){
				if(player.getCity().hasBanckuptyCircus()){
					BankruptCircus circus = player.getCity().getBanckuptyCircus();
					CommandToHire ch = new CommandToHire(circus, player);
					ch.execute();
				}
				else{
					System.out.print("This city has no BankruptCircus");
				}
			}
		}
	}

	@Override
	public Integer getIdCard() {
		return id;
	}

}
