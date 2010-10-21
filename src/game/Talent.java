package game;

public class Talent {
	private String name;
	private Integer salary;
	
	public Talent (String nam, Integer salar){
		name = nam;
		salary = salar;
	}
	 
	public String getName(){
		return name;
	}
	public Integer getSalary(){
		return salary; 
	}
}
