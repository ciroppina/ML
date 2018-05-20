package it.ciroppina.ml.knn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import it.ciroppina.util.StaticUtilities;

/**
 * see this article:
 * https://www.codeproject.com/Tips/1244325/An-Introduction-to-Basic-Algorithms-of-Machine-Lea
 * 
 */
public class StaticResourceLoader {
	final static String RESOURCE_NAME = "neighbors.properties";
	public static Properties neighbors;
	
	static {
		neighbors = new Properties();
		try {
			InputStream in = StaticResourceLoader.class
			.getResourceAsStream("/"+RESOURCE_NAME);

			neighbors.load(in);
			//TEST
			//System.out.println( "me=" + neighbors.getProperty("me") );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			neighbors = null;
		} catch (IOException e) {
			e.printStackTrace();
			neighbors = null;
		}
	}
	
	//Test
	/**
	 * Implements the k-Nearest-Neighbors algo (M.L.)
	 * 
	 * Loads properties and tries to compute distances from all neighbors to "me"
	 * @param args
	 */
	public static void main(String[] args) {
		new StaticResourceLoader(); //static loading properties from resource file
		Map<String, Double> allNeighbors = new TreeMap<String, Double>();
		
		//test
		String me = StaticResourceLoader.neighbors.getProperty("me");
		String[] meCoords = me.split(",");
		CartesianNeighbor neighbor =
			new CartesianNeighbor(meCoords[0], meCoords[1]);
		
		for (Object aNeighbor : StaticResourceLoader.neighbors.keySet() ) {
			String coords = StaticResourceLoader.neighbors.getProperty(aNeighbor.toString());
			String[] nbCoords = coords.split(",");
			double distance = neighbor.distance(Double.parseDouble(nbCoords[0]), Double.parseDouble(nbCoords[1]) );
			allNeighbors.put(aNeighbor.toString(), distance);
			//System.out.println(aNeighbor + " \tis distant: " + distance + " \tfrom me [" +me+ "]");
		}
		
		//sorting
		allNeighbors = StaticUtilities.sorter(allNeighbors);
		
		//console output
		for (String key : allNeighbors.keySet()) {
			System.out.println(key + " \tis distant: " + allNeighbors.get(key)
				+ " \tfrom me [" +me+ "]");
		}
	}
}
