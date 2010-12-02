package actionCards;

import game.factory.GameFactory;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import board.City;
import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import card.CardImpl;

public class WagesImpl extends CardImpl implements ActionCard {
	Integer id;
	Player player;
	Boolean fire;
	
	public WagesImpl(Integer id, Player player, Boolean fire) {
		super("Wages", "You can move until 2 cities. Then, you have to " +
				"pay the wages or eliminate Talents");
		this.id = id;
		this.player = player;
		this.fire = fire;
	}

	public void execute() {
		String mess = "";
		String cond="";
		String resp="";
		Integer respuesta =0;
		Integer cont=0;
		Map<Talent, Integer> mapt = player.getTalents();
		Boolean move = false;
		
		if(!move){
			moveCity();
			move=true;
		}
		
		for(Entry<Talent,Integer> entry : mapt.entrySet()){
			cont = cont + entry.getKey().getWage() * entry.getValue();
		}
		if(fire && player.getMoney() -cont >= 0){
			mess = "Do you want to pay all Talents? You paid "+cont+"$ \n 0: No \n 1: Yes";
			cond = "0,1";
			resp = GameFactory.takeParametersToStringRestricted(mess, cond);
			respuesta = new Integer (resp);
			if(respuesta == 1)
				player.addMoney(-cont);
			
		}else if(fire){
			fire();
			execute();	
			
		}else{
			if(player.getMoney() -cont >= 0){
				player.addMoney(-cont);
			}else{
				fire();
				execute();
			}
		}
	}

	public Integer getIdCard() {
		return id;
	}
	
	
	private void moveCity(){
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
		resp = GameFactory.takeParametersToStringRestricted(mess, cond);
		respuesta = new Integer(resp);
		player.moveCity(adjCities.get(respuesta-1));	
	}
	
	private void fire(){
		String mess = "What talent do you want to fire? \n"; 
		String cond="";
		String resp ="";
		Integer respuesta =0;
		Integer cont = 1;
		Map<Talent, Integer> mapt = player.getTalents();
		
		//I have one problem, big problem. No solution problem :S
		//falta de informacion de talentos toString.
		//Acepto ideas, tengo una solucion fea.
		List<Talent> listtalent = CollectionsFactory.createListFactory().createList();
		Talent talent;
		for(Talent t:mapt.keySet()){
			listtalent.add(t);
		}
		
		for(Talent t : mapt.keySet()){
			mess = mess + cont + ": " + t.toString()+ "\n";
			cond=cond + cont + ",";
			cont++;
		}
		resp = GameFactory.takeParametersToStringRestricted(mess, cond);
		respuesta = new Integer(resp);
		talent = listtalent.get(respuesta-1);
		cont = mapt.get(talent);
		player.getTalents().put(talent, cont-1);
	}
	
}
