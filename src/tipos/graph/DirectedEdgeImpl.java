package tipos.graph;


public class DirectedEdgeImpl<A,V> 
extends EdgeImpl<A, V> 
implements DirectedEdge<A, V>
{
	
	public DirectedEdgeImpl(A a, Vertex<V> v1, Vertex<V> v2){
		super(a, v1, v2);
	}
	
	public boolean equals(Object e){
		boolean r = false;
		if(e instanceof DirectedEdge<?, ?>) {
			DirectedEdge<?,?> e1 = (DirectedEdge<?,?>)e;
			r = getLabel().equals(e1.getLabel());
			r = r && getVertices().p1().equals(e1.getVertices().p1());
			r = r && getVertices().p2().equals(e1.getVertices().p2());

		}
        return r;
	}
	
	public DirectedEdgeImpl<A,V>  clone() throws CloneNotSupportedException{
		DirectedEdgeImpl<A,V>  e = null;
		e =(DirectedEdgeImpl<A, V>)super.clone();
		return e;
	}
	
	public Vertex<V> getTarget() {
		return this.getVertices().p2();
	}

	public Vertex<V> getSource() {
			return this.getVertices().p1();
	}
	
}
