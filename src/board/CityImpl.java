package board;

import java.util.Set;

import performance.Performance;
import tipos.graph.VertexImpl;

public class CityImpl extends VertexImpl<String> implements City {
	
	private Boolean isCanada;
	private Performance performance;

	public CityImpl(Integer code,String name,Boolean isCanada){
		super(code, name);
		this.isCanada=isCanada;
		this.performance=null;
	}
	@Override
	public Set<City> exactMovement(Integer jump) {
		return null;
	}

	@Override
	public Boolean getCanada() {
		return this.isCanada;
	}

	@Override
	public String getName() {
		return super.getLabel();
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
	public Set<City> maxMovement(Integer jump) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void setPerfomance(Performance performance) {
		this.performance=performance;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}





}
