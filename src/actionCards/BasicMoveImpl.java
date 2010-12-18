package actionCards;

import java.util.List;

import commands.CommandPerformance;
import commands.CommandToHire;

import board.City;
import performance.BankruptCircus;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;


public class BasicMoveImpl extends ActionCardImpl implements ActionCard {

	private Integer id;
	Player player;

	public BasicMoveImpl(Integer n, Player p) {
		super("Basic Move", "You can move towards 1 city or perform/contract");
		id=n;
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
		
		System.out.println(player.getName()+" has used ==> BASIC MOVE <== \n");
		
		if (player.getCity().hasPerfomance()){
			System.out.println("What do you want to do, move[0] or perform/contract[1]");
			answer=readDataFromKeyBoard.takeParametersToIntegerRestricted("Option:","0,1");
		}else{
			System.out.println(player.getCity()+" has no Performance. Where do you want to travel?");
			answer=0;
		}

		if (answer ==0){
			System.out.println("Select the city below where you want to move:");

			adjCities=player.getCity().maxMovement(1);

			for (int i=0;i<adjCities.size();i++){
				System.out.println("--> ["+i+"]"+ adjCities.get(i));
			}

			answer= readDataFromKeyBoard.takeParametersToIntegerTopValue("Option:", adjCities.size());
			
			player.moveCity(adjCities.get(answer));
		}else if(answer==1){ 	
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
			}
			if (answer ==1){
				if(p instanceof BankruptCircus){
					CommandToHire ch = new CommandToHire((BankruptCircus)p, player);
					ch.execute();
				}
			}
		}
	}


	public String toString() {
		return "[" + id + "]" + super.toString();
	}
	
}