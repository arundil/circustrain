package tipos;

public class unionFilter<T> implements Filter<T> {
	Filter<T> filter1;
	Filter<T> filter2;
	
	public unionFilter(Filter<T> filter1,Filter<T> filter2){
		this.filter1=filter1;
		this.filter2=filter2;
	}
	@Override
	public Boolean exp(T object) {
		return filter1.exp(object) && filter2.exp(object);
	}
}
