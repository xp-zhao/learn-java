package com.xp.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

/**
 * 以年、月、日 的方式衡量日期的长短
 */
public class PeriodDemo {
    public static void main(String[] args) {
        Period period = Period.between(LocalDate.of(2019, 4, 24),
                LocalDate.of(2019, 4, 1));
        System.out.println(period.getYears());
        System.out.println(period.getDays());
        LocalDate date = LocalDate.parse("2019-04-01");
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.MAX);
        System.out.println(dateTime);
        Integer num1 = 1001;
        Integer num2 = 1001;
        System.out.println(num1.equals(num2));
    }
}
