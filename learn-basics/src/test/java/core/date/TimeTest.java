package core.date;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @date 2023-3-3
 */
@Slf4j
public class TimeTest {
  @Test
  public void testDuration() throws InterruptedException {
    LocalDateTime start = LocalDateTime.now();
    TimeUnit.MILLISECONDS.sleep(1000);
    LocalDateTime end = LocalDateTime.now();
    Duration duration = Duration.between(start, end);
    log.info("时间间隔 {}", duration.getSeconds());
  }

  @Test
  public void testInstant() throws InterruptedException {
    DateTimeFormatter formatter =
        DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault());
    Instant start = Instant.now();
    TimeUnit.MILLISECONDS.sleep(1000);
    Instant end = Instant.now();
    log.info("start: {}", formatter.format(start));
    log.info("end: {}", formatter.format(end));
    long until = end.until(start, ChronoUnit.MILLIS);
    Duration duration = Duration.between(start, end);
    log.info("时间间隔 {}", until);
  }
}
