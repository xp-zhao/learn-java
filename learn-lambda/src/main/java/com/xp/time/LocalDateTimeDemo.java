package com.xp.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * 同时表示时期和时间
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2019, Month.APRIL, 24, 11, 36, 40);
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime1 = LocalDateTime.of(date, time);
        System.out.println(dateTime);
        System.out.println(dateTime1);

        LocalDate date1 = dateTime.toLocalDate();
        System.out.println(date1);
        LocalTime time1 = dateTime.toLocalTime();
        System.out.println(time1);
    }
}
