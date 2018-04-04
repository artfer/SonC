package sonc.battle;


//all methods are written

/**
 * This class integrates the concrete part of the <b>Command</b> 
 * design pattern. It defines a change in speed of the ship
 * executed by the changeSpeed() method, that is delayed
 * until the {@link MovingObject#move()} command is completed.
 * This ensures that a single command is executed per turn.
 */
class ChangeSpeedCommand implements ShipCommand {
	
	/**
	 * Create a ChangeSpeedCommand from given data
	 * 
	 * @param ship - that changes speed
	 * @param delta - variation in speed
	 */
	ChangeSpeedCommand(Ship ship,double delta){
		ship.changeSpeed(delta);
	}
	
	
	public void execute() {}

}
