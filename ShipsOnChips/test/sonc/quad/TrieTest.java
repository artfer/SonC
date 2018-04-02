package sonc.quad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test on Trie, the abstract tree common to both types of trie of a quadtree.
 * Checks the static method {@code getDistance()} and on the static 
 * getters and setters  of the capacity property.
 * 
 * @author José paulo Leal {@code zp@dcc.fc.up.pt}
 */
public class TrieTest {
	
	private static int CAPACITY = 10;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDistance() {
		double x1 = 0.007499999999999982D;
		double y1 = 0.007499999999999982D;	
		
		double x2=0.007499999999999999D;
		double y2=0.007499999999999999D;
		
		assertEquals(0,Trie.getDistance(x1, y1, x2, y2),Location.RADIUS);
		assertTrue(Trie.getDistance(x1, y1, x2, y2)<Location.RADIUS);
	}
	
	/**
	 * Test capacity of a bucket
	 */
	@Test
	public void testCapacity() {
		
		Trie.setCapacity(CAPACITY);
		assertEquals(CAPACITY, Trie.getCapacity());
	}

}
