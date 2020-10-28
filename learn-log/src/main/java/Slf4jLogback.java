import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xp-zhao
 */
public class Slf4jLogback {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Slf4jLogback.class);
        logger.info("start {}", 1);
        logger.warn("warn {}", 2);
        logger.error("error {}", 3);
    }
}
