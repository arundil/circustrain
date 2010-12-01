package board;

import java.util.List;
import java.util.Set;


import performance.Performance;
import utiles.factoria.CollectionsFactory;
import utiles.factoria.Vertex;
import utiles.factoria.VertexImpl;

public class CityImpl extends VertexImpl implements City {
	
	private Boolean isCanada;
	private Performance performance;
	private String name;
	
	public CityImpl(String name,Boolean isCanada){
		super();
		this.name=name;
		this.isCanada=isCanada;
		this.performance=null;
	}
	
	public CityImpl(String name,String isCanada){
		this(name, new Boolean(isCanada));
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityImpl other = (CityImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public List<City> getCitiesAdjacents(){
		List<City> cities=CollectionsFactory.createListFactory().createList();
		
		for(Vertex v:getAdjacents()){
			City c=(City)v;
			cities.add(c);
		}
		return cities;
	}
	
}