package utiles.factoria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFile {
	public static BufferedReader readTextFile(String name) throws FileNotFoundException{
		FileReader fr;
		BufferedReader bf = null;

			fr = new FileReader(name);
			bf = new BufferedReader(fr);


		return bf;
		
	}
}
