import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author xp-zhao
 */
public class CommonsLogging {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(CommonsLogging.class);
        log.info("start");
        log.warn("end");
        log.error("error");
    }
}
