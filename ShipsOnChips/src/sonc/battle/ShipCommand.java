package sonc.battle;


/**
 * This is the abstract part of the <b>Command</b> design pattern.
 * It defines a command executed by the ship and is used to delay
 * command execution until the {@link Ship#move()} command is 
 * completed. Ship commands are used to ensure that ships execute
 * at most one command per turn.
 */
interface ShipCommand {
	
	/**
	 * Method that executes the command. Arguments for
	 * command execution can be passed to the instance
	 * using the constructor.
	 */
	void execute();
}
