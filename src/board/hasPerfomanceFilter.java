package board;

import tipos.Filter;

public class hasPerfomanceFilter implements Filter<City> {

	@Override
	public Boolean exp(City object) {
		return object.hasPerfomance();
	}
}
