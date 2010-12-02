package actionCards;

import game.CommandPerformance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import board.City;
import performance.Performance;
import performance.PerformanceDemand;
import player.Player;
import utiles.factoria.CollectionsFactory;

import card.CardImpl;

public class BasicMoveImpl extends CardImpl implements ActionCard {

	private Integer id;
	private InputStreamReader isr = new InputStreamReader(System.in);
	private BufferedReader br = new BufferedReader (isr);
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
		Integer resp;
		Integer resp1;
		List<City> adjCities = CollectionsFactory.createListFactory().createList();
		try
		{
			System.out.println(player.getName()+" HAS USED --> Basic Move <-- \n" +
			"What do you want to do, move[0] or perform/contract[1]");

			resp1=Integer.parseInt(br.readLine());
			if (resp1 ==0){
				System.out.println("Select the city below where you want to move:");

				adjCities=player.getCity().getCitiesAdjacents();

				for (int i=0;i<adjCities.size();i++){
					System.out.println("--> "+adjCities.get(i)+ "["+i+"]");
				}
				resp=Integer.parseInt(br.readLine());

				if (resp >=0 && resp<= adjCities.size()){
					player.moveCity(adjCities.get(resp));

				}
			}else if(resp1==1){ 	
				System.out.println("What do you want to do? perform [0] or contract[1]");
				resp = Integer.parseInt(br.readLine());
				if (resp ==0){
					Performance p = player.getCity().getPerformance();
					CommandPerformance cp = new CommandPerformance(player,(PerformanceDemand) p);
					cp.execute();
				}
				else if (resp ==1){
					//Actuar
				}else {
					System.out.println("Incorrect option, please try again");
					execute();
				}
			}else{
				System.out.println("Incorrect option, please try again");
				execute();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}