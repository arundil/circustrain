package actionCards;

import game.CommandPerformance;
import game.CommandToHire;
import game.factory.GameFactory;

import java.util.List;
import java.util.prefs.BackingStoreException;

import board.City;
import performance.BankruptCircus;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;
import utiles.factoria.CollectionsFactory;

import card.CardImpl;

public class BasicMoveImpl extends CardImpl implements ActionCard {

	private Integer id;
	Player player;

	public BasicMoveImpl(Integer n, Player p) {
		super("Basic Move", "You can move towards 1 city or perform/contract");
		n=id;
		player = p;
	}

	@Override
	public Integer getIdCard() {
		return id;
	}

	@Override
	public void execute() {
		Integer answer;
		List<City> adjCities = CollectionsFactory.createListFactory().createList();

		System.out.println(player.getName()+" has used ==> BASIC MOVE <== \n" +
		"What do you want to do, move[0] or perform/contract[1]");

		answer=GameFactory.takeParametersToIntegerRestricted("Option:","0,1");

		if (answer ==0){
			System.out.println("Select the city below where you want to move:");

			adjCities=player.getCity().maxMovement(1);

			for (int i=0;i<adjCities.size();i++){
				System.out.println("--> ["+i+"]"+ adjCities.get(i));
			}

			answer= GameFactory.takeParametersToIntegerTopValue("Option:", adjCities.size());
			
			player.moveCity(adjCities.get(answer));
		}
		if(answer==1){ 	
			System.out.println("What do you want to do? perform [0] or contract[1]");
			answer = GameFactory.takeParametersToIntegerRestricted("Option:","0,1");
			if (answer ==0){
				if (player.getCity().hasPerfomance()){
					Performance p = player.getCity().getPerformance();
					CommandPerformance cp = new CommandPerformance(player,(PerformanceDemand) p);
					cp.execute();
				}
				else{
					System.out.print("This city has no performance");
				}
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
}