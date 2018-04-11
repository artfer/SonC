package sonc.battle;

//passed all tests


abstract class Munition extends MovingObject{
	Ship origin;
	
	protected Munition(int status , double heading , double speed){
		super(status,heading,speed);
	}
	
	
	/**
	 * Initial movement from its origin,
	 * to avoid being considered as hitting it. 
	 */
	void escape() {}
	
	
	
	/**
	 * Number of rounds a ship must wait to fire
	 * this munition since it fired the last time.
	 * 
	 * @return delay in number of rounds
	 */
	abstract int fireDelay();
	
	
	
	double getMaxSpeedChange() {
		return 0;	
	}
	
	
	
	double getMaxRotation() {
		return 0;
	}
	
	
	
	void setOrigin(Ship origin) {
		this.origin=origin;
	}
	
	
	
	Ship getOrigin() {
		return origin;
	}
}
