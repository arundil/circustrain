package counter;

import game.Talent;

import java.util.Set;

//Circo en bancarrota para el que no sepa ingles.
/**
 * @author  marc
 */
public class BankruptCircusCounter extends Counter {
	/**
	 * @uml.property  name="talents"
	 */
	private Set<Talent> talents;
	
	public BankruptCircusCounter(String col, Set<Talent> tals) {
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
