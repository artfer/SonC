package sonc.quad;

import java.util.HashSet;
import java.util.Set;


/**
 * A {@link Trie} that has no descendants. 
 * This class corresponds to the <b>Leaf</b> in the <b>Composite</b> design pattern.
 */
class LeafTrie<T extends HasPoint> extends Trie<T> {

	Set<T> points;
	
	LeafTrie(double topLeftX, double topLeftY,
			 double bottomRightX, double bottomRightY) {
		
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);
		
		points = new HashSet<>();
	}

	
	@Override
	T find(T point) {
		if(points.contains(point))
			return point;
		return null;
	}

	
	@Override
	Trie<T> insert(T point) {
		if(points.size()<capacity) {
			points.add(point);
			return this;
		}
		NodeTrie<T> node = new NodeTrie<T>(topLeftX,topLeftY,bottomRightX,bottomRightY);
		node.insert(point);
		for(T p : points) {
			node.insert(p);
		}
		return node;
	}

	@Override
	Trie<T> insertReplace(T point) {
		for(T p : points) 
			if(p.getX()==point.getX() && p.getY()==point.getY()) {
				points.remove(p);
				points.add(point);
				return this;
		}
		return null;
	}

	@Override
	void collectNear(double x, double y, double radius, Set<T> points) {
		for(T p : this.points)
			if(getDistance(p.getX(),p.getY(),x,y)<=radius)
				points.add(p);
	}

	@Override
	void collectAll(Set<T> points) {
		for(T p : this.points)
			points.add(p);
	}

	
	@Override
	void delete(T point) {
		points.remove(point);
	}
	
	@Override
	public String toString(){
		return "("+topLeftX+";"+topLeftY+"),("+topLeftX+";"+topLeftY+")";
	}
}
