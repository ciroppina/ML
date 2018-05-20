package it.ciroppina.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class StaticUtilities {
	
	/**
	 * see: https://www.mkyong.com/java8/java-8-how-to-sort-a-map/
	 * 
	 * @param allNeighbors
	 * @return
	 */
	public static Map<String, Double> sorter(Map<String, Double> allNeighbors) {
		
		Map<String, Double> sortedMap = new LinkedHashMap<>();
        allNeighbors.entrySet().stream()
        	.sorted(Map.Entry.<String, Double>comparingByValue() //.reversed() == DESCENDING 
        	).forEachOrdered(x -> sortedMap .put( x.getKey(), x.getValue() ) );
        
		return sortedMap;
	}
	
	// ADD MORE UTILITIES BELOW

}
