import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by xp-zhao on 2018/5/3.
 */
public class LogDemo
{
	private static final Logger logger = LogManager.getLogger("mylog");

	public static void main(String[] args)
	{
		for(int i = 0; i < 50000; i++)
		{
			logger.trace("trace level");
			logger.debug("debug level");
			logger.info("info level");
			logger.warn("warn level");
			logger.error("error level");
			logger.fatal("fatal level");
		}
		try {
			Thread.sleep(1000 * 61);
		} catch (InterruptedException e) {}
		logger.trace("trace level");
		logger.debug("debug level");
		logger.info("info level");
		logger.warn("warn level");
		logger.error("error level");
		logger.fatal("fatal level");
	}
}
