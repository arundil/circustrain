package actionCards;

import gameState.GameState;
import card.Card;

public interface ActionCard extends Card {
	public void execute(GameState gameState);
}
