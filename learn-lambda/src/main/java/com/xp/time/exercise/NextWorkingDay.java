package com.xp.time.exercise;

import java.time.DayOfWeek;
import java.time.temporal.*;

public class NextWorkingDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        // 获取当前日期
        DayOfWeek now = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_MONTH));
        // 默认加 1 天
        int dayToAdd = 1;
        if(now == DayOfWeek.FRIDAY){
            // 如果当前是星期五，则加 3 天
            dayToAdd = 3;
        }else if(now == DayOfWeek.SATURDAY){
            // 如果当前是星期六，则加 2 天
            dayToAdd = 2;
        }
        // 返回增加适当的天数后的日期
        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }
}
