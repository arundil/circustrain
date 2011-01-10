package tipos;

import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class Cadenas {

	/**
	 * Divide la cadena str en subcadenas que son almacenadas en un vector. El
	 * par�metro delim es una cadena cuyos caracteres ser�n utilizados como
	 * separadores.
	 */
	public static List<String> separaElementos(String str, String delim) {
		List<String> v = new Vector<String>();
		StringTokenizer st = new StringTokenizer(str, delim);
		while (st.hasMoreTokens())
			v.add(st.nextToken());

		return v;
	}

	/**
	 * Divide la cadena str en subcadenas que son almacenadas en un vector. El
	 * par�metro delim es una cadena cuyos caracteres ser�n utilizados como
	 * separadores, que tambi�n ser�n incluidos en el vector devuelto.
	 */
	public static List<String> separaElementosDelimitadores(String str,
			String delim) {
		List<String> v = new Vector<String>();
		StringTokenizer st = new StringTokenizer(str, delim, true);
		while (st.hasMoreTokens())
			v.add(st.nextToken());

		return v;
	}

	public static String uneElementos(List<String> l, String d) {
		String s = "";
		for (String ss: l) {
			s += ss + d;
		}
		
		//System.out.println(s + " -- " + s.substring(0, s.length()-1));
		
		return s.substring(0, s.length());
	}
	
}
