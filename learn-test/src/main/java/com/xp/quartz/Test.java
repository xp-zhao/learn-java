package com.xp.quartz;

import com.cronutils.model.Cron;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.parser.CronParser;
import org.quartz.CronExpression;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by xp-zhao on 2018/6/15.
 */
public class Test
{
	public static void main(String[] args)
	{
		Date curTime = new Date();
		System.out.println(curTime);

//		CronExpression expression;
//		try
//		{
////			expression = new CronExpression("0/5 * * * * ?");
//			expression = new CronExpression("0 0/1 * * * ?");
//			Date newDate = expression.getNextValidTimeAfter(curTime);
//			System.out.println(newDate);
//		} catch (ParseException e) {
//			System.out.println("fail to parse cron express");
//		} catch (Exception e) {
//			System.out.println("fail to update rule nextTime");
//		}
//		cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(QUARTZ);
//
//		CronParser parser = new CronParser(cronDefinition);
//		Cron quartzCron = parser.parse("0 23 * ? * 1-5 *");
	}
}
