package com.xp.part12_date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * Created by xp-zhao on 2018/12/21.
 */
public class DateDemo
{
	public static void main(String[] args) {
//		LocalDate date = LocalDate.of(2014 , 3 , 18);
		LocalDate date = LocalDate.now();
		System.out.println(date.getYear());
		System.out.println(date.getMonth());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfWeek());
		System.out.println(date.isLeapYear());
		System.out.println(date.get(ChronoField.YEAR));
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		LocalDateTime tomorrow = dateTime.plusDays(1);
		System.out.println(tomorrow);
	}
}
