package sonc.shared;

//passed all tests

public class SoncException extends Exception{
	public SoncException(String message,Throwable cause,
			boolean enableSuppression,boolean writeableStackTrace){}
	
	public SoncException(String massage,Throwable cause) {}
	
	public SoncException(String message) {}
	
	public SoncException(Throwable cause) {}
}
