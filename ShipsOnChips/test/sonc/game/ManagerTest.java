package sonc.game;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sonc.TestData;
import sonc.shared.SoncException;

public class ManagerTest extends TestData {
	static Manager manager;
	
	@BeforeClass
	public static void setUpClass() throws SoncException {
		manager = Manager.getInstance();
	}
	
	@Before
	public void setUp() throws Exception {
		manager.reset();
	}

	/**
	 * Check user registration with invalid nicks, duplicate nicks, multiple users
	 * 
	 * @throws SoncException on reading serialization file (not tested)
	 */
	@Test
	public void testRegister() throws SoncException {
		
	}
	
	/**
	 * Check password update, with valid password, old password and wrong password
	 *    
	 * @throws SoncException on reading serialization file (not tested)
	 */
	@Test
	public void testUpdatePassword() throws SoncException {
		
	}

	/**
	 * Check authentication valid and invalid tokens and multiple users
	 * 
	 * @throws SoncException on reading serialization file (not tested)
	 */
	@Test
	public void testAuthenticate() throws SoncException {
		
	}

	/**
	 * Checks errors on compiling a ship 
	 * Checks exception handling on invalid passwords
	 * 
	 * @throws SoncException on reading serialization file (not tested)
	 */
	@Test
	public void testBuildShip() throws SoncException {

	}
	
	/**
	 * Check getting code from player
	 * 
	 * @throws SoncException on reading serialization file (not tested)
	 */
	@Test
	public void testGetCurrentCode() throws SoncException {
		
	}


	/**
	 * Check that number of players with ships increases only
	 * when a ship is build for a player (not just registering him/her),
	 * for more than a single player
	 */
	@Test
	public void testGetPlayersNamesWithShips() {
		
	}

	/**
	 * Check a simple battle with 2 empty ships. It should produce a
	 * movie with just two objects and scores for all frames
	 */
	@Test
	public void testBattle() {
		
	}
}
