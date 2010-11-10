package counter;

import game.Talent;
import game.TalentImpl;

import java.util.Set;

//Circo en bancarrota para el que no sepa ingles.
/**
 * @author  marc
 */
public class BankruptCircusCounterImpl extends CounterImpl implements BankruptCircusCounter{
	/**
	 * @uml.property  name="talents"
	 */
	private Set<Talent> talents;
	
	public BankruptCircusCounterImpl(String col, Set<Talent> tals) {
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
