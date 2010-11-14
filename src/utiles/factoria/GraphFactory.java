package utiles.factoria;

import tipos.graph.*;

public class GraphFactory {
	
	protected GraphFactory(){}
	
	public  <E, V>Graph<E, V> createGraph(){	
			return new GraphImpl<E, V>();
	}
	

}
