package actionCards;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import board.City;
import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;
import card.CardImpl;

public class WagesImpl extends CardImpl implements ActionCard {
	Integer id;
	Player player;
	Boolean fire;
	Boolean move = false;
	
	public WagesImpl(Player player, Boolean fire) {
		super("Wages", "You can move until 2 cities. Then, you have to " +
				"pay the wages or eliminate Talents");
		this.id = 5;
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
		
		
		if(!move){
			System.out.println(player.getName()+" has used ==> WAGES <== \n" );
			moveCity();
			move=true;
		}
		
		//Calculamos cuanto valen todos los talentos.
		for(Entry<Talent,Integer> entry : mapt.entrySet()){
			cont = cont + entry.getKey().getWage() * entry.getValue();
		}
		if(!(cont<=0)){
			//Si estamos en el modo avanzado y podemos pagar todos los talentos.
			if(fire && player.getMoney() -cont >= 0){
				mess = "Do you want to pay all Talents? You paid "+cont+"$ \n 1: No \n 2: Yes";
				cond = "1,2";
				resp = readDataFromKeyBoard.takeParametersToStringRestricted(mess, cond);
				respuesta = new Integer (resp);
				if(respuesta == 2){				
					player.addMoney(-cont);
				}
				else{
					fire();
					execute();
				}
				//Modo avanzado y no se pueden pagar todos los talentos.
			}else if(fire){
				fire();
				execute();	
				//Modo básico.
			}else{
				if(player.getMoney() -cont >= 0){
					player.addMoney(-cont);
				}else{
					fire();
					execute();
				}
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
		resp = readDataFromKeyBoard.takeParametersToStringRestricted(mess, cond);
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

		List<Talent> listtalent = CollectionsFactory.createListFactory().createList();
		Talent talent;
		for(Talent t:mapt.keySet()){
			listtalent.add(t);
		}

		for(Talent t : mapt.keySet()){
			mess = mess + cont + ": "+"You have " + mapt.get(t)+ " " + t.getName()+ " and " +t.toString() +"\n";
			cond=cond + cont + ",";
			cont++;
		}
		resp = readDataFromKeyBoard.takeParametersToStringRestricted(mess, cond);
		respuesta = new Integer(resp);
		talent = listtalent.get(respuesta-1);
		player.discardTalent(talent);
		//Falta aumentar en uno la bolsa de talentos del juego. Pero no se como hacerlo.
	}

	public String toString() {
		return "[" + id + "]" + super.toString();
	}

}
