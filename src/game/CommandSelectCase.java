package game;

import player.Player;
import utiles.factoria.readDataFromKeyBoard;

public class CommandSelectCase extends AbstractCommand{
	
	private Player player;
	private CircusTrainGame game;
	
	public CommandSelectCase(Player player,CircusTrainGame game){
		this.player=player;
		this.game=game;
	}
	
	public void execute() {
		String action1="1 : Play one Action card from my hand";
		String action2="2 : Play one Action card from my discard pile";		
		String action3="3 : Collect money from the bank";
		String askBasicAction="What are you going to do:"+"\n"+action1;
		String askAllActions=askBasicAction+"\n"+action2+"\n"+action3;
		String askActionsDiscardedNoMoney=askBasicAction+"\n"+action2;
		String askActionsNoDiscardedMoney=askBasicAction+"\n"+action3;
		String askBasicActionCondition="1";
		String askAllActionsCondition="1,2,3";
		String askActionsDiscardedNoMoneyCondition="1,2";
		String askActionsNoDiscardedMoneyCondition="1,3";
		String action;
		if(!game.getMonth().equals("AUGUST") || !game.getMonth().equals("SEPTEMBER")){
			//Si puede perder 2 puntos de reputacion,podra optar a jugar una carta de accion de su mano,
			//jugar carta de accion descartadao o a obtener dinero del banco
			if(player.getReputation()<=6){
				action=readDataFromKeyBoard.takeParametersToStringRestricted(askAllActions, askAllActionsCondition);
			}else{	
				//Si solo puede perder 1 punto de reputacion solo podra optar a jugar una carta de accion de su mano o a coger dinero del banco
				if(player.getReputation()<=7){
					action=readDataFromKeyBoard.takeParametersToStringRestricted(askActionsNoDiscardedMoney, askActionsNoDiscardedMoneyCondition);
				}else{
					action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, askBasicActionCondition);
				}
			}						
		}else{
			//Si puede perder 4 puntos de victoria, podra optar a jugar una carta de accion de su mano o a jugar una carta de accion descartada
			if(player.getVictoryPoints()>=4){
				action=readDataFromKeyBoard.takeParametersToStringRestricted(askActionsDiscardedNoMoney, askActionsDiscardedNoMoneyCondition);
			}else{
				action=readDataFromKeyBoard.takeParametersToStringRestricted(askBasicAction, askBasicActionCondition);
			}
			
		}
		game.setFollowingAction(action);
		
	}
	
}
