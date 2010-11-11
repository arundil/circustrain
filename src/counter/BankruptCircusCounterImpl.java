package counter;

import java.util.Set;

import card.TypeTalentCard;

//Circo en bancarrota para el que no sepa ingles.
/**
 * @author  marc
 */
public class BankruptCircusCounterImpl extends CounterImpl implements BankruptCircusCounter{
	/**
	 * @uml.property  name="talents"
	 */
	private Set<TypeTalentCard> talents;
	
	public BankruptCircusCounterImpl(String col, Set<TypeTalentCard> tals) {
		super(col);
		talents = tals;
	}
	
	/**
	 * @return
	 * @uml.property  name="talents"
	 */
	public Set<TypeTalentCard> getTalents(){
		return talents;
	}
}
