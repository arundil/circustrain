package actionCards;

import card.CardImpl;

public class TravelImpl extends CardImpl implements ActionCard {

	public TravelImpl() {
		super("Travel", "You can move until 3 cities");
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getIdCard() {
		// TODO Auto-generated method stub
		return null;
	}

}
