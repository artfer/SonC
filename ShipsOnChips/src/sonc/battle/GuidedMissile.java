package sonc.battle;

//doesn't pass all tests, missing move()

/**
 * Typer of missile that seeks the target.
 */
public class GuidedMissile extends Munition{
	
	/**
	 * Created a guided missile with a certain initial heading
	 * and a target. The initial position with be that of the
	 * ship that fires the missile.
	 * 
	 * @param heading - of the guided missile when fired
	 * @param target - of the guided missile
	 */
	
	static final double guidedSpeed=5;
	static int damage=10;
	private static int fireDelay;
	static double maxRotation=Math.PI/2;
	MovingObject target;
	GuidedMissile(double heading,MovingObject target){
		//default status 10
		super(10,heading,guidedSpeed);
		this.target = target;
	}
	
	
	/**
	 * Set the damage by a guided missile in the status
	 * of the ship it hits. This method should be invoked
	 * before any battle and <b>cannot</b> be invoked by
	 * concrete ships. 
	 * 
	 * @param damage - inflicted by guided missiles
	 */
	public static void setDamage(int damage) {
			GuidedMissile.damage=damage;
	}
	
	
	
	/**
	 * Get the damage inflicted by a guided missile in the 
	 * status of the ship it hits.
	 * 
	 * @return damage inflicted by a guided missile
	 */
	public static int getDamage() {
		return damage;
	}
	
	
	/**
	 * Maximum rotation per turn of any ship.
	 * 
	 * @return maximum rotation
	 */
	static double getMaxMissileRotation() {
		return maxRotation;
	}
	
	
	/**
	 * Set the maximum rotation per turn of a ship.
	 * This method should be used before instancing ships
	 * and <b>cannot</b> be invoked by concrete ships.
	 * 
	 * @param maxMissileRotation - of guided missiles
	 */
	static void setMaxMissileRotation(double maxMissileRotation) {
		GuidedMissile.maxRotation=maxMissileRotation;
	}
	
	
	/**
	 * Set the initial speed of a guided missile.
	 * This method should be invoked before any battle.
	 * 
	 * @param speed - of guided missile
	 */
	public static void setInitialSpeed(double speed) {
		GuidedMissile.speed = speed;
	}
	
	
	/**
	 * Get the initial speed of a guided missile.
	 * 
	 * @return speed of a guided missile
	 */
	public static double getInitialSpeed() {
		return speed;
	}
	
	
	/**
	 * Get the delay for firing this kind of munition.
	 * 
	 * @return delay in number of rounds
	 */
	static int getFireDelay() {
		return fireDelay;
	}
	
	
	/**
	 * Set the delay for firing this king of munition.
	 * This method should be invoked before any battle.
	 * 
	 * @param fireDelay - number of rounds of delay
	 */
	static void setFireDelay(int fireDelay) {
		GuidedMissile.fireDelay=fireDelay;
	}
	
	
	double getMaxSpeed() { //specified by
		return speed;
	}
	
	
	@Override
	double getMaxRotation() {
		return maxRotation;
	}
	
	
	@Override
	void move() {
		double targetHeading=headingTo(target);
		
		
	}
		
	
	int getImpactDamage() { //specified by
		return damage;
	}
	
	
	int fireDelay() { //specified by
		return fireDelay;
	}
	
	
	public int getSize() { //specified by
		return 3;
	}
	
	
	public String getColor() { //specified by
		return "black";
	}
	
	
	
}
