package tab;


public class ShowTab extends Tab {
	private Integer points, clow, horse, acrobats; 
	private Integer bigfeline, elephant, bulletman, monsterfair;
	private String color;
	
	public ShowTab(String col, Integer idt, Integer point, Integer cl, Integer hor, Integer acr, 
				Integer bigfel, Integer elep, Integer bullman, Integer monsf){
		super(col);
		points = point;
		clow = cl;
		horse = hor;
		acrobats = acr;
		bigfeline = bigfel;
		elephant = elep;
		bulletman = bullman;
		monsterfair = monsf;
	}

	public Integer getPoints(){
		return points;
	}
	public Integer getClow(){
		return clow;
	}
	public Integer getHorse(){
		return horse;
	}
	public Integer getAcrobats(){
		return acrobats;
	}
	public Integer getBigFeline(){
		return bigfeline;
	}
	public Integer getElephant(){
		return elephant;
	}
	public Integer getBulletMan(){
		return bulletman;
	}
	public Integer getMonsterFair(){
		return monsterfair;
	}
	public String getColor(){
		return color;
	}
}
