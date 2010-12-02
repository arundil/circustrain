package actionCards;

import card.Card;

public interface ActionCard extends Card {
	
	public Integer getIdCard();
	public void execute();
}
