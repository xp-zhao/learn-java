package com.xp.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * 同时表示时期和时间
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2019, Month.APRIL, 24, 11, 36, 40);
        // 格式化显示
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime1 = LocalDateTime.of(date, time);
        System.out.println(dateTime);
        System.out.println(dateTime1);

        LocalDate date1 = dateTime.toLocalDate();
        System.out.println(date1);
        LocalTime time1 = dateTime.toLocalTime();
        System.out.println(time1);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.of(LocalDate.parse("2019-05-06"), LocalTime.now()));

//        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime time2 = LocalDateTime.now();
//        String localTime = df1.format(time2);
//        LocalDateTime ldt = LocalDateTime.parse("2018-06-01",df1);
//        System.out.println("LocalDateTime转成String类型的时间："+localTime);
//        System.out.println("String类型的时间转成LocalDateTime："+ldt);
    }
}
