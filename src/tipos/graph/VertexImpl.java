package tipos.graph;

import java.util.*;


public class VertexImpl<V> implements Vertex<V> {
	private Set<Vertex<V>> vecinos;
	private V v;
	private Integer code;
	
	public VertexImpl(Integer code, V v) {
		this.code = code;
		vecinos = new java.util.HashSet<Vertex<V>>();
		this.v = v;
	}

	public Set<Vertex<V>> getAdjacents() {
		return vecinos;
	}

	public boolean hasAdjacents() {
		return !vecinos.isEmpty();
	}

	public boolean add(Vertex<V> e) {
		boolean r = vecinos.add(e);
		return r;
	}
	
	public boolean equals(Object e){
		// Compara por el codigo
		boolean r = false;
		if(e instanceof Vertex<?>) {
			Vertex<?> e1 = (Vertex<?>)e;
			r = code.equals(e1.getCode());
		}
        return r;
	}

	public int hashCode(){
		if (this.code != null)
			return this.code;
		return v.hashCode();
	}
	
	@SuppressWarnings("unchecked")
	public Vertex<V> clone(){
		Vertex<V> e = null;
		try {
			e =(Vertex<V>)super.clone();
		} catch (CloneNotSupportedException ex){
			
		}
		return e;
	}
	
	public String toString(){
		String s = this.code + ":" ;
		if (v != null)
			s += v.toString();
		s+="\n";
		return s;
	}
	
	public V getLabel() {
		return v;
	}

	public void setLabel(V l) {
		v = l;
	}

	public boolean remove(Vertex<V> v) {
		return vecinos.remove(v);
	}

	public Integer getCode() {
		return code;
	}
}
