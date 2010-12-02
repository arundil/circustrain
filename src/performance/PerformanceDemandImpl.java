package performance;

import java.awt.Color;
import java.util.Map;

public class PerformanceDemandImpl extends performanceImpl implements PerformanceDemand{
		public PerformanceDemandImpl(Color cardColor, String description,
			String name, Integer basicPoints,
			Map<String, Integer> talentPoints, boolean twoWeeks) {
		super(cardColor, description, name);
		this.basicPoints = basicPoints;
		this.talentPoints = talentPoints;
		this.twoWeeks = twoWeeks;
	}

	private Integer basicPoints;
	private Map<String,Integer> talentPoints;
	private boolean twoWeeks;
	@Override
	public Integer getBasicPoints() {
		// TODO Auto-generated method stub
		return basicPoints;
	}

	@Override
	public Map<String, Integer> getTalentPoints() {
		// TODO Auto-generated method stub
		return talentPoints;
	}

	@Override
	public Boolean isTwoWeeks() {
		// TODO Auto-generated method stub
		return twoWeeks;
	}


}
