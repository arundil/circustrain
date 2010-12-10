package bag;

import java.util.Map;

import talent.Talent;

public interface TalentBag {

	public Integer getNumTalents(Talent t);

	public Map<Talent, Integer> getTalentBag();

	public Talent removeTalent(Talent t);

	public Talent addTalent(Talent t); // si se hace al azar, sería sin param.

	public Integer getNumTypeTalent(Talent t);

}