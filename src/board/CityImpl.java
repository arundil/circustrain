package board;

import java.util.Collection;
import java.util.Set;

import Graph.Vertex;
import Graph.VertexImpl;

import performance.Performance;
import utiles.factoria.CollectionsFactory;

public class CityImpl extends VertexImpl implements City {
	
	private Boolean isCanada;
	private Performance performance;
	
	public CityImpl(String name,Boolean isCanada){
		super(name);
		this.isCanada=isCanada;
		this.performance=null;
	}
	@Override
	public Set<City> exactMovement(Integer jump) {
		Set<City> neighborCities=CollectionsFactory.createSetFactory().createSet();
		Set<City> citiesToMove=CollectionsFactory.createSetFactory().createSet();
		if(jump==1){
			citiesToMove=(Set<City>) this.getAdjacents();
		}else{
			neighborCities=(Set<City>) this.getAdjacents();
			
			for(City c:neighborCities){
				citiesToMove.addAll(c.exactMovement(jump));
			}
		}
		return citiesToMove;
	}

	@Override
	public Boolean getCanada() {
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
	public Set<City> maxMovement(Integer jump) {
		Set<City> neighborCities=CollectionsFactory.createSetFactory().createSet();
		Set<City> citiesToMove=CollectionsFactory.createSetFactory().createSet();
		if(jump==1){
			citiesToMove=(Set<City>) this.getAdjacents();
		}else{
			neighborCities=(Set<City>) this.getAdjacents();
			
			for(City c:neighborCities){
				citiesToMove.addAll((Set<City>) this.getAdjacents());
				citiesToMove.addAll(c.exactMovement(jump));
			}
		}
		return citiesToMove;
	}

	
	@Override
	public void setPerfomance(Performance performance) {
		this.performance=performance;

	}

	@Override
	public String toString() {
		return getName();
	}
	
	
	
}