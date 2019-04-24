package com.xp.time;

import java.time.Duration;
import java.time.LocalTime;

/**
 * 以 秒 和 纳秒衡量时间的长短
 */
public class DurationDemo {
    public static void main(String[] args) {
        Duration duration = Duration.between(LocalTime.of(11,30,24),
                LocalTime.of(11,53,1));
        System.out.println(duration.getSeconds());
    }
}
