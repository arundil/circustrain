package counter;

/**
 * @author  marc
 */
public class CounterImpl implements Counter{
	/**
	 * @uml.property  name="color"
	 */
	private String color;
//	private City city;
	
	public CounterImpl(String col){
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
