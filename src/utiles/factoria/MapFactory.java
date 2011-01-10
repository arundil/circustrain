package utiles.factoria;


import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapFactory {

	 Integer initCapacity = null;
	 Boolean nullNotAllowed = false;
	 Boolean insertOrder = false;
	 Boolean check = false;
	 Float loadFactor = null;
	 Comparator order = null;
	
	protected MapFactory(){}
	
	
	public MapFactory initCapacity(Integer i){
		this.initCapacity = i;
		return this;
	}
	
	public MapFactory nullNotAllowed(){
		this.nullNotAllowed = true;
		return this;
	}
	
	public MapFactory insertOrder(){
		this.insertOrder = true;
		return this;
	}
	
	public MapFactory checkSemantic(){
		this.check = true;
		return this;
	}

	public MapFactory loadFactor(Float f) {
		this.loadFactor = f;
		return this;
	}
	
	public <E>MapFactory order(Comparator<E> c) {
		this.order = c;
		return this;
	}

	

	public  <E, V>Map<E, V> createMap(){	
		if ((check) || (nullNotAllowed)) {
			throw new DataStructureNotSupportedException("No checkSemantic nor null check.");
		}
		
		if (this.insertOrder) {
			if (this.initCapacity != null) {
				if (this.loadFactor == null)
					return new LinkedHashMap<E, V>(this.initCapacity);
				else
					return new LinkedHashMap<E, V>(this.initCapacity, this.loadFactor);
			}
		}

		if (this.initCapacity != null) {
			if (this.loadFactor == null)
				return new HashMap<E, V>(this.initCapacity);
			else
				return new HashMap<E, V>(this.initCapacity, this.loadFactor);
		}

		
		
		return new HashMap<E, V>();
	}
	

	public  <E, V>Map<E, V> unmodifiableInv(Map<E,V> l) {
		return java.util.Collections.unmodifiableMap(l);
	}

	public  <E, V>Map<E, V> synchronizedInv(Map<E, V> l) {
		return java.util.Collections.synchronizedMap(l);
	}
	
	public <E, V>SortedMap<E, V> createSortedMap() {
		return (SortedMap<E, V>)this.createNavigableMap();
	}
	

	public <E, V>NavigableMap<E, V> createNavigableMap() {
		if (this.order == null)
			return new TreeMap<E, V>();
		return new TreeMap<E, V>(this.order);
	}


}
