package counter;

import java.util.Set;

import card.TalentCard;

//Circo en bancarrota para el que no sepa ingles.
/**
 * @author  marc
 */
public class BankruptCircusCounterImpl extends CounterImpl implements BankruptCircusCounter{
	/**
	 * @uml.property  name="talents"
	 */
	private Set<TalentCard> talents;
	
	public BankruptCircusCounterImpl(String col, Set<TalentCard> tals) {
		super(col);
		talents = tals;
	}
	
	/**
	 * @return
	 * @uml.property  name="talents"
	 */
	public Set<TalentCard> getTalents(){
		return talents;
	}
}
