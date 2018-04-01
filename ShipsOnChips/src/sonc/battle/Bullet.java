package sonc.battle;

public class Bullet extends Munition{
	private double heading;
	
	/**
	 * Create a bullet with a certain heading.
	 * @param heading
	 */
	Bullet(double heading){
		super();
	}
	
	/**
	 * Number of rounds a ship must wait to fire
	 * this munition since it fired the last time
	 * @return
	 */
	private int fireDelay() {
		return 16;
	}
	
	
}
