package be.tomdewolf.jpms.version.info.internal;

public class RequiredModuleNotAvailableException extends RuntimeException {
	public RequiredModuleNotAvailableException(String requiredModuleName) {
		super("A required module with name " + requiredModuleName + " is not available");
	}
}
