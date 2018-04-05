package sonc.battle;

//passed all tests


class RotateCommand implements ShipCommand{
	Ship ship;
	double delta;
	
	/**
	 * Create a RotateCommand from given data
	 * 
	 * @param ship - that is rotated
	 * @param delta - rotation angle
	 */
	RotateCommand(Ship ship,double delta){
		this.ship  = ship;
		this.delta = delta;
	}


	public void execute() {
		ship.setHeading(ship.getHeading()+delta);
	}
}
