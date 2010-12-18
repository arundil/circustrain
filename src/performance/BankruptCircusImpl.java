package performance;


import java.util.List;

import talent.Talent;

public class BankruptCircusImpl extends performanceImpl implements BankruptCircus {
	
	
	private List<Talent> talentCircus; //talentos asociados a la carta de bancarrota
	public BankruptCircusImpl(String cardColor, String description, 
			List<Talent> talentCircus) {
		super(cardColor, description);
		this.talentCircus = talentCircus;
	}
	public List<Talent> getTalentCircus() {
		return talentCircus;
	}
	
	@Override
	public String toString(){
		String stringToReturn=super.toString();
		for(Talent t:this.getTalentCircus()){
			stringToReturn=stringToReturn+" "+t.toString()+"("+t.getWage()+")";
		}
		return stringToReturn;
	}
}
