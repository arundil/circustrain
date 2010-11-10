package counter;

import game.Talent;
import game.TalentImpl;

import java.util.Set;

public interface BankruptCircusCounter extends Counter{
	
	public Set<Talent> getTalents();

}
