package sonc.quad;

abstract class Trie {
	private int MAX_OBJECTS=1;	//objects per quadrant
	private int MAX_LEVELS;		//show it have a limit?
		
	private int level;
	private List objects;
	private Quad bounds;
	private Trie[] nodes;
	
	/*
	 * Constructor
	 */
	public Trie(int pLevel, Quad pBounds) {
		level = pLevel;
		objects = new ArrayList();
		bounds = pBounds;
		nodes = new Trie[4];
	}
	/*
	 * Splits the node into 4 subnodes
	 */
	private void split() {
		int subWidth = (int)(bounds.getWidth() / 2);
		int subHeight = (int)(bounds.getHeight() / 2);
		int x = (int)bounds.getX();
		int y = (int)bounds.getY();
	 
		nodes[0] = new Trie(level+1, new Quad(x + subWidth, y, subWidth, subHeight));
		nodes[1] = new Trie(level+1, new Quad(x, y, subWidth, subHeight));
		nodes[2] = new Trie(level+1, new Quad(x, y + subHeight, subWidth, subHeight));
		nodes[3] = new Trie(level+1, new Quad(x + subWidth, y + subHeight, subWidth, subHeight));
	 }
	 
	 /*
	  * Clears the quadtree
	  */
	public void clear() {
		objects.clear();
	  
	    for (int i = 0; i < nodes.length; i++) {
	      if (nodes[i] != null) {
	        nodes[i].clear();
	        nodes[i] = null;
	      }
	    }
	}
	  
	  /*
	   * Determine which node the object belongs to. -1 means
	   * object cannot completely fit within a child node and is part
	   * of the parent node
	   */
	   private int getIndex(Quad pQuad) {
	     int index = -1;
	     double verticalMidpoint = bounds.getX() + (bounds.getWidth() / 2);
	     double horizontalMidpoint = bounds.getY() + (bounds.getHeight() / 2);
	   
	     // Object can completely fit within the top quadrants
	     boolean topQuadrant = (pQuad.getY() < horizontalMidpoint && pQuad.getY() + pQuad.getHeight() < horizontalMidpoint);
	     // Object can completely fit within the bottom quadrants
	     boolean bottomQuadrant = (pQuad.getY() > horizontalMidpoint);
	   
	     // Object can completely fit within the left quadrants
	     if (pQuad.getX() < verticalMidpoint && pQuad.getX() + pQuad.getWidth() < verticalMidpoint) {
	        if (topQuadrant) {
	          index = 1;
	        }
	        else if (bottomQuadrant) {
	          index = 2;
	        }
	      }
	      // Object can completely fit within the right quadrants
	      else if (pQuad.getX() > verticalMidpoint) {
	       if (topQuadrant) {
	         index = 0;
	       }
	       else if (bottomQuadrant) {
	         index = 3;
	       }
	     }
	   
	     return index;
	   }
	   
	   /*
	    * Insert the object into the quadtree. If the node
	    * exceeds the capacity, it will split and add all
	    * objects to their corresponding nodes.
	    */
	    public void insert(Quad pQuad) {
	      if (nodes[0] != null) {
	        int index = getIndex(pQuad);
	    
	        if (index != -1) {
	          nodes[index].insert(pQuad);
	    
	          return;
	        }
	      }
	    
	      objects.add(pQuad);
	    
	      if (objects.size() > MAX_OBJECTS && level < MAX_LEVELS) {
	         if (nodes[0] == null) { 
	            split(); 
	         }
	    
	        int i = 0;
	        while (i < objects.size()) {
	          int index = getIndex(objects.get(i));
	          if (index != -1) {
	            nodes[index].insert(objects.remove(i));
	          }
	          else {
	            i++;
	          }
	        }
	      }
	    }
	    
	    /*
	     * Return all objects that could collide with the given object
	     */
	     public List retrieve(List returnObjects, Quad pQuad) {
	       int index = getIndex(pQuad);
	       if (index != -1 && nodes[0] != null) {
	         nodes[index].retrieve(returnObjects, pQuad);
	       }
	     
	       returnObjects.addAll(objects);
	     
	       return returnObjects;
	     }
}