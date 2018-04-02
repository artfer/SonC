package sonc.shared;

import java.lang.String;
import java.util.List;


/**
 * Data for an animation of the game that can be presented
 * to the player. It is composed of a sequence frames, each
 * with a sequence of oblong objects and another of player's
 * scores. Oblong objects of different sizes and colors 
 * represent ships and munitions.
 */
public class Movie {
	
	/**
	 * A frame in a movie with a list of oblong
	 * objects and scores of players.
	 */
	public static class Frame{
		
		/**
		 * Get the oblong objects in this frame.
		 *
		 * @return the oblong
		 */
		public List<Movie.Oblong> getOblongs(){
			
		}
		
		
		/**
		 * Get the scores in this frame.
		 * 
		 * @return the scores
		 */
		public List<Movie.Score> getScores(){
			
		}
	}
	
	
	/**
	 * Immutable representing oblong object with a center
	 * and a direction (heading). It also has a size and
	 * a color that are useful for visualization.
	 */
	public static class Oblong {
		String color;
		float heading;
		int size,x,y;
		
		Oblong(int x,int y,float heading,
				int size, String color){
			this.x=x;
			this.y=y;
			this.heading=heading;
			this.size=size;
			this.color=color;
		}
		
		
		/**
		 * X coordinate of the oblong's position in this frame.
		 * @return the x
		 */
		public int getX() {
			return this.x;
		}
		
		
		/**
		 * Y coordinate of the oblong's position in this frame.
		 * @return the y
		 */
		public int getY() {
			return this.y;
		}
		
		
		/**
		 * Heading of the oblong in this frame.
		 * @return the heading
		 */
		public float getHeading() {
			return this.heading;
		}
		
		
		/**
		 * Size of the oblong
		 * @return the size
		 */
		public int getSize() {
			return this.size;
		}
		
		
		/**
		 * Color of the oblong
		 * @return the color
		 */
		public String getColor() {
			return this.color;
		}
	}
	
	
	/**
	 * Immutable with player's score presented in a frame,
	 * with points and status.
	 */
	public static class Score{
		String name;
		int points,status;
		
		public Score(String name,int points,int status){
			this.name=name;
			this.points=points;
			this.status=status;
		}
		
		
		/**
		 * Get the player's name.
		 * @return the name
		 */
		public String getName() {
			return this.name;
		}
		
		
		/**
		 * Get the player's points.
		 * @return the points
		 */
		public int getPoints() {
			return this.points;
		}
		
		
		/**
		 * Get the player's status in frame.
		 * @return the frame
		 */
		public int getStatus() {
			return this.status;
		}
		
	}
	
	
	/**
	 * Create a new frame. Subsequent calls to {@link #addRect()}
	 * or {@link #addScore()} will add these elements to this frame.
	 */
	public void newFrame() {
		Frame frame = new Frame();
	}
	
	
	/**
	 * Add a object to current frame.
	 * 
	 * @param x - coordinate of object
	 * @param y - coordinate of object
	 * @param heading - of object (angle in radians)
	 * @param size - of the oblong object
	 * @param color - String with its name (e.g. "red") 
	 * or HTML/CSS format (e.g. "#FF0000")
	 * 
	 * @throws java.lang.IllegalStateException if no
	 * frame was created before executing this method
	 */
	public void addOblong(int x,int y,float heading,
							int size,String color) {
		
	}
	
	
	/**
	 * Add a score to current frame.
	 * 
	 * @param name - of player
	 * @param points - of player
	 * @param status - of player
	 * 
	 * @throws java.lang.IllegalStateException if no
	 * frame was created before executing this method
	 */
	public void addScore(String name,int points,int status) {
		
	}
	
	
	/**
	 * Get the current list of frames.
	 * 
	 * @return list of frames
	 */
	public List<Movie.Frame> getFrames(){
		
	}
}
