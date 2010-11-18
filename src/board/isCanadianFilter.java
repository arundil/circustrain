package board;

import tipos.Filter;

public class isCanadianFilter implements Filter<City> {
	public Boolean exp(City object) {
		return object.isCanada().equals(true);
	}

}
