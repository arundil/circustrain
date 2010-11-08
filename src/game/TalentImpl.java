package game;

/**
 * @author  marc
 */
public class TalentImpl implements Talent{
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="wage"
	 */
	private Integer wage;
	    
	public TalentImpl (String nam, Integer wage){
		name = nam;
		this.wage = wage;
	}
	 
	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName(){
		return name;
	}
	/**
	 * @return
	 * @uml.property  name="salary"
	 */
	public Integer getWage(){
		return wage; 
	}
}
