package performance;

import java.util.Iterator;
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
		// TODO Auto-generated method stub
		return basicPoints;
	}

	@Override
	public Map<Talent, Integer> getTalentPoints() {
		// TODO Auto-generated method stub
		return talentPoints;
	}

	@Override
	public Boolean isTwoWeeks() {
		// TODO Auto-generated method stub
		return twoWeeks;
	}
	
	
	@Override
//	public String toString(){
//		String r;
//		if(this.isTwoWeeks()){
//			r = "Esto es "+ this.getDescription()+" es de color "+ this.getColor().toString()+" sus puntos basicos son "+this.getBasicPoints()+" y sus puntos de talento son: ";
//			Iterator<Talent> i = this.getTalentPoints().keySet().iterator();
//			Talent s;
//			while(i.hasNext()){
//				s=i.next();
//				r+= " su talento es "+s.toString();//falta el nombre de los talents
//				r+= " su valor es " + this.getTalentPoints().get(s).toString();
//				}
//			r+=" y es de dos semanas ";
//		}else{
//			r = "Esto es  "+ this.getDescription()+" es de color "+ this.getColor().toString()+" sus puntos basicos son "+this.getBasicPoints()+" y sus puntos de talento son: ";
//			Iterator<Talent> i = this.getTalentPoints().keySet().iterator();
//			Talent s;
//			while(i.hasNext()){
//				s=i.next();
//				r+= " su talento es "+s.toString();//falta el nombre de los talents
//				r+= " su valor es " + this.getTalentPoints().get(s).toString();
//				}
//			r+=" y no es de dos semanas ";
//			}
//		return r;
//	}
	
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
