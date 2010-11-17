package game;

import game.factory.GameFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

import player.Player;

import utiles.factoria.CollectionsFactory;

import card.ActionCard;
import card.TypeTalentCard;

public class CommandPlayActionCard extends AbstractCommand{
	
	private ActionCard actionCard;
	private Player player;
	
	public CommandPlayActionCard(Player player,ActionCard actionCard){
		this.player=player;
		this.actionCard=actionCard;
	}
	
	public void execute(){
		if(actionCard.isAction()){
			String line= GameFactory.takeParametersToString("Select an action: MOVE,PERFORMANCE");
			if(line.equals("MOVE")){
				//**¿Como se yo que es movimiento exacto o un numero con cierto limite?
				//no tengo metodos para saberlo
				//**¿Como hago para mover el tren de cada jugador? No hay ningun metedo
				//para moverse en el tipo Counter ni Player tiene ningun indicador
			}else{
				if(line.equals("PERFORMANCE")){
					Integer performancePoints=0;
					//getCurrentCity() deberia devolver un City que seria la ciudad actual
					//No se el por qué no peta
					City currentCity=player.getCurrentCity();
					boolean b=currentCity.hasPerformance();					
					if(b){
						if(currentCity tiene un circo){
							CommandToHire commandhire= new CommandToHire(city,player);
						}
						//**¿Como se yo qué tiene la ciudad dentro: circo en banca rota o actuacion?
						//no tengo metodos para saberlo
					}
				}
			}
		}
	}
	

}
