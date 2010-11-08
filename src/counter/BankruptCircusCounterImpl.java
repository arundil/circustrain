package counter;

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
	private Set<TalentImpl> talents;
	
	public BankruptCircusCounterImpl(String col, Set<TalentImpl> tals) {
		super(col);
		talents = tals;
	}
	
	/**
	 * @return
	 * @uml.property  name="talents"
	 */
	public Set<TalentImpl> getTalents(){
		return talents;
	}
}
