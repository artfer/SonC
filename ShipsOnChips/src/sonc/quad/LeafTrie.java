package sonc.quad;

import java.util.HashSet;
import java.util.Set;

class LeafTrie<T extends HasPoint> extends Trie<T> {

	Set<T> points;
	
	LeafTrie(double topLeftX, double topLeftY,
			 double bottomRightX, double bottomRightY) {
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);
		// TODO Auto-generated constructor stub
		
		points = new HashSet<>();
		
	}

	@Override
	T find(T point) {
		// TODO Auto-generated method stub
		if(points.contains(point))
			return point;
		return null;
	}

	@Override
	Trie<T> insert(T point) {
		// TODO Auto-generated method stub
		
		if(points.size()<capacity) {
			points.add(point);
			return this;
		}
		Trie<T> node = new NodeTrie<T>(topLeftX,topLeftY,bottomRightX,bottomRightY);
		points.add(point);
		for(T p:points) node.insert(p);
		return node;
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

	@Override
	void collectAll(Set<T> points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void delete(T point) {
		// TODO Auto-generated method stub
		points.remove(point);
	}
	
	@Override
	public String toString(){
		return "("+topLeftX+";"+topLeftY+"),("+topLeftX+";"+topLeftY+")";
	}
}
