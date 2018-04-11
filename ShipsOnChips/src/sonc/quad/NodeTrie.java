package sonc.quad;

class NodeTrie<T extends HasPoint> extends Trie<T>{

	protected NodeTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);
		// TODO Auto-generated constructor stub
	}

	@Override
	T find(T point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Trie<T> insert(T point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Trie<T> insertReplace(T point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void collectNear(double x, double y, double radius, T points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void collectAll(T points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void delete(T point) {
		// TODO Auto-generated method stub
		
	}

}
