package tipos;

import java.util.Collection;
import java.util.List;

import utiles.factoria.CollectionsFactory;

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
	
	public static <T> List<T> filteredList(Collection<T> c,Filter<T> f){
		List<T> listToReturn=CollectionsFactory.createListFactory().createList();
		for(T object:c){
			if(f.exp(object)){
				listToReturn.add(object);
			}
		}
		return listToReturn;
	}
}
