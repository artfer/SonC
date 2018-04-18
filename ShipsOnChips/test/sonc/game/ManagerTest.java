package sonc.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sonc.TestData;
import sonc.shared.SoncException;
import sonc.utils.AgentBuilder;

/**
 * Template for a test class on Manager - YOU NEED TO IMPLEMENTS THESE TESTS!
 * 
 */
public class ManagerTest extends TestData {
	static Manager manager;
	
	@BeforeClass
	public static void setUpClass() throws SoncException {
		AgentBuilder.addToClassPath("/home/artfer/git/SonC/ShipsOnChips/bin/"); // YOU MAY NEED TO CHANGE THE CLASS PATH!
	}
	
	@Before
	public void setUp() throws Exception {
		manager = new Manager();
	}

	/**
	 * Check user registration with invalid nicks, duplicate nicks, multiple users
	 * 
	 * @throws SoncException on reading serialization file (not tested)
	 */
	@Test
	public void testRegister() throws SoncException {
		assertFalse("Invalid nick",manager.register(INVALID_NICK, PASSWORDS[0]));
		assertTrue("Valid nick",manager.register(NICKS[0], PASSWORDS[0]));
		assertFalse("Duplicate nick",manager.register(NICKS[0], PASSWORDS[0]));
		assertTrue("Valid nick",manager.register(NICKS[1], PASSWORDS[1]));
		assertFalse("Duplicate nick",manager.register(NICKS[1], PASSWORDS[0]));
	}
	
	/**
	 * Check password update, with valid password, old password and wrong password
	 *    
	 * @throws SoncException on reading serialization file (not tested)
	 */
	@Test
	public void testUpdatePassword() throws SoncException {
		manager.register(NICKS[0], PASSWORDS[0]);
		
		assertTrue(manager.updatePassword(NICKS[0], PASSWORDS[0], PASSWORDS[1]));
		assertFalse(manager.updatePassword(NICKS[0], PASSWORDS[0], PASSWORDS[1]));
		assertTrue(manager.updatePassword(NICKS[0], PASSWORDS[1], PASSWORDS[0]));
	}

	/**
	 * Check authentication valid and invalid tokens and multiple users
	 * 
	 * @throws SoncException on reading serialization file (not tested)
	 * @throws IOException 
	 */
	@Test
	public void testAuthenticate() throws SoncException, IOException {
		manager.register(NICKS[0], PASSWORDS[0]);
		
		assertTrue(manager.authenticate(NICKS[0], PASSWORDS[0]));
		assertFalse(manager.authenticate(NICKS[0], PASSWORDS[1]));
		assertFalse(manager.authenticate(NICKS[1], PASSWORDS[1]));
		assertFalse(manager.authenticate(NICKS[1], PASSWORDS[0]));
	}

	/**
	 * Checks errors on compiling a ship 
	 * Checks exception handling on invalid passwords
	 * 
	 * @throws SoncException on reading serialization file (not tested)
	 */
	@Test
	public void testBuildShip() throws SoncException {
		fail();
	}
	
	/**
	 * Check getting code from player
	 * 
	 * @throws SoncException on reading serialization file (not tested)
	 */
	@Test
	public void testGetCurrentCode() throws Exception {
		assertNull(manager.getCurrentCode(NICKS[0],PASSWORDS[0]));
		
		manager.buildShip(NICKS[0],PASSWORDS[0],EMPTY_SHIP_CODE);
		assertEquals(EMPTY_SHIP_CODE,manager.getCurrentCode(NICKS[0],PASSWORDS[0]));
	}


	/**
	 * Check that number of players with ships increases only
	 * when a ship is build for a player (not just registering him/her),
	 * for more than a single player
	 * @throws SoncException 
	 */
	@Test
	public void testGetPlayersNamesWithShips() throws SoncException {
		assertEquals(0,manager.getPlayersNamesWithShips().size());
		
		manager.register(NICKS[0], PASSWORDS[0]);
		
		assertEquals(0,manager.getPlayersNamesWithShips().size());
		
		manager.allPlayers.getPlayer(NICKS[0]).setCode(EMPTY_SHIP_CODE);
		
		assertEquals(1,manager.getPlayersNamesWithShips().size());
		
		manager.register(NICKS[1], PASSWORDS[1]);
		
		assertEquals(1,manager.getPlayersNamesWithShips().size());
		
		manager.allPlayers.getPlayer(NICKS[1]).setCode(EMPTY_SHIP_CODE);
		
		assertEquals(2,manager.getPlayersNamesWithShips().size());
	}

	/**
	 * Check a simple battle with 2 empty ships. It should produce a
	 * movie with just two objects and scores for all frames
	 */
	@Test
	public void testBattle() {
		fail();
	}
}
