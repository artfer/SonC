package sonc.battle;

import java.lang.String;
import sonc.quad.HasPoint;

//passed all tests

/**
 * Common class to all moving objects in the game, including
 * ships and the munitions they throw at each other.
 */
public abstract class MovingObject implements HasPoint {
	int status;
	double heading;
	double speed;
	double x,y;
	
	/**
	 * Initialize a moving object with given status,heading and speed.
	 * s
	 * @param status - of this moving object at start
	 * @param heading - of this moving object at start
	 * @param speed - of this moving object at start
	 */
	protected MovingObject(int status , double heading, double speed){
		this.status = status;
		this.heading = normalizeAngle(heading);
		this.speed=speed;
	}


	
	/**
	 * Get X coordinate of this moving object. 
	 * 
	 * @return x coordinate of this ship
	 */
	public double getX() {
		return x;

	}


	
	/**
	 * Set X coordinate of this moving object.
	 * 
	 * @param x - coordinate of this moving object	
	 */
	void setX(double x) {
		this.x=x;
	}


	
	/**
	 * Get Y coordinate of this moving object.
	 * 
	 * @return y coordinate of this moving object
	 */
	public double getY() {
		return y;
	}


	
	/**
	 * Set Y coordinate of this moving object.
	 * 
	 * @param y - coordinate of this moving object
	 */
	void setY(double y) {
		this.y=y;
	}


	
	/**
	 * Get heading of this moving object.
	 * 
	 * @return heading of moving object
	 */
	public double getHeading() {
		return this.heading;
	}


	/**
	 * Set heading of this moving object.
	 * 
	 * @param heading - of moving object
	 */
	void setHeading(double heading) {
		this.heading=normalizeAngle(heading);
	}


	/**
	 * The current speed of this moving object.
	 * 
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}


	/**
	 * Normalize angles in range of [0,2*PI[ in radians.
	 * The value is added, or subtracted 2xPI, respectively while
	 * it is less than 0, or greater or equal than 2xPI.
	 * The method is available to concrete ships.
	 * 
	 * @param angle - to normalize
	 * 
	 * @return normalized angle in range [0,2*PI[
	 */
	protected double normalizeAngle(double angle) {
		while(angle<0) 		 angle+=TWO_PI;
		while(angle>=TWO_PI) angle-=TWO_PI;
		return angle;
	}


	/**
	 * Distance from this moving object to another given as parameter.
	 * 
	 * @param other - moving object
	 * 
	 * @return distance to the other 
	 */
	protected double distanceTo(MovingObject other) {
		double a = pow(x-other.getX());
		double b = pow(y-other.getY());
		return sqrt(a+b);		
	}
	
	//to improve readability
	private final static double TWO_PI = 2*Math.PI;
	private final static double     PI =   Math.PI;
	
	private double pow(double a) {
		return Math.pow(a,2);
	}
	
	private double sqrt(double x) {
		return Math.sqrt(x);
	}
	
	private double abs(double x) {
		return Math.abs(x);
	}
	
	private double sin(double x) {
		return Math.sin(x);
	}
	
	private double cos(double x) {
		return Math.cos(x);
	}
	
	private double asin(double x) {
		return Math.asin(x);
	}
	
	// 

	/**
	 * Angle from this moving object to another given as parameter.
	 * Angles are in radians in the range [0,2*PI[ : 
	 * 0 is right, PI/2 is down, PI is left and 3/2*PI is up.
	 * 
	 * @param other - moving object
	 * 
	 * @return angle to other object or NaN if some
	 * coordinates are not defined
	 */
	protected double headingTo(MovingObject other) {//not working
		 	 if(x==other.x && y<other.y) return PI/2;
		else if(x==other.x && y>other.y) return 3*PI/2;
		else if(x<other.x && y==other.y) return 0;
		else if(x>other.x && y==other.y) return PI;
		double hipotenuse = distanceTo(other);
		double opposite = abs(x-other.x);
		double alpha = asin(opposite/hipotenuse);
			 if(x<other.x && y<other.y) alpha+=0;
		else if(x<other.x  && y>other.y)alpha+=PI/2;
		else if(x>other.x && y>other.y) alpha+=PI;
		else if(x>other.x  && y<other.y)alpha+=3/2*PI;
		
		else return 0;
		return normalizeAngle(alpha-heading);
		
	}

	
	/**
	 * Update the position - (x,y) coordinates - of this moving
	 * object taking in consideration the current speed and heading.
	 * This method cannot be invoked by a concrete ship.
	 */
	final void updatePosition() {
		x+=cos(heading)*speed;
		y+=sin(heading)*speed;
	}


	/**
	 * Change heading of this moving object by given variation.
	 * Positive variation correspond to counterclockwise
	 * rotations and negative variations to clockwise rotations.
	 * If the absolute value of variation exceeds the predefined
	 * maximum rotation than it is limited to that value 
	 * (with the corresponding signal).
	 * This method cannot be invoked by a concrete ship.
	 * 
	 * @param delta - angle in radians
	 */
	final void doRotate(double delta) {
		double maxRotation = getMaxRotation();
		if(abs(delta)>maxRotation) 
			delta = delta>=0 ? maxRotation : -maxRotation;
		setHeading(heading+delta);
	}

	/**
	 * Change speed of this moving object. 
	 * Positive values increase the speed and negatives values 
	 * decrease it.
	 * If either the absolute value of variation, or the absolute 
	 * value of the changed speed, exceeds their respective 
	 * predefined maximums ({@link #getMaxSpeedChange()} 
	 * and {@link #getMaxSpeed()}) then they are limited to 
	 * that value (with the corresponding signal). 
	 * This method cannot be invoked by a concrete ship.
	 * 
	 * @param delta - speed variation (in radians)
	 */
	final void doChangeSpeed(double delta) {
		double speedChange = abs(speed-delta);
		if(speedChange>getMaxSpeedChange())
			delta = getMaxSpeedChange();
		double newSpeed = abs(speed+delta);
		if(newSpeed>getMaxSpeed())
			newSpeed=getMaxSpeed();
		speed=newSpeed;
	}


	/**
	 * Override this method to define the movement of this object.
	 * Concrete ships will need to do it to implement their strategies.
	 */
	void move() {}


	/**
	 * Change status to reflect damaged inflicted by given moving object.
	 * 
	 * @param moving - object that hit this one
	 */
	void hitdBy(MovingObject moving) {
		this.status -= moving.getImpactDamage();
	}


	/**
	 * Check if this moving object was destroyed.
	 * 
	 * @return true if this object is destroyed, false otherwise
	 */
	public boolean isDestroyed() {
		return this.status<=0;	
	}


	/**
	 * Current status of this moving object.
	 * When status reaches 0 the object is destroyed.
	 * 
	 * @return status of this moving object
	 */
	public int getStatus() {
		return this.status;
	}


	/**
	 * The maximum speed of this moving object in absolute value. 
	 * Ships may have negative speed when sailing backwards but the 
	 * absolute value of the speed cannot exceed this value. 
	 * 
	 * @return maximum speed variation
	 */
	abstract double getMaxSpeed();


	/**
	 * The maximum speed variation in absolute value, per turn, 
	 * of this moving object.
	 * 
	 * @return maximum speed variation
	 */
	abstract double getMaxSpeedChange();


	/**
	 * The maximum rotation per turn if this moving object.
	 * 
	 * @return maximum rotation
	 */
	abstract double getMaxRotation();


	/**
	 * Damage inflicted by this moving object when it hits another.
	 * 
	 * @return amount of status removed from
	 * another moving object on collision 
	 */
	abstract int getImpactDamage();


	/**
	 * The ship where this moving object originated, that must be
	 * credited for the damage inflicted by this moving object.
	 * 
	 * @return ship from which this moving started
	 * (or null if a ship)
	 */
	abstract Ship getOrigin();


	/**
	 * Size of this moving object when displayed.
	 * Moving object are represented as elongated 
	 * object (imagine a cigar) with this size.
	 * 
	 * @return size of this moving object
	 */

	public abstract int getSize();


	/**
	 * Color of this moving object. Different ships may have their
	 * own color but most other have colors depending of their on type.
	 * Colors may be set as an HTML/CSS color (e.g. "#0000FF") or
	 * a name for some basic colors (e.g. "yellow" or "red").
	 * 
	 * @return color as a HTML/CSS string or basic color
	 */
	public abstract String getColor();

	
}
