package card;

import board.City;

public interface TalentCard extends Card{
	
	public String getName(); // trivial
	public String getSalary(); // trivial
	public boolean isTalentRedLighting(); // Esto hay que aclararlo...
	public boolean isInUnemployment(); // Talento desempleado (los que se dejan en las ciudades)
	public City getCityOfUnemployment(); // Nos dirá la ciudad en la que está el talento

}
