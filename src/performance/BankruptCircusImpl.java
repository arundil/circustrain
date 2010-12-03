package performance;

import java.awt.Color;
import java.util.List;

import talent.Talent;

public class BankruptCircusImpl extends performanceImpl implements BankruptCircus {
	
	
	private List<Talent> talentCircus; //talentos asociados a la carta de bancarrota
	public BankruptCircusImpl(Color cardColor, String description, String name,
			List<Talent> talentCircus) {
		super(cardColor, description, name);
		this.talentCircus = talentCircus;
	}
	public List<Talent> getTalentCircus() {
		return talentCircus;
	}
	
	@Override
	//Añadido por jenkin90
	public String toString(){
		return "Esto es un circo en Bancarrota";
	}

}
