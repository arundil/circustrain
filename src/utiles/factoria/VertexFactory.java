package utiles.factoria;

public class VertexFactory{

	public <T>Vertex<T> createVertex(){
		return new VertexImpl<T>();
	}
}
