package problem2;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = -6735439451040642809L;

	EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
