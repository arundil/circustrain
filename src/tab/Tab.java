package tab;

/**
 * @author  marc
 */
public class Tab {
	/**
	 * @uml.property  name="color"
	 */
	private String color;
//	private City city;
	
	public Tab(String col){
		color = col;
//		City = ???;
	}
	
	/**
	 * @return
	 * @uml.property  name="color"
	 */
	public String getColor(){
		return color;
	}
	
//	public City getCity(){
//		return city;
//	}
	
//	public void setCity(City cit){
//		city = cit;
//	}
}
