package sonc.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Players implements Serializable {
	
	private static final long serialVersionUID = 1L;
	List<Player> players= new ArrayList<>();
	/**
	 * Register a player with a given nick 
	 * and password.
	 * @param nick - of user 
	 * @param password - id user
	 * @return true if registered and false
	 * otherwise
	 */
	boolean register(String nick,String password) {
		if(nick.split(" ").length>1)
			return false;
		for(Player p : players)
			if(p.getNick().compareTo(nick)==0)
				return false;
		players.add(new Player(nick,password));
		return true;
	}
	
	
	/**
	 * Change password if old password matches
	 * current one.
	 * @param nick - of player
	 * @param oldPassword - for authentication
	 * before update
	 * @param newPassword - after update
	 * @return true if password changed and
	 * false otherwise
	 */
	boolean updatePassword(String nick,
		String oldPassword,String newPassword){
		for(Player p : players)
			if(p.getNick().compareTo(nick)==0 
			&& p.getPassword().compareTo(oldPassword)==0) {
					p.setPassword(newPassword);
					return true;
			}
		return false;
	}
	
	
	/**
	 * Authenticate user given id and password
	 * @param nick - of user to authenticate
	 * @param password - of user to authenticate
	 * @return true if authenticated and false
	 * otherwise
	 */
	boolean authenticate(String nick,String password) {
		for(Player p : players)
			if(p.getNick().compareTo(nick)==0 
			&& p.getPassword().compareTo(password)==0)
				return true;
		return false;
	}
	
	
	/**
	 * Get the player with the given name
	 * @param name - of player
	 * @return player instance
	 */
	Player getPlayer(String name) {
		for(Player p : players)
			if(p.getNick().compareTo(name)==0)
				return p;
		return null;
	}
	
	
	/**
	 * Produces a sorted list of players' names
	 * that have an instanceable ship.
	 * @return list of names as strings
	 */
	List<String> getPlayersNamesWithShips(){
		List<String> instancedShips = new ArrayList<>();
		for(Player p : players)
			if(p.isShipInstanced())
				instancedShips.add(p.getNick());
		return instancedShips;
	}	
}
