package sonc.battle;


/**
 * This class integrates the concrete part of the the Command
 * design pattern. It defines the firing of a munition executed
 * by the fire() method, that is delayed until the {@link Ship#move()}
 * command is completed. This ensures that a single command is executed
 * per turn. <br> The execute command in this class is responsible
 * to enforce a delay between consecutive firing from the same ship.
 * The delay between consecutive firing from the same ship must be superior
 * the munition {@link Munition#fireDelay()}.
 */
class FireCommand implements ShipCommand{

	/**
	 * Create a FireCommand from given data
	 * @param world - where munition will be created
	 * @param ship - that fires munition
	 * @param munition - to be fired (may be different types)
	 */
	FireCommand(World world,Ship ship,Munition munition){

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}


}
