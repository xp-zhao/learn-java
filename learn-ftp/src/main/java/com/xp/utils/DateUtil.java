package com.xp.utils;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.util.StringUtils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xp-zhao on 2018/5/3.
 */
public class DateUtil
{
	public static final String PATTERN_DEFAULT = "yyyy-MM-dd";
	public static final String FULL_STANDARD_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	public static final String STANDARD_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String INCOMPLETE_DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String SHORT_DATETIME_FORMAT = "yyyyMMddHHmmss";
	public static final String STANDARD_MONTH_FORMAT = "yyyy-MM";
	public static final String SHORT_DATE_FORMAT = "yyyyMMdd";
	public static final String SHORT_MMDD_FORMAT = "MM-dd";
	public static final String SHORT_TIME_FORMAT = "HHmmss";
	public static final String STANDARD_TIME_FORMAT = "HH:mm:ss";
	public static final String STANDARD_DATE_FORMAT_NYR = "yyyy年MM月dd日";

	public static String changeDateStrFormate(String dateStr, String src, String dest)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(src);
		Date date = sdf.parse(dateStr);
		sdf = new SimpleDateFormat(dest);
		return sdf.format(date);
	}

	public static String getCurDateStr(String pattern)
	{
		String dateStr = null;
		try
		{
			if (!StringUtils.isEmpty(pattern))
			{
				dateStr = DateFormatUtils.format(new Date(), pattern);
			}
			else
			{
				dateStr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dateStr;
	}

	public static Date getDateByString(String dateStr, String pattern)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}

	public static String getStringByDate(Date date, String pattern)
		throws ParseException
	{
		if (StringUtils.isEmpty(pattern))
		{
			return getDefaultDateFormat().format(date);
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	private static SimpleDateFormat getDefaultDateFormat()
	{
		return new SimpleDateFormat("yyyy-MM-dd");
	}

	public static String formatFullStandardDateTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		return sdf.format(date);
	}

	public static String formatStandardDateTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static String formatShortDateTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	public static String formatStandardDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static String formatStandardMonth(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.format(date);
	}

	public static String formatShortDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}

	public static String formatShortMMDDDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return sdf.format(date);
	}

	public static String formatShortTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return sdf.format(date);
	}

	public static Date parseFullStandardDateTime(String dateTimeStr)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		return sdf.parse(dateTimeStr);
	}

	public static Date parseStandardDateTime(String dateTimeStr)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(dateTimeStr);
	}

	public static Date parseIncompleteDateTime(String dateTimeStr)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.parse(dateTimeStr);
	}

	public static String formatIncompleteDateTime(Date dateTime)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(dateTime);
	}

	public static Date parseShortDateTime(String dateTimeStr)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.parse(dateTimeStr);
	}

	public static Date parseStandardDate(String dateStr)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(dateStr);
	}

	public static Date parseStandardMonth(String dateStr)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.parse(dateStr);
	}

	public static Date parseShortDate(String dateStr)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.parse(dateStr);
	}

	public static Date parseShortMMDDDate(String dateStr)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return sdf.parse(dateStr);
	}

	public static Date parseShortTime(String dateStr)
		throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return sdf.parse(dateStr);
	}

	public static String formatStandardTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
	}

	public static Date getStandardDatePre(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(5, -1);
		return cal.getTime();
	}

	public static Date getStandardDateNext(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(5, 1);
		return cal.getTime();
	}

	public static Date getStartTimeOfDay(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(14, 0);
		return cal.getTime();
	}

	public static Date getStartTimeOfToday()
	{
		return getStartTimeOfDay(new Date());
	}

	public static final String getTimestep4CurrentdateSwitchV3()
	{
		Format formatter = new SimpleDateFormat("yyyyMMdd:HHmmss");
		return formatter.format(new Date());
	}

	public static String formatStandardDateNYR(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(date);
	}

	public static String formatStandardDateNYR(String dateTimeStr)
	{
		try
		{
			Date date = parseStandardDateTime(dateTimeStr);
			return formatStandardDateNYR(date);
		}
		catch (ParseException e) {
		}
		return "";
	}

	public static int getDateFlag(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(7, 2);
		Date thisWeekStart = null;
		Date lastWeekStart = null;
		try
		{
			String strThisWeek = formatStandardDate(cal.getTime());
			thisWeekStart = parseStandardDateTime(strThisWeek + " 00:00:00");
			cal.add(3, -1);
			String strLastWeek = formatStandardDate(cal.getTime());
			lastWeekStart = parseStandardDateTime(strLastWeek + " 00:00:00");
		}
		catch (Exception e)
		{
			return 2;
		}
		if (date.after(thisWeekStart))
			return 0;
		if (date.after(lastWeekStart)) {
			return 1;
		}
		return 2;
	}
}
