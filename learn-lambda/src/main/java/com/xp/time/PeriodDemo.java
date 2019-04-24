package com.xp.time;

import java.time.LocalDate;
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
    }
}
