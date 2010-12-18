package commands;

import game.AbstractCommand;
import game.TwoPlayersGame;

import java.util.List;
import java.util.Map;
import player.Player;
import talent.Talent;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.readDataFromKeyBoard;

public class CommandPay extends AbstractCommand{
	
	private Player player;
	private TwoPlayersGame game;
	private Integer wageMultiplicator;

	public CommandPay(Player player,TwoPlayersGame game){
		this.player=player;
		this.game=game;
		this.wageMultiplicator=1;
	}
	public CommandPay(Player player,TwoPlayersGame game,Integer multiplicator){
		this.player=player;
		this.game=game;
		this.wageMultiplicator=multiplicator;
	}
		
	public void execute(){
		String conditions="";
		String mess="";
		String resp = "";
		Integer respuesta = 0;
		Map<Talent,Integer> maptalents = player.getTalents();
		Integer cont=0;
		
		//Calculamos cuanto valen pagar todos los talentos.
		
		for(Talent talent:maptalents.keySet()){
			cont=cont+(talent.getWage()*maptalents.get(talent)*wageMultiplicator);
		}
		
		if(!(cont<=0)){
			//Si estamos en el modo avanzado y podemos pagar todos los talentos.
			if(player.getPlay_Mode() && player.getMoney() - cont > 0){
				mess = "Do you want to pay all Talents? You paid "+cont+"$ \n 1: No \n 2: Yes";
				conditions = "1,2";
				resp = readDataFromKeyBoard.takeParametersToStringRestricted(mess, conditions);
				respuesta = new Integer (resp);
				if(respuesta == 2){                             
					player.addMoney(-cont);
				}
				else{
					toFire(true);
					execute();
				}
				//Modo avanzado y no puede pagar todos los talentos.
			}else if(player.getPlay_Mode()){
				toFire(false);
				execute(); 
				
			}else{
				//Modo básico pagando todos los talentos.
				if(player.getMoney() -cont >= 0){
					player.addMoney(-cont);
					//Modo basico no puede pagar todos los talentos.
				}else{
					toFire(false);
					execute();
				}
			}
		}
	}
	
	private void toFire(Boolean money){
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
        game.getTalentBag().addTalent(talent);
        
		if(money){
			if(game.getMonth().equals("AUGUST") || game.getMonth().equals("SEPTEMBER")){			
				if(player.getVictoryPoints()<3){
					player.addVictoryPoints(-player.getVictoryPoints());
					assert player.getVictoryPoints()!=0:"Puntos de victoria no son 0";
				}else{
					player.addVictoryPoints(-3);
					assert player.getVictoryPoints()>=0:"Puntos de victoria negativos";
				}
			}else{
				if(player.getReputation()<7){
					player.addReputation(1);
					assert player.getReputation()<7:"Reputacion fuera de rango";
				}
			}
		}	
	}
}
