package logger;

public class LoggerFactory {

	public static Logger getLogger() {
		return new CompositeLogger(new WithoutContextualLogger(new ConsoleLogger()),new ContextualLogger(new FileLogger("./banking.log")));
	}
}
