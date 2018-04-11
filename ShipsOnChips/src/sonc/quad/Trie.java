package sonc.quad;

import java.util.*;
import java.lang.*;

public abstract class Trie<T extends HasPoint>{
	protected double topLeftX;
	protected double topLeftY;
	protected double bottomRightX;
	protected double bottomRightY;
	static int capacity;
	
	protected Trie(double topLeftX,double topLeftY,
				   double bottomRightX,double bottomRightY) {
		this.topLeftX=topLeftX;
		this.topLeftY=topLeftY;
		this.bottomRightX=bottomRightX;
		this.bottomRightY=bottomRightY;
	}
	
	enum Quadrant { NE,NW,SE,SW }
	public static final Trie.Quadrant NE;
	public static final Trie.Quadrant NW;
	public static final Trie.Quadrant SE;
	public static final Trie.Quadrant SW;
	
	/**
	 * Get capacity of a bucket
	 * 
	 * @return capacity
	 */
	public static int getCapacity(){//what is a bucket?
		return capacity;
	}
	
	/**
	 * Set capacity of a bucket
	 * 
	 * @param capacity of bucket
	 */
	public static void setCapacity(int capacity) {//again...what is a bucket?
		Trie.capacity=capacity;
	}
	/**
	 * Find a recorded point with the same coordinates of given point
	 * 
	 * @param point with requested coordinates
	 * @return recorded point, if found; null otherwise
	 */
	abstract T find(T point);
	/**
	 * Insert given point
	 * 
	 * @param point to be insert
	 * @return changed parent node
	 */
	abstract Trie<T> insert(T point);
	/**
	 * Insert given point, replacing existing points in same location
	 * 
	 * @param point to be inserted
	 * @return changed parent node
	 */
	abstract Trie<T> insertReplace(T point);
	/**
	 * Collect points at a distance smaller or equal to radius from (x,y)
	 * and place them in given list
	 * 
	 * @param x coordinate of a point
	 * @param y coordinate of a point
	 * @param radius from given point
	 * @param points set of collecting points
	 */
	abstract void collectNear(double x, double y, double radius, T points);
	/**
	 * Collect all points in this node and its descendants in given set
	 * 
	 * @param points set of HasPoint for collecting points
	 */
	abstract void collectAll(T points);
	/**
	 * Deletes given point
	 * 
	 * @param point to delete
	 */
	abstract void delete(T point);
	/**
	 * Check if overlaps with given circle
	 * 
	 * @param x coordinate of circle
	 * @param y coordinate of circle
	 * @param radius of circle
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
	 * Euclidean distance between two pair of coordinates of two points
	 * 
	 * @param x1 x coordinate of first point
	 * @param y1 y coordinate of first point
	 * @param x2 x coordinate of second point
	 * @param y2 y coordinate of second point
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