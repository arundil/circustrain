package card;

/**
 * @author  marc
 */
public class CardImpl implements Card{
	/**
	 * @uml.property  name="name"
	 */
	private String name;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
	
	public CardImpl(String name, String des){
		this.name = name;
		description = des;
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
	 * @uml.property  name="description"
	 */
	public String getDescription(){
		return description;
	}

}
