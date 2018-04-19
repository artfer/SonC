package sonc.quad;

import java.util.HashMap;
import java.util.Set;

class NodeTrie<T extends HasPoint> extends Trie<T>{
	
	HashMap<Quadrant,Trie<T>> nodes;

	protected NodeTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);
		nodes = new HashMap<>();
		// TODO Auto-generated constructor stub
		nodes.put(Quadrant.NW,new LeafTrie<>(topLeftX,topLeftY,centerX,centerY));
		nodes.put(Quadrant.NE,new LeafTrie<>(centerX,topLeftY,bottomRightX,centerY));
		nodes.put(Quadrant.SW,new LeafTrie<>(topLeftX,centerY,centerX,bottomRightY));
		nodes.put(Quadrant.SE,new LeafTrie<>(centerX,centerY,bottomRightX,bottomRightY));
	}

	@Override
	T find(T point) {
		// TODO Auto-generated method stub
		Quadrant quad = getQuadrant(point.getX(),point.getY());
		return nodes.get(quad).find(point);
	}

	@Override
	Trie<T> insert(T point) {
		// TODO Auto-generated method stub
		Quadrant quad = getQuadrant(point.getX(),point.getY());
		return nodes.get(quad).insert(point);
	}

	@Override
	Trie<T> insertReplace(T point) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	void collectNear(double x, double y, double radius, Set<T> points) {
		// TODO Auto-generated method stub
		
		
	}
	
	/*private int insideRadius(double x, double y, double radius) {
		radius*=radius;
		
		return pow(-x)+pow(-y);
	}*/
	
	private static double pow(double n) {
		return Math.pow(n, 2);
	}

	@Override
	void collectAll(Set<T> points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void delete(T point) {
		// TODO Auto-generated method stub
		Quadrant quad = getQuadrant(point.getX(),point.getY());
		nodes.get(quad).delete(point);
		
	}

}
