package board;

import tipos.graph.C2;
import tipos.graph.EdgeImpl;
import tipos.graph.Vertex;


public class TrackImpl extends EdgeImpl<String,City> implements
		tipos.graph.Edge<String, City> {

	public TrackImpl(String a, Vertex<City> v1, Vertex<City> v2) {
		super(a, v1, v2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public C2<Vertex<City>> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

}
