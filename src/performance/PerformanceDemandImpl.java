package performance;

import java.awt.Color;
import java.util.Map;

import talent.Talent;


public class PerformanceDemandImpl extends performanceImpl implements PerformanceDemand{
		public PerformanceDemandImpl(Color cardColor, String description,
			String name, Integer basicPoints,
			Map<Talent, Integer> talentPoints, boolean twoWeeks) {
		super(cardColor, description, name);
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
	public String toString(){
		String r;
		if(this.isTwoWeeks()){
			r = "Esto es "+ this.getName()+"su descripcion es"+ this.getDescription()+"es de color"+ this.getColor()+"sus puntos basicos son"+this.getBasicPoints()+"y sus puntos de talento son:";
			for(this.getTalentPoints().keySet().iterator();this.getTalentPoints().keySet().iterator().hasNext();){
				r+= "su talento es"+this.getTalentPoints().keySet().iterator().next().toString();//falta el nombre de los talents
				r+= "su valor es" + this.getTalentPoints().get(this.getTalentPoints().keySet().iterator().next()).toString();
				}
			r+="y es de dos semanas";
		}else{
			r = "Esto es "+ this.getName()+"su descripcion es"+ this.getDescription()+"es de color"+ this.getColor()+"sus puntos basicos son"+this.getBasicPoints()+"y sus puntos de talento son:";
			for(this.getTalentPoints().keySet().iterator();this.getTalentPoints().keySet().iterator().hasNext();){
				r+= "su talento es"+this.getTalentPoints().keySet().iterator().next().toString();//falta el nombre de los talents
				r+= "su valor es" + this.getTalentPoints().get(this.getTalentPoints().keySet().iterator().next()).toString();
				}
			r+="y es de dos semanas";
			}
		return r;
	}


}
