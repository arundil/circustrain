package actionCards;

import card.CardImpl;

public class FastMoveImpl extends CardImpl implements ActionCard {

	public FastMoveImpl() {
		super("Fast Move","You can move until 5 cities");
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}

	@Override
	public Integer getIdCard() {
		return null;
	}

}
