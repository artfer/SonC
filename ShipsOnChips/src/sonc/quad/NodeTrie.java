package sonc.quad;

import java.util.HashMap;
import java.util.Set;

/**
 * {@link Trie} with 4 sub tries with equal dimensions covering all its area. 
 * This class corresponds to the <i>Composite</i> in the <i>Composite</i> design pattern.
 */
class NodeTrie<T extends HasPoint> extends Trie<T>{
	
	HashMap<Quadrant,Trie<T>> nodes;

	protected NodeTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);
		nodes = new HashMap<>();
		nodes.put(Quadrant.NW,new LeafTrie<>(topLeftX,topLeftY,centerX,centerY));
		nodes.put(Quadrant.NE,new LeafTrie<>(centerX,topLeftY,bottomRightX,centerY));
		nodes.put(Quadrant.SW,new LeafTrie<>(topLeftX,centerY,centerX,bottomRightY));
		nodes.put(Quadrant.SE,new LeafTrie<>(centerX,centerY,bottomRightX,bottomRightY));
	}

	
	@Override
	T find(T point) {
		Quadrant quad = getQuadrant(point.getX(),point.getY());
		return nodes.get(quad).find(point);
	}

	
	@Override
	Trie<T> insert(T point) {
		Quadrant quad = getQuadrant(point.getX(),point.getY());
		return nodes.get(quad).insert(point);
	}

	
	@Override
	Trie<T> insertReplace(T point) {
		return null;
	}

	
	@Override
	void collectNear(double x, double y, double radius, Set<T> points) {
		
	}
	
	
	@Override
	void collectAll(Set<T> points) {
		
	}

	@Override
	void delete(T point) {
		Quadrant quad = getQuadrant(point.getX(),point.getY());
		nodes.get(quad).delete(point);
	}
	
	
	
	/*private int insideRadius(double x, double y, double radius) {
	radius*=radius;
	
	return pow(-x)+pow(-y);
}*/
/*
private static double pow(double n) {
	return Math.pow(n, 2);
}
*/
}
