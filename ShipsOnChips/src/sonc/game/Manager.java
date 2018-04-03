package sonc.game;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import sonc.shared.Movie;
import sonc.shared.SoncException;


/**
 * An instance of this class is responsible for
 * managing a community of players with several
 * games taking place simultaneously. The methods
 * of this class are those needed by web client
 * thus it follows the <b>Facade</b> design
 * pattern. It also follows the <b>singleton</b>
 * design pattern to provide a single instance
 * of this class to the application.
 */
public class Manager implements Serializable {
	Players allPlayers;
	static File managerFile;
	private static Manager manager = null;
	
	
	/**
	 * Name of file containing manager's data.
	 * @return file containing serialization
	 */
	public static File getPlayersFile() {
		return managerFile;
	}
	
	
	/**
	 * Change pathname of file containing 
	 * manager's data.
	 * @param managerFile - contain serialization
	 */
	public static void setPlayersFile(File managerFile) {
		Manager.managerFile = managerFile;
	}
	
	
	
	/**
	 * Returns the single instance of this class
	 * as proposed in the <b>singleton</b> design
	 * pattern. If a backup of this class is
	 * available then the manager is recreated
	 * from that that data.
	 * @return instance of this class
	 * @throws SoncException if I/O error
	 * occurs reading serialization
	 */
	public static Manager getInstance() 
			throws SoncException{
		try {
			if(manager==null)
				return manager=new Manager();
			else
				return manager;
		} catch (Exception e) {
			throw new SoncException("Something's wrong");
		}
	}
	
	
	/**
	 * Register a player with given nick and password.
	 * Changes are stored in serialization file.
	 * @param userId - of user
	 * @param password - id user
	 * @return true if registered and false
	 * otherwise
	 * @throws SoncException if I/O error occurs
	 * when serializing data 
	 */
	public boolean register(String userId,String password) 
			throws SoncException {
		try {
			return allPlayers.register(userId, password);
		} catch (Exception e) {
			throw new SoncException("sdsad");
		}
	}
	
	
	
	/**
	 * Change password if old password matches the current one.
	 * @param nick - of player 
	 * @param oldPassword - for authentication before update
	 * @param newPassord - after update
	 * @return true if password change and false otherwise
	 * @throws SoncException if I/O error occurs when serializing data
	 */
	public boolean updatePassword(String nick,String oldPassword,
			String newPassword) throws SoncException {
		try {
			return allPlayers.updatePassword(nick, oldPassword, newPassword);
		} catch (Exception e) {
			throw new SoncException("sdasd");
		} 
	}
	
	
	/**
	 * Authenticate user given id and password
	 * @param nick - of user to authenticate
	 * @param password - of user to authenticate
	 * @return true if authenticate and false otherwise
	 */
	public boolean authenticate(String nick,String password) {
		return allPlayers.authenticate(nick, password);
	}
	
	
	/**
	 * Return last submitted code by the authenticated user.
	 * @param nick - of player
	 * @param password - of player
	 * @return code of player's ship
	 * @throws SoncException if nick is unknown or password invalid
	 */
	public String getCurrentCode(String nick,String password) 
			throws SoncException{
		return allPlayers.getPlayer(nick).getCode();
	}
	
	
	
	/**
	 * Set ship's code and try to instance it, for given user and
	 * from given code.
	 * @param nick - of the player
	 * @param password - of the player
	 * @param code - the compile and instance
	 * @throws SoncException if nick is unknown, password is
	 * invalid, code has errors or an I/O error occurred
	 */
	public void buildShip(String nick,String password,String code) 
			throws SoncException {
		try {
			if(allPlayers.authenticate(nick, password)) {
				allPlayers.getPlayer(nick).setCode(code);
				allPlayers.getPlayer(nick).instanceShip();
			}
		} catch (Exception e) {
			throw new SoncException("sdasdsa");
		}
	}
	
	
	/**
	 * Returns a sorted list of all registered players' nicks with ships.
	 * These nicks can be used in a simulation.
	 * @return list of strings
	 */
	List<String> getPlayersNamesWithShips(){
		return allPlayers.getPlayersNamesWithShips();
	}
	
	
	/**
	 * Simulate a battle with ships of given players.
	 * Ships are shuffled in random order (using 
	 * java.Collection.shuffle() method).
	 * @param nicks - of players in this game
	 * @return movie with game
	 */
	public Movie battle(List<String> nicks) {
		
	}
	
	
	/**
	 * Resets players for debugging purposes. 
	 */
	void reset() {
		
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
