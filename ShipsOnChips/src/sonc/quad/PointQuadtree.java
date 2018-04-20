package sonc.quad;

import java.util.Set;

public class PointQuadtree<T extends HasPoint> {

	NodeTrie<T> root;
	
	PointQuadtree(double topLeftX,double topLeftY,double bottomRightX,double bottomRightY){
		super();
		root = new NodeTrie<>(topLeftX,topLeftY,bottomRightX,bottomRightY);
	}
	
	
	/**
	 * Find a recorded point with the same coordinates of given point.
	 * 
	 * @param point - with request coordinates
	 * @return point , if found; null otherwise
	 */
	public T find(T point) {
		return root.find(point);
	}
	
	
	/**
	 * Insert given point in the QuadTree
	 * 
	 * @param point - to be inserted
	 */
	public void insert(T point) {
		root.insert(point);
	}
	
	
	/**
	 * Insert point, replacing existing point in the same position
	 * 
	 * @param point - to be inserted
	 */
	public void insertReplace(T point) {
		root.insertReplace(point);
	}
	
	
	/**
	 * Returns a set of points at a distance smaller or equal to radius from point with given coordinates.
	 * 
	 * @param x - coordinate of point
	 * @param y - coordinate of point
	 * @param radius - from given point
	 * 
	 * @return set of instances of type {@link HasPoint}
	 */
	public Set<T> findNear(double x,double y,double radius){
		return root.findNear(x,y,radius);
	}
	
	
	/**
	 * Delete given point from QuadTree, if it exists there.
	 * 
	 * @param point - to be deleted
	 */
	public void delete(T point) {
		root.delete(point);
	}
	
	/**
	 * A set with all points in the QuadTree.
	 * 
	 * @return set of instances of type {@link HasPoint}
	 */
	public Set<T> getAll(){
		return ;
	}
	
	
}
