package tab;


/**
 * @author  marc
 */
public class ShowTab extends Tab {
	/**
	 * @uml.property  name="points"
	 */
	private Integer points;
	/**
	 * @uml.property  name="clow"
	 */
	private Integer clow;
	/**
	 * @uml.property  name="horse"
	 */
	private Integer horse;
	/**
	 * @uml.property  name="acrobats"
	 */
	private Integer acrobats; 
	private Integer bigfeline;
	/**
	 * @uml.property  name="elephant"
	 */
	private Integer elephant;
	private Integer bulletman;
	private Integer monsterfair;
	/**
	 * @uml.property  name="color"
	 */
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

	/**
	 * @return
	 * @uml.property  name="points"
	 */
	public Integer getPoints(){
		return points;
	}
	/**
	 * @return
	 * @uml.property  name="clow"
	 */
	public Integer getClow(){
		return clow;
	}
	/**
	 * @return
	 * @uml.property  name="horse"
	 */
	public Integer getHorse(){
		return horse;
	}
	/**
	 * @return
	 * @uml.property  name="acrobats"
	 */
	public Integer getAcrobats(){
		return acrobats;
	}
	public Integer getBigFeline(){
		return bigfeline;
	}
	/**
	 * @return
	 * @uml.property  name="elephant"
	 */
	public Integer getElephant(){
		return elephant;
	}
	public Integer getBulletMan(){
		return bulletman;
	}
	public Integer getMonsterFair(){
		return monsterfair;
	}
	/**
	 * @return
	 * @uml.property  name="color"
	 */
	public String getColor(){
		return color;
	}
}
