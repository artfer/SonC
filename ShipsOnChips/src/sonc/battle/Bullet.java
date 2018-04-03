package sonc.battle;


/**
 * A simple munition that moves in a straight line. 
 */
public class Bullet extends Munition{
	static int damage;
	
	
	/**
	 * Create a bullet with a certain heading.
	 * The initial position with be that of the ship that fires the missile.
	 * @param heading - of the bullet
	 */
	public Bullet(double heading) {
		super(heading); // e o resto?
	}

	
	
	/**
	 * Set the damage inflicted by a bullet in the status of ships it hits.
	 * This method should be invoked before any battle.
	 * @param damage - inflicted by bullets
	 */
	static void setDamage(int damage) {
		Bullet.damage=damage;
	}
	
	
	
	/**
	 * Get the damage inflicted by a guided missile in the status
	 * of the ship it hits.
	 * @return - damage inflicted by a bullet
	 */
	static int getDamage() {
		return damage;
	}
	
	
	
	/**
	 * Set the initial speed of a bullet.
	 * This method should be invoked before any battle.
	 * @param speed - of bullets
	 */
	static void setInitialSpeed(double speed) {
		Bullet.speed=speed; //???
	}
	
	
	
	/**
	 * Number of rounds a ship must wait to fire 
	 * this munition since it fired the last time.
	 * @return
	 */
	private int fireDelay() {
		
	}
	
	
}
