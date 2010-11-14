package utiles.factoria;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListFactory {

	 Integer initCapacity = null;
	 Boolean nullNotAllowed = false;
	 Boolean randomAccess = false;
	 Boolean check = false;
	
	protected ListFactory(){}
	
	
	public ListFactory initCapacity(Integer i){
		this.initCapacity = i;
		return this;
	}
	
	public ListFactory nullNotAllowed(){
		this.nullNotAllowed = true;
		return this;
	}
	
	public ListFactory randomAccess(){
		this.randomAccess = true;
		return this;
	}
	
	public ListFactory checkSemantic(){
		this.check = true;
		return this;
	}

	
	//--- Creators ---------------------------------------
	
	public  <E>List<E> createList(){	
		if ((check) || (nullNotAllowed)) {
			throw new DataStructureNotSupportedException("No checkSemantic nor null check.");
		}
		
		if (this.initCapacity != null) {
			return new ArrayList<E>(this.initCapacity);
		}
			
		if (this.randomAccess) {
			return new ArrayList<E>();
		}
			
		//-- LinkedList
			
		return new LinkedList<E>();
	}
	
	public  <E>List<E> unmodifiableInv(List<E> l) {
		return java.util.Collections.unmodifiableList(l);
	}

	public  <E>List<E> synchronizedInv(List<E> l) {
		throw new UnsupportedOperationException();
	}

}
