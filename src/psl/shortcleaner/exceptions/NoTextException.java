package psl.shortcleaner.exceptions;

public class NoTextException extends RuntimeException{

	/**
	 * 
	 */
	public NoTextException(){
		System.err.println("Dirty text not found in parameter:");
	}

	public NoTextException(String message) {
		super(message);
		System.err.println("Dirty text not found in parameter:");
	}

	public NoTextException(Throwable cause) {
		this(cause.toString(), cause);
		System.err.println("Dirty text not found in parameter:");
	}

	public NoTextException(String message, Throwable cause) {
		super(message);
		System.err.println("Dirty text not found in parameter:");
	}
	private static final long serialVersionUID = 1L;

}
