package tipos;

import java.util.Collection;

public  class CollectionsUtils {
	public  static <T> Integer count(Collection<T> c,Filter<T> f){
		Integer ocurrences=0;
		for(T object:c){
			if(f.exp(object)){
				ocurrences++;
			}
		}
		return ocurrences;
	}
}
