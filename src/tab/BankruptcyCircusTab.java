package tab;

import game.Talent;

import java.util.Set;

//Circo en bancarrota para el que no sepa ingles.
public class BankruptcyCircusTab extends Tab {
	private Set<Talent> talents;
	
	public BankruptcyCircusTab(String col, Set<Talent> tals) {
		super(col);
		talents = tals;
	}
	
	public Set<Talent> getTalents(){
		return talents;
	}
}
