package date.duration;

import java.time.Duration;
import java.time.Instant;

public class DurationDemo {
    public static void main(String[] args) {
        Instant start = Instant.parse("2017-10-03T10:15:30.00Z");
        Instant end = Instant.parse("2017-10-03T10:16:30.00Z");

        Duration duration = Duration.between(start, end);
        System.out.println(duration.isNegative());
        System.out.println(duration.getSeconds());
    }
}
