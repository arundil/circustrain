package board;

import Graph.GraphImpl;
import Graph.Vertex;

public class BoardImpl extends GraphImpl implements Board {
	
	public BoardImpl(){
		super();
	}
	
	public void addCity(City c){
		super.addVertex((Vertex) c);
	}
	

}
