package talent;

public class TalentImpl implements Comparable<Talent>, Talent {

	private Integer wage;

	public TalentImpl(Integer wage) {
		this.wage = wage;

	}

	public void setTalent(Integer w) {
		this.wage = w;
	}

	public Integer getWage() {
		return wage;
	}

	/*
	 * Este método devolverá el nombre de la interfaz (nombre del talento) que
	 * se vaya llamando desde las distintas interfaces, esto me servirá para
	 * hacer una simple llamada al toString de esta clase sin necesidad de crear
	 * uno para cada tipo de talento.
	 */
	public String getName() {
		Class<?>[] c = this.getClass().getInterfaces();
		return c[0].getSimpleName();

	}

	@Override
//	public String toString() {
//		return "Actualmente los " + this.getName() + " tienen salario: "
//				+ this.getWage();
//	}
	
	public String toString(){
		return this.getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wage == null) ? 0 : wage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res=false;
		if(this.getClass().equals(obj.getClass())){
			res=true;
		}
		return res;
	}

	@Override
	public int compareTo(Talent arg0) {
		return this.wage - arg0.getWage();
	}

}
