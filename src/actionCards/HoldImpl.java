package actionCards;

import card.CardImpl;

public class HoldImpl extends CardImpl implements ActionCard {

	public HoldImpl() {
		super("HoldImpl","If you are in Canada (Winnipeg, Montreal or Toronto), " +
				"you can take one clown, one acrobat, or rise your reputation in one level" );
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
