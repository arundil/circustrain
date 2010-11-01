package tab;

import game.Talent;

import java.util.Set;

//Circo en bancarrota para el que no sepa ingles.
/**
 * @author  marc
 */
public class BankruptcyCircusTab extends Tab {
	/**
	 * @uml.property  name="talents"
	 */
	private Set<Talent> talents;
	
	public BankruptcyCircusTab(String col, Set<Talent> tals) {
		super(col);
		talents = tals;
	}
	
	/**
	 * @return
	 * @uml.property  name="talents"
	 */
	public Set<Talent> getTalents(){
		return talents;
	}
}
