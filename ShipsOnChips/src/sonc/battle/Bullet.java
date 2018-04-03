package sonc.battle;


/**
 * A simple munition that moves in a straight line. 
 */
public class Bullet extends Munition{
	
	/**
	 * Create a bullet with a certain heading.
	 * The initial position with be that of the ship
	 * that fires the missile.
	 * @param heading - of the bullet
	 */
	Bullet(double heading){
		super(status, heading,speed);
	}
	
	/**
	 * Number of rounds a ship must wait to fire
	 * this munition since it fired the last time
	 * @return
	 */
	private int fireDelay() {
		
	}
	
	
}
