package performance;

import java.awt.Color;
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
		return "Esta carta es de color "+ this.getColor().toString()+ " es un " + this.getDescription()+ this.getTalentCircus().toString();
	}

}
