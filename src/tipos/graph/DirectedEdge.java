package tipos.graph;


// Esta interfaz tiene que tener su propia instancia, porque si no
// no funciona el instaceof del grafo


public interface DirectedEdge<A,V> extends Edge<A,V> {
	Vertex<V> getSource();
	Vertex<V> getTarget();
}
