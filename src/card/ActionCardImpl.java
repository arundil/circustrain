package card;

public class ActionCardImpl extends CardImpl implements ActionCard {
	
	Integer move;
	Boolean action;
	Boolean wage;
	Integer idCard;
	
	
	public ActionCardImpl (String n, String des,Integer id,Integer m, Boolean ac, Boolean w){
		super(n,des);
		move=m;
		action = ac;
		idCard=id;
		wage= w; 
	}

	@Override
	public Integer getIdCard() {
		return idCard;
	}

	@Override
	public Integer getMove() {
		return move;
	}

	@Override
	public Boolean isAction() {
		return action;
	}

	@Override
	public Boolean isWage() {
		return wage;
	}

}
