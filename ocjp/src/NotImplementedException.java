
@SuppressWarnings("serial")
public class NotImplementedException extends RuntimeException {
	public NotImplementedException(String message) {
		super(message);
	}
	
	public NotImplementedException(String className, String methodName) {
		this(className + ": " + methodName + " not implemented.");
	}
}
