package exception;

public class UserIDNotFoundException extends Exception {
	public UserIDNotFoundException() {
		//super("User ID Not Found Exception");
		System.out.println("User ID Not Found");
	}
}
