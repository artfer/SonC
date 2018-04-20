package sonc.quad;

import java.io.Serializable;

public class PointOutOfBoundException extends RuntimeException implements Serializable {
	PointOutOfBoundException(){
		super();
	}
}
