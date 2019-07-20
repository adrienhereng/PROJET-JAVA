package logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContextualLogger implements Logger {
	
	private Logger delegateLogger;
	
	public ContextualLogger(Logger logger) {
		delegateLogger = logger;
	}

	public void debug(String category, String message) {
		delegateLogger.debug(new SimpleDateFormat("<YYYY-MM-dd HH:SS:sss>").format(new Date())+" "+"<"+category+">"," "+"<DEBUG>"+" "+message);
	}

	public void info(String category, String message) {
		delegateLogger.info(new SimpleDateFormat("<YYYY-MM-dd HH:SS:sss>").format(new Date())+" "+"<"+category+">"," "+"<INFO>"+" "+message);
	}

	public void error(String category, String message) {
		delegateLogger.error(new SimpleDateFormat("<YYYY-MM-dd HH:SS:sss>").format(new Date())+" "+"<"+category+">"," "+"<ERROR>"+" "+message);
	}
}
