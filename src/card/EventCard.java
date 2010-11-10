package card;

import java.util.List;

public interface EventCard extends Card{
	
	public String getName(); 
	// Puede servir como descripción de la carta directamente. A consultar con grupo.
	
	public List<EventCard> createListEventSinglePlayer();
	// Devolverá la lista de los eventos permitidos para el Single Player (17-20).

	public int getNumEventCard(); // Importante para el modo solitario.
	
	/*
	 * Si decidimos modelarlo en una sola interfaz, estos métodos
	 * serían útiles para diferenciarlas. Aún faltarían más... Esto va a ser la mueeerrrteeee...
	 * Se prorrogará.
	 */
	public boolean isDependOfMonth();
	public boolean isDependOfMoves();
	public boolean isDependOfActionCard();
	public boolean isDependOfMoney();
	public boolean isDependOfPoints();
	public boolean isCrashBag(); // se hunde la bolsa de valores, si salen 2 acaba el juego.
	
	
	
}
