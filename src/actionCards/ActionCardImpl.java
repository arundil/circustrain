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

	public ActionCardImpl(String name, String des) {
		super(name, des);
	}
	
	public void movePlayer(Player player,Integer move){
		Integer answer;
		List<City> adjCities = CollectionsFactory.createListFactory().createList();

		System.out.println("Select the city below where you want to move:");
		adjCities=player.getCity().maxMovement(move);

		for (int i=0;i<adjCities.size();i++){
			System.out.println("--> ["+i+"]"+ adjCities.get(i));
		}

		answer= readDataFromKeyBoard.takeParametersToIntegerTopValue("Option:", adjCities.size());
		
		player.moveCity(adjCities.get(answer));
	}
	
	public void performPlayer(Player player){
		
		Integer answer;
		Performance p = player.getCity().getPerformance();
		if (p instanceof PerformanceDemand){
			System.out.println("This City has this PerformanceDemand : "+ p +" .You perform at "+player.getCity());
			answer = 0;
		}else if (p instanceof BankruptCircus){
			System.out.println("In this City there is this BankruptCircus: "+ p + "\n");
			answer =1;
		} else {
			throw new IllegalArgumentException("No puedes instanciar otra cosa que no sea Performance or BankruptCircus");
		}
		if (answer ==0){
			if (p instanceof PerformanceDemand){
				CommandPerformance cp = new CommandPerformance(player,(PerformanceDemand) p);
				cp.execute();
			}
			else{
				System.out.print("This city has no performance\n");
			}
		}
		if (answer ==1){
			if(p instanceof BankruptCircus){
				CommandToHire ch = new CommandToHire((BankruptCircus)p, player);
				ch.execute();
			}
			else{
				System.out.print("This city has no BankruptCircus\n");
			}
		}
	}
}