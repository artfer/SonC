package sonc.battle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import sonc.quad.PointQuadtree;
import sonc.shared.Movie;
import sonc.utils.SafeExecutor;


/**
 * A rectangular area where battles take place.
 * It contains a collection of moving objects, some of which are
 * ships (others are munitions). It provides methods for updating
 * the state of moving objects within it. Those that fell of the 
 * boundaries are automatically discarded, including ships.<br><br>
 * The state of this class includes a {@link PointQuadTree} for 
 * managing moving objects and efficiently detecting collisions.
 * <br><br>There are a number of static properties that parameterize
 * worlds. Their getters are public but the setter cannot be visible
 * to concrete ships (those submitted by players).<br><br>
 * The main method provided by this class is {@link #battle(list)}
 * that receives a list of {@link Ship} and return a {@link Movie}. 
 * 
 *
 */
public class World {
	static int rounds,currentRound;
	static double margin,width,height;
	static double collisionDistance=10;
	PointQuadtree<MovingObject> movingObjects;
	Set<Ship> ships;
	SafeExecutor safeExecutor; 
	
	World(){
		movingObjects = new PointQuadtree<MovingObject>(0,0,width,height);
		safeExecutor = new SafeExecutor();
		ships = new HashSet<>();
	}
	
	/**
	 * Number of rounds in a battle.
	 * 
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
	 * 
	 * @param rounds - in a battle
	 */
	static void setRounds(int rounds) {
		World.rounds=rounds;
	}
	
	
	/**
	 * Margin from border used for placing ships
	 * within the world.
	 * 
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
	 * 
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
	 * 
	 * @param width - of world
	 */
	static void setWidth(double width) {
		World.width=width;
	}
	
	
	/**
	 * The height of the world.
	 * 
	 * @return height of the world
	 */
	public static double getHeight() {
		return height;
	}
	
	
	/**
	 * Set the height of the world. This method
	 * should be executed before battles and cannot
	 * be visible to concrete ships.
	 * 
	 * @param height - of world
	 */
	static void setHeight(double height) {
		World.height=height;
	}
	
	
	/**
	 * Minimum distance between object to be considered
	 * as a collision.
	 * 
	 * @return distance in pixels
	 */
	public static double getCollisionDistance() {
		return collisionDistance;
	}
	
	
	/**
	 * Set minimum distance between object to be
	 * considered as a collision.
	 * 
	 * @param collisionDistance - in pixels
	 */
	static void setCollisionDistance(double collisionDistance) {
		World.collisionDistance=collisionDistance;
	}
	
	
	/**
	 * Add a ship to this world. Set it in a
	 * random position. Initialize the ship and
	 * reset its points.
	 * 
	 * @param ship - to be added
	 */
	void addShipAtRandom(Ship ship) {
		ships.add(ship);
		movingObjects.insert(ship);
	}
	
	
	/**
	 * Add a ship to this world. Define position and heading.
	 * Initialize the ship and reset its points. This method
	 * is useful for testing.
	 * 
	 * @param ship - to be added
	 * @param x - coordinate of initial position
	 * @param y - coordinate of initial position
	 * @param heading - of ship at the initial position
	 */
	void addShipAt(Ship ship,double x,double y,double heading) 
			/*throws SoncException*/ {
		if(x>width || x<0 || y>width || y<0)
			/*throw new SoncException("Out of bounds");*/ 
		ships.add(ship);
		movingObjects.insert(ship);
		ship.setX(x);
		ship.setY(y);
		ship.setHeading(heading);
		
	}
	
	
	public Set<Ship> getShips(){
		return ships;
	}
	
	
	/**
	 * Make a battle with given ships. The battle unfolds for a
	 * number of rounds defined by the rounds property. The init()
	 * method of each of these ships is invoked in the beginning, 
	 * and the method move() in invoked in each turn. These two
	 * methods are invoked trough the safe executor. If they raise
	 * any exception, including those due to timeout or to attempt
	 * to use system resources, then the ship is removed from the 
	 * battle.
	 * @param ships - as list of {@link Ship} instances
	 * @return movie of the battle
	 */
	public Movie battle(List<Ship> ships) {
		Movie movie = new Movie();
		return movie;
	}
	
	
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
	 * {@link PointQuadTree} containing all moving objects in the
	 * world instance.
	 */
	void update() {
		Set<MovingObject> all = movingObjects.getAll();
		for(MovingObject mo : all)
			mo.updatePosition();
	}
	
	
	/**
	 * Add a moving object to the world.
	 * @param added - object
	 */
	void addMovingObject(MovingObject added) {
		movingObjects.insert(added);
	}
	
	
	
	/**
	 * The set of all moving objects in the world.
	 * Mostly for tests.
	 * @return set of {@link MovingObject} instances
	 */
	Set<MovingObject> getMovingObjects(){
		return movingObjects.getAll();
	}
	
	
	
	
}
