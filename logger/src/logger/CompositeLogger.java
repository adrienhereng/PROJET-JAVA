package logger;

public class CompositeLogger implements Logger {
	
	private Logger delegateLogger1;
	private Logger delegateLogger2;

	public CompositeLogger (Logger log1, Logger log2) {
		delegateLogger1 = log1;
		delegateLogger2 = log2;
	}
	public void debug(String category, String message) {
		delegateLogger1.debug(category, message);
		delegateLogger2.debug(category, message);
	}
	public void info(String category, String message) {
		delegateLogger1.info(category, message);
		delegateLogger2.info(category, message);
	}
	public void error(String category, String message) {
		delegateLogger1.error(category, message);
		delegateLogger2.error(category, message);
	}
}