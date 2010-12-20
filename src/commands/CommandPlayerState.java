package commands;

import performance.PerformanceDemand;
import player.Player;

public class CommandPlayerState implements Command{
	
	private Player player;
	
	public CommandPlayerState(Player player){
		this.player=player;
	}
	
	public void execute(){
		String messageForTwoWeeksPerformance = 
			"Debes actuar " + player.getWeeksToPerformance()+" vez/veces más para puntuar.";
		if(player.getCity().hasPerfomance()){
			if(player.getCity().getPerformance() instanceof PerformanceDemand){
				PerformanceDemand performance =(PerformanceDemand) player.getCity().getPerformance();
				if(performance.isTwoWeeks()){			
					System.out.println("Recuerda que estás en una ciudad que tiene una demanda de actuación de dos semanas."+"\n"+messageForTwoWeeksPerformance);
				}
			}
		}
		String actionCardList=player.getActionCards().toString();
		System.out.println("Tienes la/s siguiente/s carta/s de acción: \n "+actionCardList);
		if(!player.getdiscartpile().isEmpty()){
			String discardActionCardList=player.getdiscartpile().toString();			
			System.out.println("Tienes la/s siguiente/s carta/s de acción en tu pila de cartas descartadas: "+discardActionCardList);
		}
		System.out.println("Tienes los siguientes talentos: "+player.getTalents().toString());
		System.out.println("Tu reputación es "+player.getReputation());			
	//No haria falta si mostramo el tablero.
		System.out.println("Tu tirada de dado máxima es: "+player.getHigherDiceScore());
		
		System.out.println("Actualmente estás en: "+player.getCity().toString());
		System.out.println("Tus puntos de máxima actuación son: "+player.getPerformanceMax());
		System.out.println("Tienes "+player.getMoney()+" $");
	}

}
