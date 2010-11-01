package game;

/**
 * @author  marc
 */
public class Talent {
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="salary"
	 */
	private Integer salary;
	    
	public Talent (String nam, Integer salar){
		name = nam;
		salary = salar;
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
	public Integer getSalary(){
		return salary; 
	}
}
