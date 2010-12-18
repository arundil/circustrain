package performance;


import java.util.Map;

import talent.Talent;


public class PerformanceDemandImpl extends performanceImpl implements PerformanceDemand{
		public PerformanceDemandImpl(String cardColor, String description,
			Integer basicPoints,
			Map<Talent, Integer> talentPoints, boolean twoWeeks) {
		super(cardColor, description);
		this.basicPoints = basicPoints;
		this.talentPoints = talentPoints;
		this.twoWeeks = twoWeeks;
	}

	private Integer basicPoints;
	private Map<Talent, Integer> talentPoints;
	private boolean twoWeeks;
	@Override
	public Integer getBasicPoints() {
		return basicPoints;
	}

	@Override
	public Map<Talent, Integer> getTalentPoints() {
		return talentPoints;
	}

	@Override
	public Boolean isTwoWeeks() {
		return twoWeeks;
	}
	
	@Override
	public String toString(){
		String stringToReturn=super.toString();
		if(this.isTwoWeeks()){
			stringToReturn=stringToReturn+" (TWO WEEKS) ";
		}
		stringToReturn=stringToReturn+" "+this.getBasicPoints()+"+(";
		
		for(Talent t:this.getTalentPoints().keySet()){
			stringToReturn=stringToReturn+" "+t.toString()+":"+this.getTalentPoints().get(t);
		}
		stringToReturn=stringToReturn+")";
		return stringToReturn;
	}
}
