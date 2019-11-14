package concurrent.callable;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * EventLoggingTask.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class EventLoggingTask implements Runnable {

  private Logger logger = LoggerFactory.getLogger(EventLoggingTask.class);

  @Override
  public void run() {
    logger.info("message");
  }
}