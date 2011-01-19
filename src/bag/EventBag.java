package bag;

import java.util.List;

import card.EventCard;

public interface EventBag extends EventCard{
	

	public List<EventCard> createEventBag();
	
	public EventCard getEventCard();
	public EventCard removeEventCard(EventCard e);
	public EventCard addEventCard(EventCard e); // si se hace al azar, sería sin param.

}
