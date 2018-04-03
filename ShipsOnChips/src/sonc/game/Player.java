package sonc.game;

import java.io.Serializable;
import java.lang.String;

import sonc.battle.Ship;
import sonc.shared.SoncException;
import sonc.utils.AgentBuilder;

/**
 * A player of the SonC game. An instance of
 * this class records the player's authentication
 * and the last code submitted.
 */
public class Player implements Serializable {
	private String nick,password,code;
	private Ship ship;
	
	Player(String nick,String password){
		this.nick=nick;
		this.password=password;
	}
	
	String getNick() {
		return this.nick;
	}
	
	void setNick(String nick) {
		this.nick = nick;
	}
	
	String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	/**
	 * Get the latest version of this player's code.
	 * @return code of this player
	 */
	String getCode() {
		return this.code;
	}
	
	
	/**
	 * Set the latest version of this player's code.
	 * @param code - of this player
	 */
	void setCode(String code) {
		this.code=code;
	}
	
	
	/**
	 * Try to compile and instance the submitted
	 * code and report errors. It uses the 
	 * {@link sonc.utils.AgentBuilder} class.
	 * @throws SoncException - on errors in 
	 * compiling or instancing the code
	 */
	void checkCode() throws SoncException{
		try {
			AgentBuilder builder = new AgentBuilder();
			ship=builder.getInstance(Ship.class, code, nick );
		} catch (Exception e) {
			throw new SoncException("Something went wrong");
		}
	}


	/**
	 * Make an instance of {@link sonc.battle.Ship}
	 * after compiling and instancing the submitted
	 * code. This instance is stored in this class.
	 * @return instance ship or null if exceptions
	 * occurred when compiling the code or instancing
	 * the class
	 */
	Ship instanceShip() {
		try {
			checkCode();
			return ship;
		} catch (SoncException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Check the authentication of this player.
	 * @param password - for checking
	 * @return true password is the expected,
	 * false otherwise
	 */
	boolean authenticate(String password) {
		if(this.password.compareTo(password)==0)
			return true;
		return false;
	}
	
	
	/**
	 * Checks if ship is instanced.
	 * @return true if instanced, false otherwise
	 */
	public boolean isShipInstanced() {
		if(ship==null)
			return false;
		return true;
	}
	
}
