package card;

public interface EventCard extends Card{
	
	public String getName(); 
	// Puede servir también como descripción de la carta. A consultar con grupo.
	
	public boolean isSinglePlayer(); 
	// Teniendo en cuenta que Single player significa jugador en solitario!! 
	// Solo se usan cartas del 17 al 20.

	public int getNumEventCard(); 
	// Nos devolverá el número de la carta. Importante para el modo solitario.
	
	public int currentMonth(); // Necesitamos saber el mes actual. Probablemente se implemente en 
	// la clase que lleve la historia.
	
	
	
}
