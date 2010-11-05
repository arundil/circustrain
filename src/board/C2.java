package board;


public class C2<T1> implements Comparable<C2<T1>> {
	private T1 a1, a2;

	
	public C2(T1 p1, T1 p2){
		a1=p1;
		a2=p2;
	}
	
	public T1 p1(){
		return a1;
	}
	public T1 p2(){
		return a2;
	}
	public void setP1(T1 b1){
		a1 = b1;
	}
	
    public void setP2(T1 b2){
		a2 = b2;
	}
	public boolean equals(Object o){
		Boolean r = false;
		if(o instanceof C2<?>){
			C2<?> o1 = (C2<?>)o;
			r = p1().equals(o1.p1()) && p2().equals(o1.p2());
		}
		return r;
	} 
	public int hashCode(){
		return p1().hashCode()*31+p2().hashCode();
	}
	public String toString(){
		return "("+p1()+","+p2()+")";
	}

	public int compareTo(C2<T1> p) {
		return hashCode()-p.hashCode();
	} 
	
	public boolean contains(T1 t) {
		return t.equals(a1) || t.equals(a2); 
	}

}
