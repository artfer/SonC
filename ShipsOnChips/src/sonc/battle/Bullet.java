package sonc.battle;

//all methods are written

/**
 * A simple munition that moves in a straight line. 
 */
public class Bullet extends Munition{
	static int damage;
	
	
	/**
	 * Create a bullet with a certain heading.
	 * The initial position with be that of the ship that fires the missile.
	 * 
	 * @param heading - of the bullet
	 */
	public Bullet(double heading) {
		super(status,heading,speed); //not sure about this...
	}

	
	
	/**
	 * Set the damage inflicted by a bullet in the status of ships it hits.
	 * This method should be invoked before any battle.
	 * 
	 * @param damage - inflicted by bullets
	 */
	static void setDamage(int damage) {
		Bullet.damage=damage;
	}
	
	
	
	/**
	 * Get the damage inflicted by a guided missile in the status
	 * of the ship it hits.
	 * 
	 * @return - damage inflicted by a bullet
	 */
	static int getDamage() {
		return damage;
	}
	
	
	
	/**
	 * Set the initial speed of a bullet.
	 * This method should be invoked before any battle.
	 * 
	 * @param speed - of bullets
	 */
	static void setInitialSpeed(double speed) {
		Bullet.speed=speed; //???
	}
	
	
	/**
	 * Get the initial speed of a bullet.
	 * 
	 * @return speed of a bullet
	 */
	static double getInitialSpeed() {
		return ;
	}
	
	
	/**
	 * Set the delay for firing this kind of munition.
	 * This method should be invoked before any battle.
	 * 
	 * @param fireDelay - number of rounds delay
	 */
	static void setFireDelay(int fireDelay) {
		
	}
	
	
	/**
	 * Get the delay for firing this kind of munition.
	 * 
	 * @return delay in number of rounds
	 */
	static int getFireDelay() {
		return ;
	}
	
	
	double getMaxSpeed() { //specified by
		return ;
	}
	
	@Override
	double getMaxSpeedChange() { 
		return ;
	}
	
	
	@Override
	double getMaxRotation() {
		return ;
	}
	
	
	int getImpactDamage() { //specified by
		return ;
	}
	
	
	int fireDelay() { //specified by
		return ;
	}
	
	
	public int getSize() { //specified by
		return ;
	}
	
	
	public String getColor() { //specified by
		return ;
	}
	
}
