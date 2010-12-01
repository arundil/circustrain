package tipos;

public class reverseFilter<T> implements Filter<T> {
	Filter<T> filter;
	
	public reverseFilter(Filter<T> filter){
		this.filter=filter;
	}
	
	public Boolean exp(T object){
		return !filter.exp(object);
	}
}
