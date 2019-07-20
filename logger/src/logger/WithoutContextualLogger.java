package logger;

public class WithoutContextualLogger implements Logger {

	private Logger delegateLogger;

	public WithoutContextualLogger(Logger delegateLogger) {
		this.delegateLogger = delegateLogger;
	}

	public void debug(String category, String message) {
		if(category.equals("OUTPUT"))
			delegateLogger.debug(category, message);
	}
	public void info(String category, String message) {
		if(category.equals("OUTPUT"))
			delegateLogger.info(category, message);
	}
	public void error(String category, String message) {
		if(category.equals("OUTPUT"))
			delegateLogger.error(category, message);
	}

}
