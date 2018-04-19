package sonc.battle;


//passed all tests

import java.util.Set;

/**
 * The class common to all ships. 
 * It is meant to be specialized by concrete ships, those submitted by players. 
 * Concrete ships are expected to be in the default package (no package 
 * declaration) and provide an implementation of the move() method. 
 * This method is invoked once per round by the game engine (the World) 
 * and will be able to execute actions such as: 
 * 		rotate(double) - the ship by given angle in radians
 *		changeSpeed(double) - the change the speed of ship and sail around the world
 *		fire(Munition) - to fire a munition against other ships
 *These methods create instances of the corresponding implementation of the 
 *ShipCommand interface and store them, so that latter on the execute() method 
 *may be invoked to execute them. With this approach, if the methods in the list 
 *above are called more than once, only the last is effectively executed.
 *Other methods can be override, such as:
 *		init() - to initialize the ship
 *		getName() - to assign a name to the ship
 *		getColor() - to assign an HTML color to the ship
 *This can be instantiated as it provides default implementations to all methods 
 *that can be provided by concrete ships. The default definitions are always empty instruction blocks.
 * 
 *
 */
public class Ship extends MovingObject{
	
	protected Ship() {
		super(maxStatus,0,0);//initial status of 1000,heading and speed 0
	}
	
	
	static int damage,maxStatus;
	static double maxShipRotation,maxSpeed=5;
	static double maxShipSpeedChange;
	int lastFireRound=Integer.MIN_VALUE;
	private int points;
	World world;
	ShipCommand command;
	String name;
	String color = "silver";
	
	
	
	/**
	 * Set the amount of damage produced by ships.
	 * Should be invoked before instancing any ships.
	 * This method <b>cannot</b> be invoked by concrete
	 * ships. 
	 * @param damage - produced by ships when they colide 
	 */
	static void setDamage(int damage) {
		Ship.damage=damage;
	}
	
	
	/**
	 * The damaged produced by ships when it colides
	 * with another ship.
	 * @return damage produced by ships when they colide
	 */
	static int getDamage() {
		return damage;
	}
	
	
	/**
	 * Maximum rotation per turn of any ship.
	 * @return maximum rotation
	 */
	static double getMaxShipRotation() {
		return maxShipRotation;
	}
	
	
	/**
	 * Set the maximum rotation per turn of a ship.
	 * Should be used before instancing ships.
	 * This method <b>cannot</b> be invoked by concrete ships.
	 * @param maxShipRotation
	 */
	static void setMaxShipRotation(double maxShipRotation) {
		Ship.maxShipRotation=maxShipRotation;
	}
	
	
	/**
	 * Get the maximum speed ship change per turn.
	 * This method <b>cannot</b> be invoked by concrete ships.
	 * @return maximum speed in absolute value.
	 */
	static double getMaxShipSpeedChange() {
		return maxShipSpeedChange;
	}
	
	
	/**
	 * Set the maximum speed ship change per turn.
	 * Should be used before instancing ships.
	 * This method <b>cannot</b> be invoked by concrete ships.
	 * @param maxShipSpeedChange
	 */
	static void setMaxShipSpeedChange(double maxShipSpeedChange) {
		Ship.maxShipSpeedChange=maxShipSpeedChange;
	}
	
	
	/**
	 * The initial status of a ship.
	 * @return status of ship on start
	 */
	static int getMaxStatus() {
		return maxStatus;
	}
	
	
	/**
	 * Set the initial status of any ship.
	 * It affects ships created afterwards.
	 * This method <b>cannot</b> be invoked by concrete ships.
	 * @param maxStatus - of a ship when it starts
	 */
	static void setMaxStatus(int maxStatus) {
		Ship.maxStatus=maxStatus;
	}
	
	
	/**
	 * The world where this ship sails.
	 * This method is available to concrete ships.
	 * @return world instance
	 */
	protected World getWorld() {
		return world;
	}
	
	
	/**
	 * Set this ship in a world.
	 * This method is <b>not</b> available to concrete ships.
	 * @param world - where the ship will sail
	 */
	void setWorld(World world) {
		this.world=world;
	}
	
	
	/**
	 * Get the last round when this ship fired a munition.
	 * This method is available to concrete ships.
	 * @return last round when ship fired or Integer.MIN_VALUE
	 * if it never fired
	 */
	protected int getLastFireRound() {
		return lastFireRound;
	}
	
	
	/**
	 * Set the last round when this fired a munition.
	 * This method is <b>not</b> available to concrete ships.
	 * @param lastFireRound - round when this ship fired for 
	 * the last time
	 */
	void setLastFireRound(int lastFireRound) {
		this.lastFireRound=lastFireRound;
	}
	
	
	/**
	 * Check if this ship can fire the given munition.
	 * The difference between the current round and the
	 * last fired round must be greater than the fire delay
	 * for this munition.
	 * 
	 * @param munition - to be fired
	 * @return true if munition can be fired or false otherwise
	 */
	protected boolean canFire(Munition munition) {
		if(lastFireRound==Integer.MIN_VALUE)
			return true;
		int dif = World.getRounds() - lastFireRound;
		return dif > munition.fireDelay();
	}
	
	
	/**
	 * The latest command set by the concrete ship.
	 * 
	 * @return command set by concrete ship
	 */
	ShipCommand getCommand() {
		return command;
	}
	
	
	/**
	 * Set a command resulting from a method invoked by
	 * the {@link #move()} method executed executed by a
	 * concrete ship. This method should only be invoked
	 * from a {@link World} instance and <b>cannot</b> be
	 * invoked by concrete ships.
	 * 
	 * @param command - to be executed
	 */
	void setCommand(ShipCommand command) {
		this.command=command; 
	}
	
	
	/**
	 * Get current points from this ship.
	 * @return points as integer
	 */
	public int getPoints() {
		return points;
	}
	
	
	/**
	 * Reset points of this ship to zero.
	 */
	void resetPoints() {
		this.points=0;
	}
	
	
	/**
	 * Add given points to this ship.
	 * @param points - to add to this ship
	 */
	void addPoints(int points) {
		this.points+=points;
	}
	
	
	/**
	 * Execute the latest command defined by the concrete ship.
	 * This method should only be invoked from a {@link World}
	 * instance and <b>cannot</b> be invoked by concrete ships.
	 */
	void execute(){
		command.execute();
	}
	
	
	/**
	 * Change the speed of this ship by given delta.
	 * This command will be effective only if it is the
	 * last executed in a round.
	 * @param delta - variation of speed
	 */
	protected final void changeSpeed(double delta) {
		command = new ChangeSpeedCommand(this,delta);
	}
	
	
	/**
	 * Rotate the ship by given angle. This command will
	 * be effective only if it is the last executed in a
	 * round. This command <b>cannot</b> be override by
	 * concrete ships.
	 * @param delta - the rotation angle
	 */
	protected final void rotate(double delta) {
		command = new RotateCommand(this,delta);
	}
	
	
	/**
	 * Fire a munition given as parameter start in current
	 * position (e.g. {@code fire(new Bullet(headingTo(enemy)))}).
	 * This command will be effective only if it is the last 
	 * executed in a round. This command <b>cannot</b> be override
	 * by concrete ships.
	 * @param munition - to be fired from ship
	 */
	protected final void fire(Munition munition) {
		command = new FireCommand(world, this,munition);
	}
	
	
	/**
	 * A set of all other ships in the world, except this one.
	 * @return a set of ships
	 */
	protected final Set<Ship> getOtherShips(){
		return world.ships;
	}
	
	
	/**
	 * Initialize your ship. This method is called when the ship
	 * starts sailing. Use this method.
	 */
	protected void init() {};
	
	
	/**
	 * Move your ship. Redefine this method to implement how this
	 * ship must be moved.
	 */
	@Override
	protected void move() {}

	@Override
	double getMaxSpeed() {
		return maxSpeed;
	}
	
	void setMaxSpeed(double maxSpeed) {
		Ship.maxSpeed=maxSpeed;
	}

	@Override
	double getMaxSpeedChange() {
		return maxShipSpeedChange;
	}

	@Override
	double getMaxRotation() {
		return maxShipRotation;
	}

	@Override
	int getImpactDamage() {
		return damage;
	}

	@Override
	Ship getOrigin() {
		return null;
	}

	@Override
	public int getSize() {
		return 20;
	}

	@Override
	public String getColor() {
		return color;
	}
	 
	/**
	 * The name of this ship.
	 * This information is used on the score board.
	 * @return name of this ship as a String
	 */
	public String getName() {
		return name;
	}
	
	
	
	
}
