package talent;


public class TalentImpl implements Talent {

	private Integer wage;

	public TalentImpl(Integer wage) {
		this.wage = wage;

	}
	public void setTalent(Integer w){
		this.wage=w;
	}
	public Integer getWage(){
		return wage;
	}

}
