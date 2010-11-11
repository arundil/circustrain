package bag;

import java.util.Map;

import card.TypeTalentCard;

public interface TalentBag extends TypeTalentCard{
	
	public Map<TypeTalentCard,Integer> createTalentBag(); 
	// A discutir si creamos factorías para muchas de las bolsas.
	
	
	/*
	 * Todos devuelven TypeTalentCard por si resulta útil mostrar por pantalla
	 * cada vez que se modifica (añade, sustrae) la bolsa de talentos.
	 */
	public Integer getNumTypeTalentCard();
	public TypeTalentCard removeTypeTalentCard(TypeTalentCard t);
	public TypeTalentCard addTypeTalentCard(TypeTalentCard t); // si se hace al azar, sería sin param.

}