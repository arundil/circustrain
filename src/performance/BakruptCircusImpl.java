package performance;

import java.awt.Color;
import java.util.List;

import talent.Talent;

public class BakruptCircusImpl extends performanceImpl implements BankruptCircus {
	
	
	private List<Talent> talentCircus; //talentos asociados a la carta de bancarrota
	public BakruptCircusImpl(Color cardColor, String description, String name,
			List<Talent> talentCircus) {
		super(cardColor, description, name);
		this.talentCircus = talentCircus;
	}
	public List<Talent> getTalentCircus() {
		return talentCircus;
	}

}
