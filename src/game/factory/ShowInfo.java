package game.factory;

import game.CircusTrainGame;
import player.Player;

public class ShowInfo {

	CircusTrainGame ctg;
	Player p;

	public ShowInfo(CircusTrainGame ctg, Player p) {
		this.ctg = ctg;
		this.p = p;
	}

	public void refreshInfo() {

		/*
		 * Mostrar info de estado del juego:
		 */
		System.out.println("Estado del juego: \n\n");

		System.out.println("Estamos en el mes: \n" + ctg.getMonth());
		System.out.println("======================================n");

		System.out.println("Estamos en la semana: \n" + ctg.getWeek());

		/*
		 * Mostrar info de estado del tablero:
		 */
		System.out.println("Estado del tablero: \n\n");
		System.out.println("\n======================================\n");

		System.out.println("Las ciudades sin actuaciones son: \n"
				+ ctg.getBoard().getCitiesWithoutPerformance().toString());
		System.out.println("======================================\n");
		System.out.println("Las ciudades con actuaciones son: \n"
				+ ctg.getBoard().getCitiesWithPerfomance().toString());
		System.out.println("======================================");
		System.out.println("======================================");

		/*
		 * Mostrar info de estado del jugador:
		 */

		System.out.println("Jugador: " + p.getName());
		System.out.println("======================================\n");
		
		System.out.println("Ciudad actual: \n" + p.getCity().toString());
		System.out.println("======================================");

		System.out.println("Salario actual: \n" + p.getMoney());
		System.out.println("======================================");

		System.out.println("Actuación máxima: \n" + p.getPerformanceMax());
		System.out.println("======================================");

		System.out.println("Reputación: \n" + p.getReputation());
		System.out.println("======================================");

		System.out.println("Puntuación más alta del dado: \n"
				+ p.getHigherDiceScore());
		System.out.println("======================================");

		System.out.println("Puntos de Victoria: \n" + p.getVictoryPoints());
		System.out.println("======================================");

		System.out.println("Semanas restantes para actuación: \n"
				+ p.getWeeksToPerformance());
		System.out.println("======================================");

		System.out.println("Talentos: \n" + p.getTalents().toString());
		System.out.println("======================================");

		System.out.println("Cartas de acción: \n"
				+ p.getActionCards().toString());
		System.out.println("======================================");
		System.out.println("Cartas de acción usadas: \n"
				+ p.getPerfomancesUsed().toString());
		System.out.println("======================================");

		System.out.println("======================================");

	}
}