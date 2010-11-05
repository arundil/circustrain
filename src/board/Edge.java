package board;


public interface Edge<A,V> {
	C2<Vertex<V>> getVertices();
	A getLabel();
}
