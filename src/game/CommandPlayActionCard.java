package game;

import game.factory.GameFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import board.City;

import player.Player;

import utiles.factoria.CollectionsFactory;

import card.ActionCard;
import card.TypeTalentCard;

public class CommandPlayActionCard extends AbstractCommand{
	
	private Player player;
	
	public CommandPlayActionCard(Player player){
		this.player=player;
	}
	
	public void execute(){
		List<ActionCard> actionCardList=player.getActionCards();
		Set<Integer> actionCardIdSet=CollectionsFactory.createSetFactory().createSet();
		for(ActionCard c:actionCardList){
			actionCardIdSet.add(c.getIdCard());
		}
		System.out.println(actionCardList.toString());
		Integer cardIdToBePlayed=-1;
		while(!actionCardIdSet.contains(cardIdToBePlayed)){
			cardIdToBePlayed=GameFactory.takeParametersToInteger("Select the card: NUMBER");
		}
		for(ActionCard actionCard:actionCardList){
			if(actionCard.getIdCard()==cardIdToBePlayed){
				actionCard.execute();
				player.discardActionCard(cardIdToBePlayed);
			}
		}
	}
		//****ESTO PUEDE AYUDAR A HACER EL EXECUTE DE LAS ACTION CARDS****
//		if(actionCard.isAction()){
//			String line= GameFactory.takeParametersToString("Select an action: MOVE,PERFORMANCE");
//			if(line.equals("MOVE")){
//				//**¿Como se yo que es movimiento exacto o un numero con cierto limite?
//				//no tengo metodos para saberlo
//				//**¿Como hago para mover el tren de cada jugador? No hay ningun metedo
//				//para moverse en el tipo Counter ni Player tiene ningun indicador
//			}else{
//				if(line.equals("PERFORMANCE")){
//					Integer performancePoints=0;
//					City currentCity=player.getCity();
//					boolean b=currentCity.hasPerformance();					
//					if(b){
//						if(currentCity tiene un circo){
//							//**¿Como se si tengo un circo o una actuacion?
//							CommandToHire commandhire= new CommandToHire(currentCity.getCounter(),player);
//							//**getCounter devolveria el tipo de counter que tiene la ciudad en la que se
//							//encuentra el jugador
//						}else{
//							if(currentCity tiene una actuacion){
//								CommandPerformance commandperformance = 
//												new CommandPerformance();
//							}
//						}
//						//**¿Como se yo qué tiene la ciudad dentro: circo en banca rota o actuacion?
//						//no tengo metodos para saberlo
//					}
//				}
//			}
//		}
	

}
