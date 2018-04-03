package sonc.battle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sonc.shared.Movie;

public class World {
	static int rounds,currentRound;
	static double margin,width,height;
	static double collisionDistance;
	Set<MovingObject> movingObjects = new HashSet<>();
	
	
	/**
	 * Number of rounds in a battle.
	 * @return round in a battle
	 */
	public static int getRounds() {
		return rounds;
	}
	
	
	/**
	 * Set number of rounds in a battle.
	 * This method should be executed before
	 * battles and cannot be visible to 
	 * concrete ships.
	 * @param rounds - in a battle
	 */
	static void setRounds(int rounds) {
		World.rounds=rounds;
	}
	
	
	/**
	 * Margin from border used for placing ships
	 * within the world.
	 * @return - margin to border when placing ships
	 */
	public static double getMargin() {
		return margin;
	}
	
	
	/**
	 * Set the margin from border used for placing
	 * ships within the world. This method should
	 * be executed before battles and cannot be visible
	 * to concrete ships.
	 * @param margin - to border when placing ships
	 */
	static void setMargin(double margin) {
		World.margin=margin;
	}
	
	
	/**
	 * The width of the world
	 * @return width of the world
	 */
	public static double getWidth() {
		return width;
	}
	
	
	/**
	 * Set the width of the world. This method should
	 * be executed before battles and cannot be 
	 * visible to concrete ships.
	 * @param width - of world
	 */
	static void setWidth(double width) {
		World.width=width;
	}
	
	
	/**
	 * The height of the world.
	 * @return height of the world
	 */
	public static double getHeight() {
		return height;
	}
	
	
	/**
	 * Set the height of the world. This method
	 * should be executed before battles and cannot
	 * be visible to concrete ships.
	 * @param height - of world
	 */
	static void setHeight(double height) {
		World.height=height;
	}
	
	
	/**
	 * Minimum distance between object to be considered
	 * as a collision.
	 * @return distance in pixels
	 */
	public static double getCollisionDistance() {
		return collisionDistance;
	}
	
	
	/**
	 * Set minimum distance between object to be
	 * considered as a collision.
	 * @param collisionDistance - in pixels
	 */
	static void setCollisionDistance(double collisionDistance) {
		World.collisionDistance=collisionDistance;
	}
	
	
	/**
	 * Add a ship to this world. Set it in a
	 * random position. Initialize the ship and
	 * reset its points.
	 * @param ship - to be added
	 */
	void addShipAtRandom(Ship ship) {
		
	}
	
	
	/**
	 * Add a ship to this world. Define position and heading.
	 * Initialize the ship and reset its points. This method
	 * is useful for testing.
	 * @param ship - to be added
	 * @param x - coordinate of initial position
	 * @param y - coordinate of initial position
	 * @param heading - of ship at the initial position
	 */
	void addShipAt(Ship ship,double x,double y,double heading) {
		
	}
	
	
	/**
	 * Make a battle with given ships. The battle unfolds for a
	 * number of rounds defined by the rounds property. The init()
	 * method of each of these ships is invoked in the begining, 
	 * and the method move() in invoked in each turn. These two
	 * methods are invoked trough the safe executor. If they raise
	 * any exception, including those due to timeout or to attempt
	 * to use system resources, then the ship is removed from the 
	 * battle.
	 * @param ships - as list of {@link Ship} instances
	 * @return movie of the battle
	 */
	/*public Movie battle(List<Ship> ships) {
		
	}*/
	
	
	/**
	 * Get the number of round from the initial one (round 0).
	 * The current number of rounds is need keeping delays
	 * between consecutive firings (of munition). This method
	 * is available to concrete ships.
	 * @return currentRound of the battle
	 */
	public int getCurrentRound() {
		return currentRound;
	}
	
	
	/**
	 * Set the number of round from the initial one (round 0).
	 * The current number of rounds is need keeping delays
	 * between consecutive firings (of munition). This method
	 * is <b>not</b> available to concrete ships.
	 * @param currentRound - of the battle
	 */
	void setCurrentRound(int currentRound) {
		World.currentRound=currentRound;
	}
	
	
	/**
	 * Update the world by moving, removing those outside
	 * the boundaries , check those that were hit by another one,
	 * reducing their status, terminating those that reach zero.
	 * This method uses and creates a new version of the 
	 * PointQuadTree containing all moving objects in the
	 * world instance.
	 */
	void update() {
		
	}
	
	
	/**
	 * Add a moving object to the world.
	 * @param added - object
	 */
	void addMovingObject(MovingObject added) {
		movingObjects.add(added);
	}
	
	
	
	/**
	 * The set of all moving objects in the world.
	 * Mostly for tests.
	 * @return set of {@link MovingObject} instances
	 */
	Set<MovingObject> getMovingObjects(){
		return movingObjects;
	}
	
	
	
	
}
