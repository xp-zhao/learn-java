import java.util.logging.Logger;

/**
 * @author xp-zhao
 */
public class JdkLogging {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(JdkLogging.class.getName());
        logger.info("start process ...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
    }
}
