package actionCards;

import card.CardImpl;

public class WagesImpl extends CardImpl implements ActionCard {

	public WagesImpl() {
		super("Wages", "You can move until 2 cities. Then, you have to " +
				"pay the wages or eliminate Talents");
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
