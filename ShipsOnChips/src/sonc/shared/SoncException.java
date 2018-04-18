package sonc.shared;

//passed all tests

public class SoncException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public SoncException(String message,Throwable cause,
			boolean enableSuppression,boolean writeableStackTrace){
		super(message,cause,enableSuppression,writeableStackTrace);
	}
	
	public SoncException(String massage,Throwable cause) {
		super(massage,cause);
	}
	
	public SoncException(String message) {
		super(message);
	}
	
	public SoncException(Throwable cause) {
		super(cause);
	}
}
