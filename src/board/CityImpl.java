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
	private Boolean hasPerformance;
	private String name;
	
	public CityImpl(String name,Boolean isCanada){
		super();
		this.name=name;
		this.isCanada=isCanada;
		this.performance=null;
		this.hasPerformance=false;
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
		return this.hasPerformance;
		
	}


	@Override
	public void setPerfomance(Performance performance) {
		this.performance=performance;
		this.hasPerformance=true;

	}

	@Override
	public String toString() {
		String stringToPrint;
		stringToPrint = this.getName();
		if(this.hasPerfomance()){
			stringToPrint = "\n"+stringToPrint+" (" + this.getPerformance().toString()+") ";
		}
		return stringToPrint;
	}

	private Set<Vertex> exactMovementSet(Integer jump) {
		Set<Vertex> vertices=CollectionsFactory.createSetFactory().createSet();
		if(jump==1){
			return getAdjacents();
		}else{
			for(Vertex v:getAdjacents()){
				City c=(City)v;
				
				vertices.addAll(c.exactMovement(jump-1));
			}
		}
		return vertices;
	}
	
	public List<City> exactMovement(Integer jump){
		Set<Vertex> vertices=exactMovementSet(jump);
		List<City> cities=CollectionsFactory.createListFactory().createList();
		for(Vertex v:vertices){
			City c=(City)v;
			cities.add(c);
		}
		return cities;
	}

	@Override
	public List<City> maxMovement(Integer jump) {
		Set<Vertex> vertices=CollectionsFactory.createSetFactory().createSet();
		List<City> cities=CollectionsFactory.createListFactory().createList();
		for(int i=jump;i>0;i--){
			vertices.addAll(exactMovement(i));
		}
		for(Vertex v:vertices){
			City c=(City)v;
			cities.add(c);
		}
		return cities;
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

	@Override
	public void removePerformance() {
		this.performance=null;
		this.hasPerformance=false;
		
	}
	
}