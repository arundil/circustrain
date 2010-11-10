package bag;

import java.util.List;

import card.EventCard;

public interface EventBag extends EventCard{
	
	// Boceto. La lista de cartas de Evento para el modo solitario podría sacarse de aquí
	// también, aunque son solo 4 cartas...
	
	public List<EventCard> createEventBag();
	
	public EventCard getEventCard();
	public EventCard removeEventCard(EventCard e);
	public EventCard addEventCard(EventCard e); // si se hace al azar, sería sin param.

}
