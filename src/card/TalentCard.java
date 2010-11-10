package card;

import board.City;

public interface TalentCard extends Card{
	
	public String getName();
	public int getSalary();
	public boolean isInBankruptCircus(); 
	// Talento sin empleo (los que se dejan en las ciudades)
	
	public City getCityOfBankruptCircus(); 
	// Nos podría decir la ciudad en la que está el talento o hacerlo desde el "main".

}
