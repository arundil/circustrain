package tipos.graph;
import java.util.*;

public interface Graph<A,V> {
	Set<Vertex<V>> getVertexSet();
	Set<Edge<A,V>> getEdgeSet();
	boolean add(Vertex<V> v);
	boolean add(Edge<A,V> a);
	boolean remove(Vertex<V> v);
	boolean remove(Edge<A,V> a);
	boolean hasEdge(Vertex<V> v1, Vertex<V> v2);
	Edge<A,V> getEdge(Vertex<V> v1, Vertex<V> v2);
	Graph<A,V> getSubgraphWithoutVertex(Vertex<V> v);
	Graph<A,V> getSubgraphWithoutEdge(Edge<A,V> a);
	Vertex<V> getVertex(Integer code);
	
	
}
