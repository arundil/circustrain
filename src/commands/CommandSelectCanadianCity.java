package commands;


import game.CircusTrainGame;

import java.util.List;

import board.Board;
import board.City;
import player.Player;
import utiles.factoria.readDataFromKeyBoard;

public class CommandSelectCanadianCity implements Command{
	
	private Player player;
	private CircusTrainGame game;
	
	public CommandSelectCanadianCity(Player player, CircusTrainGame game){
		this.player=player;
		this.game=game;
	}
	
	public void execute(){
//		Board board=game.getBoard();
//		List<City> canadianCityList=board.getCanadianCities();
//		String askCanadianCity="Select a canadian city: "+"\n";
//		String askCanadianCityConditions="";
//		
//		for(int i=0;i<canadianCityList.size();i++){
//			Integer optionsCount=i+1;
//			askCanadianCityConditions=askCanadianCityConditions+(optionsCount)+",";
//			askCanadianCity=askCanadianCity+(optionsCount)+" : "+canadianCityList.get(i).getName()+"\n";
//		}
//		String selectedCanadianCity=readDataFromKeyBoard.takeParametersToStringRestricted(askCanadianCity, askCanadianCityConditions);
//		Integer citySelector=new Integer(selectedCanadianCity);
//		player.moveCity(canadianCityList.get(citySelector-1));		
	}
}
