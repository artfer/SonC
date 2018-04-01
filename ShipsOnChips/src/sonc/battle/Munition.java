package sonc.battle;

abstract class Munition extends MovingObject{
	
	protected Munition(int status , double heading , double speed){
		super(status,heading,speed);
	}
	
	/**
	 * Initial movement from its origin,
	 * to avoid being considered as hitting it. 
	 */
	void escape() {
		
	}
	
	
	/**
	 * Number of rounds a ship must wait to fire
	 * this munition since it fired the last time.
	 * 
	 * @return delay in number of rounds
	 */
	abstract int fireDelay();
	
	
	/**
	 * 
	 * @param origin
	 */
	void setOrigin(Ship origin) {
		
	}
	
	
	
}
