package sonc.battle;

//need tree

/**
 * This class integrates the concrete part of the the Command
 * design pattern. It defines the firing of a munition executed
 * by the fire() method, that is delayed until the {@link Ship#move()}
 * command is completed. This ensures that a single command is executed
 * per turn. <br><br> The execute command in this class is responsible
 * to enforce a delay between consecutive firing from the same ship.
 * The delay between consecutive firing from the same ship must be superior
 * the munition {@link Munition#fireDelay()}.
 */
class FireCommand implements ShipCommand{
	World world;
	Ship ship;
	Munition munition;
	
	/**
	 * Create a FireCommand from given data
	 * @param world - where munition will be created
	 * @param ship - that fires munition
	 * @param munition - to be fired (may be different types)
	 */
	FireCommand(World world,Ship ship,Munition munition){
		this.world=world;
		this.ship=ship;
		this.munition=munition;
	}

	
	public void execute() {
		if(ship.canFire(munition)) {
			world.addMovingObject(munition);
			ship.setLastFireRound(world.getCurrentRound());
		}
	}


}
