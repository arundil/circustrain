package game;

import game.factory.GameFactory;

import java.util.List;

import board.Board;
import board.City;
import player.Player;

public class CommandSelectCanadianCity extends AbstractCommand{
	
	private Player player;
	private CircusTrainGame game;
	
	public CommandSelectCanadianCity(Player player, CircusTrainGame game){
		this.player=player;
		this.game=game;
	}
	
	public void execute(){
		Board board=game.getBoard();
		List<City> canadianCityList=board.getCanadianCities();
		String askCanadianCity="Select a canadian city: "+"\n";
		String askCanadianCityConditions="";
		
		for(int i=0;i<canadianCityList.size();i++){
			Integer optionsCount=i+1;
			askCanadianCityConditions=askCanadianCityConditions+(optionsCount)+",";
			askCanadianCity=askCanadianCity+(optionsCount)+" : "+canadianCityList.get(i).getName()+"\n";
		}
		String selectedCanadianCity=GameFactory.takeParametersToStringRestricted(askCanadianCity, askCanadianCityConditions);
		Integer citySelector=new Integer(selectedCanadianCity);
		player.moveCity(canadianCityList.get(citySelector-1));		
	}
}
