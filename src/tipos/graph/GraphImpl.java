package tipos.graph;

import java.util.*;

import utiles.factoria.CollectionsFactory;


public class GraphImpl<A,V> implements Graph<A,V> {
	private Set<Vertex<V>> vertices = 
		CollectionsFactory.createSetFactory().createSet();
	private Set<Edge<A,V>> aristas = 
		CollectionsFactory.createSetFactory().createSet();
	private Map<Integer,Vertex<V>> codigoVertice = 
		CollectionsFactory.createMapFactory().createMap();
	private Map<A,Edge<A,V>> codigoArista = 
		CollectionsFactory.createMapFactory().createMap();
	private Map<C2<Vertex<V>>,Edge<A,V>> mapAristas = 
		CollectionsFactory.createMapFactory().createMap();
	
	
	public boolean add(Vertex<V> v) {
		boolean r = vertices.add(v);
		if (r)
			codigoVertice.put(v.getCode(),v);
		return r;
	}

	public boolean add(Edge<A,V> a) {
		boolean r = aristas.add(a);
		
		if (r == false)
			return r;
		
		codigoArista.put(a.getLabel(),a);
		vertices.add(a.getVertices().p1());
		vertices.add(a.getVertices().p2());
		
		if(a instanceof DirectedEdge<?,?>){
			DirectedEdge<A,V> a1 = (DirectedEdge<A,V>)a;
			mapAristas.put(new C2<Vertex<V>>(a1.getSource(),a1.getTarget()), a);
			a1.getSource().getAdjacents().add(a1.getTarget());
		}else {
			C2<Vertex<V>> l = a.getVertices();
			mapAristas.put(new C2<Vertex<V>>(l.p1(),l.p2()), a);
			mapAristas.put(new C2<Vertex<V>>(l.p2(),l.p1()), a);
			l.p1().getAdjacents().add(l.p2());
			l.p2().getAdjacents().add(l.p1());
		}		
		return r;
	}

	@SuppressWarnings("unchecked")
	public Edge<A,V> getEdge(Vertex v1, Vertex v2) {
		Edge<A,V> r =  (Edge<A,V>) mapAristas.get(new C2<Vertex<?>>(v1,v2));
		
		 if (r == null)
			 throw new java.util.NoSuchElementException("No edge between " + v1 + " and " + v2);
		
		return r;
	}

	public Vertex<V> getVertex(Integer label) {
		 Vertex<V> r = codigoVertice.get(label);
		 return r;
	}

	
	public Set<Edge<A,V>> getEdgeSet() {
		return aristas;
	}

	public Graph<A,V> getSubgraphWithoutEdge(Edge<A,V> a) {
		
		 if (this.aristas.contains(a) == false)
			 throw new java.util.NoSuchElementException("No edge " + a );
		
		 Graph<A,V> g = this.getSubGraph();
		 boolean b = g.remove(g.getEdge(a.getVertices().p1(), a.getVertices().p2()));
		 assert b;
		return g;
	}

	public Graph<A,V> getSubgraphWithoutVertex(Vertex<V> v) {
		 if (this.vertices.contains(v) == false)
			 throw new java.util.NoSuchElementException("No vertex " + v );

		 Graph<A,V> g = this.getSubGraph();
		 g.remove(g.getVertex(v.getCode())); 
		return g;
	}

	
	public Set<Vertex<V>> getVertexSet() {
		return vertices;
	}

	public boolean hasEdge(Vertex<V> v1, Vertex<V> v2) {
		 if (this.vertices.contains(v1) == false) 
			 throw new java.util.NoSuchElementException("No vertex " + v1 );

		 if (this.vertices.contains(v2) == false) 
			 throw new java.util.NoSuchElementException("No vertex " + v2 );
		 
		return v1.getAdjacents().contains(v2);
	}

	public boolean remove(Vertex<V> v) {
		Edge<A, V> e;
		boolean b;
		Vertex<V> r;
		
		if (!this.vertices.contains(v))
			return false;
		
		b = this.vertices.remove(v);
		assert b;
		
		r = this.codigoVertice.remove(v.getLabel());
		assert v.equals(r);
		
		for (Vertex<V> vAdj : this.vertices) {
			if (v.getAdjacents().contains(vAdj)) {
				e = this.getEdge(v, vAdj);
				this.aristas.remove(e);
				this.codigoArista.remove(e.getLabel());
				this.mapAristas.remove(new C2<Vertex<V>>(v, vAdj));
			}
			if (vAdj.getAdjacents().contains(v)) {
				e = this.getEdge(vAdj, v);
				this.aristas.remove(e);
				this.codigoArista.remove(e.getLabel());
				this.mapAristas.remove(new C2<Vertex<V>>(vAdj, v));
			}
			vAdj.getAdjacents().remove(v);
		}
		
		v.getAdjacents().clear();
		
		return true;
	}

	public boolean remove(Edge<A,V> a) {
		Vertex<V> v1, v2;
		boolean b;
		Edge<A,V> r;
		
		if (this.aristas.contains(a) == false)
			return false;
		
		v1 = a.getVertices().p1();
		v2 = a.getVertices().p2();
		
		this.aristas.remove(a);
		r = this.mapAristas.remove(new C2<Vertex<V>>(v1, v2));
		assert r.equals(a);
		
		r = this.codigoArista.remove(a.getLabel());
		assert r.equals(a);
		
		assert v1.getAdjacents().size() > 0;
		b = v1.getAdjacents().remove(v2);
		assert b;
		
		if (!(a instanceof DirectedEdge<?,?>)) {
			r = this.mapAristas.remove(new C2<Vertex<V>>(v2, v1));
			assert r.equals(a);
			
			assert v2.getAdjacents().size() > 0;
			b = v2.getAdjacents().remove(v1);
			assert b;
		}
		
		return true;
	}

	
	public String toString() {
		String s = "Vertices: " + this.vertices + "\nAristas (" + this.mapAristas.size() +
				"): " + this.aristas;
		return s;
	}
	

	public Graph<A, V> getSubGraph() {
		GraphImpl<A, V> g = new GraphImpl<A, V>();
		Vertex<V> v, v_adj;
		Edge<A, V> e;
		
		for (Vertex<V> vo: this.vertices) {
			v = new VertexImpl<V>(vo.getCode(), vo.getLabel() );
			g.vertices.add(v);
			g.codigoVertice.put(v.getCode(), v);
		}
		assert this.codigoVertice.size() == g.codigoVertice.size();
		
		for (Vertex<V> vo: this.vertices) {
			v = g.codigoVertice.get(vo.getCode());
			assert v != null;
			for (Vertex<V> vo_adj: vo.getAdjacents()) {
				v_adj = g.codigoVertice.get(vo_adj.getCode());
				assert v_adj != null;
				v.getAdjacents().add(v_adj);
			}
			assert v.getAdjacents().size() == vo.getAdjacents().size();
		}
		
		for (Edge<A, V> eo: this.aristas) {
			if (eo instanceof EdgeImpl<?,?>) {
				e = new EdgeImpl<A, V>(
						eo.getLabel(),
						g.codigoVertice.get(eo.getVertices().p1().getCode()),
						g.codigoVertice.get(eo.getVertices().p2().getCode())
						);
				
				g.aristas.add(e);
				g.codigoArista.put(e.getLabel(), e);

				g.mapAristas.put(e.getVertices(), e);
				g.mapAristas.put(new C2<Vertex<V>>(e.getVertices().p2(), e.getVertices().p1()), e);
			} else {
				e = new DirectedEdgeImpl<A, V>(
						eo.getLabel(),
						g.codigoVertice.get(eo.getVertices().p1()),
						g.codigoVertice.get(eo.getVertices().p2())
						);
				g.aristas.add(e);
				g.codigoArista.put(e.getLabel(), e);
				g.mapAristas.put(e.getVertices(), e);
				
			}
		}
		
		return g;
		
	}
	
}
