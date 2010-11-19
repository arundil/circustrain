package board;

import java.util.Set;


import performance.Performance;

public class CityImpl implements City {
	
	private Boolean isCanada;
	private Performance performance;
	private String name;
	
	public CityImpl(String name,Boolean isCanada){
		this.name=name;
		this.isCanada=isCanada;
		this.performance=null;
	}

	@Override
	public Boolean isCanada() {
		return this.isCanada;
	}

	@Override
	public Performance getPerformance() {
		return this.performance;
	}

	@Override
	public Boolean hasPerfomance() {
		return this.performance.equals(null);
	}


	@Override
	public void setPerfomance(Performance performance) {
		this.performance=performance;

	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public Set<City> exactMovement(Integer jump) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<City> maxMovement(Integer jump) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}
}