package utiles.factoria;

public class Container2<T1,T2> {
	
	private T1 t1;
	private T2 t2;
	
	public Container2(T1 t1, T2 t2){
		this.t1=t1;
		this.t2=t2;
	}
	
	public T1 getFirstValue(){
		return t1;
	}
	
	public T2 getSecondValue(){
		return t2;
	}
}
