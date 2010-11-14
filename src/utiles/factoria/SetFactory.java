package utiles.factoria;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetFactory {

	 Integer initCapacity = null;
	 Boolean nullNotAllowed = false;
	 Boolean insertOrder = false;
	 Boolean check = false;
	 Comparator order = null;
	
	protected SetFactory(){}
	
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public SetFactory initCapacity(Integer i){
		this.initCapacity = i;
		return this;
	}
	
	/**
	 * 
	 * @param <E>
	 * @param c
	 * @return
	 */
	public <E> SetFactory order(Comparator<E> c) {
		this.order = c;
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public SetFactory nullNotAllowed(){
		this.nullNotAllowed = true;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public SetFactory checkSemantic(){
		this.check = true;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public SetFactory insertOrder(){
		this.insertOrder = true;
		return this;
	}

	//--- Creators ---------------------------------------

	/**
	 * 
	 */
	public  <E>Set<E> createSet(){	
		if ((check) || (nullNotAllowed)) {
			throw new DataStructureNotSupportedException("No checkSemantic nor null check.");
		}
		if (this.initCapacity != null) {
			return new HashSet<E>(this.initCapacity);
		}
		if (this.insertOrder) {
			return new LinkedHashSet<E>();
		}
		
		return new HashSet<E>();
	}
	
	
	public <E>SortedSet<E> createSortedSet() {
		return (SortedSet<E>)this.createNavigableSet();
	}
	

	public <E>NavigableSet<E> createNavigableSet() {
		if (this.order == null)
			return new TreeSet<E>();
		return new TreeSet<E>(this.order);
	}


	public  <E>Set<E> unmodifiableInv(Set<E> l) {
		return java.util.Collections.unmodifiableSet(l);
	}


	public  <E>Set<E> synchronizedInv(Set<E> l) {
		throw new UnsupportedOperationException();
	}

}
