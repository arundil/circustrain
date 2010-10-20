package card;


public class ActionCard extends Card {
	private Integer idcard, move;
	private Boolean action, wage;

	public ActionCard(String name, String des,Integer idc, Integer mov, Boolean act, Boolean wag) {
		super(name, des);
		idcard = idc;
		move = mov;
		action = act;
		wage = wag; 
	}
	
	public Integer getIdCard(){
		return idcard;
	}
	public Integer getMove(){
		return move;
	}
	public Boolean getAction(){
		return action;
	}
	public Boolean getWage(){
		return wage;
	}

}
