package com.xp.time;

import com.xp.time.exercise.NextWorkingDay;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.*;

/**
 * 获取日期，不包含当天的时间
 */
public class LocalDateDemo {
    public static void main(String[] args) {
        // 通过静态方法构造实例
//        LocalDate date = LocalDate.of(2019, 4, 24);
        // 从系统时钟中获取当前时间
//        LocalDate date = LocalDate.now();
        // 通过字符串创建
        LocalDate date = LocalDate.parse("2019-04-01");
        // 获取年份
        int year = date.getYear();
        System.out.printf("当前年份是：%d\n", year);
        // 获取月份
        Month month = date.getMonth();
        System.out.printf("当前月份是：%s\n", month);
        // 获取今天是星期几
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.printf("今天是星期几：%s\n",dayOfWeek);
        // 获取本月有多少天
        int len = date.lengthOfMonth();
        System.out.printf("本月有多少天： %d\n", len);
        // 判断是不是闰年
        boolean flag = date.isLeapYear();
        System.out.printf("今年是否是闰年：%s\n", flag);

        // 使用 TemporalField 获取 LocalDate 的值
        int t_year = date.get(ChronoField.YEAR);
        int t_month = date.get(ChronoField.MONTH_OF_YEAR);
        int t_day = date.get(ChronoField.DAY_OF_MONTH);
        System.out.printf("%d 年 %d 月 %d 日\n", t_year, t_month, t_day);


        // 修改时间
        LocalDate date1 = LocalDate.now();
        System.out.println(date1);
        System.out.println(date1.plusWeeks(1));
        System.out.println(date1.minusYears(3));
        System.out.println(date1.plus(6, ChronoUnit.MONTHS));

        // 使用预定义的 TemporalAdjuster
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.lastDayOfYear();
        LocalDate date2 = date1.with(temporalAdjuster);
        System.out.println(date2);

        // 使用自定义的 TemporalAdjuster
        LocalDate date4 = date.with(new NextWorkingDay());
        System.out.printf("下一个工作日：%s", date4);
    }
}
