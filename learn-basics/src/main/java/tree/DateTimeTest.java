package tree;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020/4/9
 **/
public class DateTimeTest {

  public static void main(String[] args) {
    BigDecimal zero = BigDecimal.ZERO;
    BigDecimal test = new BigDecimal(0);
    System.out.println(BigDecimal.valueOf(50).divide(BigDecimal.valueOf(100)));
    System.out.println(zero.setScale(2, BigDecimal.ROUND_HALF_UP));
    System.out.println(zero);
    System.out.println(test);
    System.out.println(LocalDateTime.now().toLocalDate().equals(LocalDate.of(2020, 4, 13)));
  }

  /**
   * 获取开始时间
   */
  public static String getStartTime() {
    SimpleDateFormat dtf = new SimpleDateFormat("yyyyMM");
    Calendar starCalendar = Calendar.getInstance();
    starCalendar.add(Calendar.MONTH, -2);
    Date starMonth = starCalendar.getTime();
    LocalDateTime monthDateTime = LocalDateTime
        .ofInstant(Instant.ofEpochMilli(starMonth.getTime()), ZoneId.systemDefault());
    LocalDateTime firstOfDay = monthDateTime.with(TemporalAdjusters.firstDayOfMonth())
        .with(LocalTime.MIN);
    Date firstdates = Date.from(firstOfDay.atZone(ZoneId.systemDefault()).toInstant());
    return dtf.format(firstdates);
  }

  /**
   * 获取结束时间
   */
  public static String getEndTime() {
    SimpleDateFormat dtf = new SimpleDateFormat("yyyyMM");
    Calendar endCalendar = Calendar.getInstance();
    endCalendar.add(Calendar.MONTH, -1);
    Date endMonth = endCalendar.getTime();
    LocalDateTime endMonthDateTime = LocalDateTime
        .ofInstant(Instant.ofEpochMilli(endMonth.getTime()), ZoneId.systemDefault());
    LocalDateTime endOfDay = endMonthDateTime.with(TemporalAdjusters.lastDayOfMonth())
        .with(LocalTime.MAX);
    Date enddates = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    return dtf.format(enddates);
  }
}
