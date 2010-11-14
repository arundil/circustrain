package tipos.graph;

public class EdgeImpl<A,V> implements Edge<A,V>
{
	private C2<Vertex<V>> sv;
	private A info;
	
	public EdgeImpl(A a, Vertex<V> v1, Vertex<V> v2){
		sv = new C2<Vertex<V>>(v1, v2);
		info = a;
	}
	@SuppressWarnings("unchecked")
	public boolean equals(Object e){
		boolean r = false;
		if(e instanceof Edge<?, ?>) {
			EdgeImpl<A,V> e1 = (EdgeImpl<A,V>)e;
			r = info.equals(e1.getLabel());
			r = r && sv.contains(e1.sv.p1());
			r = r && sv.contains(e1.sv.p2());
			
		}
        return r;
	}
	
	
	public int hashCode(){
		return info.hashCode();
	}
	
	@SuppressWarnings("unchecked")
	public EdgeImpl<A,V>  clone() throws CloneNotSupportedException{
		EdgeImpl<A,V>  e = null;
		try {
			e =(EdgeImpl<A, V>)super.clone();
		} catch (CloneNotSupportedException ex){
			
		}
		return e;
	}
	
	public String toString(){
		return info.toString() + " ("+this.sv.p1().getCode()+"," +this.sv.p2().getCode()+ ")\n";
	}


	public C2<Vertex<V>> getVertices() {
		return new C2<Vertex<V>>(sv.p1(), sv.p2());
	}

	public A getLabel() {
		return info;
	}

	
}
