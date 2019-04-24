package com.xp.time;

import java.time.LocalTime;

/**
 * 获取一天中的时间
 */
public class LocalTimeDemo {
    public static void main(String[] args) {
        // 构造时间
//        LocalTime time = LocalTime.of(11, 30, 30);
        LocalTime time = LocalTime.parse("11:30:40");
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        System.out.printf("%d 时 %d 分 %d 秒", hour, minute, second);

    }
}
