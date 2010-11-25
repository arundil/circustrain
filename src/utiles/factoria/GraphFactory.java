package utiles.factoria;

public class GraphFactory {
	public <T>Graph<T> createGraph(){
		return new GraphImpl<T>();
	}
}
