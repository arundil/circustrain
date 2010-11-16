package board;

import java.util.Set;

import Graph.GraphImpl;
import Graph.Vertex;

public class BoardImpl extends GraphImpl implements Board {
	
	public BoardImpl(){
		super();
		
	}

	@Override
	public Set<City> getCities() {
		return (Set<City>) this.getVertexSet();
	}

	@Override
	public City getCityByName(String name) {
		
		for(City c:(Set<City>)this.getVertexSet()){
			if(c.getName().equals(name)){
				return c;
			}
		}
		return null;
	}

	

}
