package com.xp.quartz;

import com.cronutils.mapper.CronMapper;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
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
		String cron = "0/5 * * * * ?";
		CronExpression expression;
		try
		{
			expression = new CronExpression(cron);
			Date newDate = expression.getNextValidTimeAfter(curTime);
			System.out.println(newDate);
		} catch (ParseException e) {
			System.out.println("fail to parse cron express");
		} catch (Exception e) {
			System.out.println("fail to update rule nextTime");
		}
//		cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(QUARTZ);
//
//		CronParser parser = new CronParser(cronDefinition);
//		Cron quartzCron = parser.parse("0 23 * ? * 1-5 *");
	}

	public static void test()
	{
		CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);
		CronParser parser = new CronParser(cronDefinition);
		Cron quartzCron = parser.parse("0 23 * ? * 1-5 *");
//		CronMapper cronMapper = CronMapper.fromQuartzToCron4j();
		CronMapper cronMapper = CronMapper.fromQuartzToUnix();
		Cron cron4jCron = cronMapper.map(quartzCron);
		System.out.println(cron4jCron.asString());//will return: 23 * * * 1-5
	}

	public static void test2()
	{
		CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.UNIX);
		CronParser parser = new CronParser(cronDefinition);
		Cron quartzCron = parser.parse("0/5 * * * * ?");
		CronMapper cronMapper = CronMapper.fromUnixToQuartz();
		Cron cron4jCron = cronMapper.map(quartzCron);
		String cron = cron4jCron.asString();
		System.out.println(cron);
		CronExpression expression;
		try
		{
			expression = new CronExpression(cron);
			Date newDate = expression.getNextValidTimeAfter(new Date());
			System.out.println(newDate);
		} catch (ParseException e) {
			System.out.println("fail to parse cron express");
		} catch (Exception e) {
			System.out.println("fail to update rule nextTime");
		}
	}
}
