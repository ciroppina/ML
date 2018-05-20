package it.ciroppina.ml.knn;

public class CartesianNeighbor implements DataType {

	private final String TYPE = "cartesian"; 
	public String getType() {
		return this.TYPE;
	}
	
	// constructors
	/**
	 * initialzes "me" w/doubles
	 * 
	 * @param cx
	 * @param cy
	 */
	CartesianNeighbor (double cx, double cy) {
		this.x = cx; this.y = cy;
	}
	
	/**
	 * initialzes "me" w/Strings
	 * 
	 * @param cx
	 * @param cy
	 */
	CartesianNeighbor (String cx, String cy) {
		this.x = Double.parseDouble(cx); 
		this.y = Double.parseDouble(cy); 
	}

	/**
	 * tjis is "me"
	 */
	double x, y;
	/**
	 * computes the cartesian distance, by applying Pitagora
	 */
	public double distance(double x0, double y0) {
		double result = 0;
		double deltax = x - x0;
		double deltay = y - y0;
		result = Math.sqrt(deltax*deltax + deltay*deltay);

		return result;
	}

}
