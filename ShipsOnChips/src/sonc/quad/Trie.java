package sonc.quad;

import java.util.Set;



/**
 * Abstract class common to all classes implementing the <i>trie</i> structure. 
 * Defines methods required by those classes and provides general methods for checking overlaps and computing distances. 
 * This class corresponds to the <b>Component</b> in the <b>Composite</b> design pattern.
 */
public abstract class Trie<T extends HasPoint>{
	
	protected double topLeftX;
	protected double topLeftY;
	protected double bottomRightX;
	protected double bottomRightY;
	protected double centerX;
	protected double centerY;
	static int capacity;
	
	
	protected Trie(double topLeftX,double topLeftY,
				   double bottomRightX,double bottomRightY) {
		this.topLeftX=topLeftX;
		this.topLeftY=topLeftY;
		this.bottomRightX=bottomRightX;
		this.bottomRightY=bottomRightY;
		
		this.centerX = (topLeftX + bottomRightX)/2;
		this.centerY = (topLeftY + bottomRightY)/2;
	}
	
	public enum Quadrant { NE,NW,SE,SW }
	
	Quadrant getQuadrant(double x, double y){
		if(x<topLeftX || x>bottomRightX || y<bottomRightY || y>topLeftY)
			return null;
		if(y<=centerY && x<=centerX)		return Quadrant.SW;
		else if(y<=centerY && x>=centerX) 	return Quadrant.SE;
		else if(y>=centerY && x<=centerX)	return Quadrant.NW;
		else if(y>=centerY && x>=centerX)	return Quadrant.NE;
		return null;
	}
	
	
	/**
	 * Get capacity of a bucket.
	 * 
	 * @return capacity
	 */
	public static int getCapacity(){
		return capacity;
	}
	
	
	/**
	 * Set capacity of a bucket.
	 * 
	 * @param capacity of bucket
	 */
	public static void setCapacity(int capacity) {
		Trie.capacity=capacity;
	}
	
	
	/**
	 * Find a recorded point with the same coordinates of given point.
	 * 
	 * @param point with requested coordinates
	 * 
	 * @return recorded point, if found; null otherwise
	 */
	abstract T find(T point);
	
	
	/**
	 * Insert given point.
	 * 
	 * @param point to be inserted
	 * 
	 * @return changed parent node
	 */
	abstract Trie<T> insert(T point);
	
	
	/**
	 * Insert given point, replacing existing points in same location.
	 * 
	 * @param point to be inserted
	 * 
	 * @return changed parent node
	 */
	abstract Trie<T> insertReplace(T point);
	
	
	/**
	 * Collect points at a distance smaller or equal to radius from (x,y)
	 * and place them in given list.
	 * 
	 * @param x coordinate of a point
	 * @param y coordinate of a point
	 * @param radius from given point
	 * @param points set of collecting points
	 */
	abstract void collectNear(double x, double y, double radius, Set<T> points);
	
	
	/**
	 * Collect all points in this node and its descendants in given set.
	 * 
	 * @param points set of {@link HasPoint} for collecting points
	 */
	abstract void collectAll(Set<T> points);
	
	
	/**
	 * Deletes given point.
	 * 
	 * @param point to delete
	 */
	abstract void delete(T point);
	
	
	/**
	 * Check if overlaps with given circle.
	 * 
	 * @param x coordinate of circle
	 * @param y coordinate of circle
	 * @param radius of circle
	 * 
	 * @return true if overlaps and false otherwise
	 */
	boolean overlaps(double x, double y, double radius) {
		double distanceTopLeft=getDistance(x,y,topLeftX,topLeftY);
		double distanceBottomRight=getDistance(x,y,bottomRightX,bottomRightY);
		if(distanceTopLeft<=radius || distanceBottomRight<=radius)
			return true;
		return false;
	}
	
	
	@Override
	public String toString(){
		return "("+topLeftX+";"+topLeftY+"),("+topLeftX+";"+topLeftY+")";
	}
	/**
	 * Euclidean distance between two pair of coordinates of two points.
	 * 
	 * @param x1 - x coordinate of first point
	 * @param y1 - y coordinate of first point
	 * @param x2 - x coordinate of second point
	 * @param y2 - y coordinate of second point
	 * 
	 * @return distance between given point
	 */
	public static double getDistance(double x1, double y1,double x2,double y2) {
		return sqrt(pow((x2-x1))+pow((y2-y1)));
	}
	
	
	//auxiliary methods to improve readability
	private static double pow(double n) {
		return Math.pow(n, 2);
	}
	
	private static double sqrt(double n) {
		return Math.sqrt(n);
	}
}