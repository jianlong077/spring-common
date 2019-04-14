package com.spring.base.common.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class DateUtil {
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

	public DateUtil() {
	}

	/**
	 * 获取当前时间
	 * 
	 * @param format
	 * @return
	 */
	public static String now(String format) {
		if (StringUtils.isEmpty(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(new Date());
	}

	/**
	 * 获取当前日期 字符型
	 * 
	 * @return
	 */
	public static String date() {
		String format = "yyyy-MM-dd";
		SimpleDateFormat f = new SimpleDateFormat(format);
		return f.format(new Date());
	}

	/**
	 * 获取当前日期Date型
	 * 
	 * @return
	 */
	public static Date currentDate() {
		String format = "yyyy-MM-dd";
		SimpleDateFormat f = new SimpleDateFormat(format);
		String d = f.format(new Date());
		return getDateFromString(d, format);
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * 获取的当前时间毫秒
	 * 
	 * @return
	 */
	public static long nowMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 字符转日期
	 * 
	 * @param str
	 * @param fm
	 * @return
	 */
	public static Date StrToDate(String str, String fm) {
		if (StringUtils.isEmpty(fm)) {
			fm = "yyyy-MM-dd HH:mm:ss";
		}

		if (str != null) {
			SimpleDateFormat format = new SimpleDateFormat(fm);
			Date date = null;

			try {
				date = format.parse(str);
			} catch (ParseException var5) {
				log.error("", var5);
			}

			return date;
		} else {
			return null;
		}
	}

	public static String taskDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("s m H d M ? yyyy");
		Date now = new Date();
		String cron = null;
		if (now.getTime() > date.getTime()) {
			cron = sdf.format(new Date(now.getTime() + 5000L));
		} else {
			cron = sdf.format(date);
		}

		return cron;
	}

	/**
	 * 日期转字符
	 * 
	 * @param sourceDate
	 * @param format
	 * @return
	 */
	public static String formatDate(Date sourceDate, String format) {
		if (sourceDate == null) {
			return "";
		} else {
			if (format.isEmpty()) {
				format = "yyyy-MM-dd HH:mm:ss";
			}

			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sourceDate);
			return dateFormat.format(calendar.getTime());
		}
	}

	public static Date getAddDate(Date sourceDate, int type, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sourceDate);
		calendar.add(type, count);
		return calendar.getTime();
	}

	/**
	 * 当前日期加天数
	 * 
	 * @param sourceDate
	 * @param day
	 * @return
	 */
	public static Date getAddDateByDay(Date sourceDate, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sourceDate);
		calendar.add(5, day);
		return calendar.getTime();
	}

	/**
	 * 当前日期加秒
	 * 
	 * @param sourceDate
	 * @param second
	 * @return
	 */
	public static Date getAddDateBySecond(Date sourceDate, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sourceDate);
		calendar.add(13, second);
		return calendar.getTime();
	}

	/**
	 * 当前日期加秒格式化返回字符
	 * 
	 * @param sourceDate
	 * @param second
	 * @param format
	 * @return
	 */
	public static String getAddDateBySecond(Date sourceDate, int second, String format) {
		if (format.isEmpty()) {
			format = "yyyy-MM-dd HH:mm:ss";
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(getAddDateBySecond(sourceDate, second));
	}

	/**
	 * 字符日期转date
	 * 
	 * @param k
	 * @param dateformat
	 * @return
	 */
	public static Date getDateFromString(String k, String dateformat) {
		if (dateformat.isEmpty()) {
			dateformat = "yyyy-MM-dd HH:mm:ss";
		}

		try {
			SimpleDateFormat format = new SimpleDateFormat(dateformat);
			format.setLenient(false);
			return format.parse(k);
		} catch (ParseException var3) {
			return null;
		}
	}

	/**
	 * 字符日期转date
	 * 
	 * @param k
	 * @param dateformat
	 * @return
	 */
	public static Date getDateFromString(String k) {
		return getDateFromString(k, "yyyy-MM-dd HH:mm:ss");
	}

	public static boolean checkDate(String k, String dateformat) {
		return getDateFromString(k, dateformat) != null;
	}

	/**
	 * 当前日期比较（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param k
	 * @param dateformat
	 * @return
	 */
	public static long dateTimeCompare(String sdate, String edate) {
		long day = 0L;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date begin_date = format.parse(sdate);
			Date end_date = format.parse(edate);
			day = (end_date.getTime() - begin_date.getTime()) / 1000L;
			return day;
		} catch (Exception var7) {
			return -1L;
		}
	}

	/**
	 * 当前日期比较（yyyy-MM-dd）
	 * 
	 * @param k
	 * @param dateformat
	 * @return
	 */
	public static long dateCompare(String sdate, String edate) {
		long day = 0L;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date begin_date = format.parse(sdate);
			Date end_date = format.parse(edate);
			day = (end_date.getTime() - begin_date.getTime()) / 86400000L;
			return day;
		} catch (Exception var7) {
			return -1L;
		}
	}

	/**
	 * 当前日期比较（由毫秒开始）
	 * 
	 * @param sdate
	 * @param edate
	 * @return
	 */

	public static long dateTimeCompare(Date sdate, Date edate) {
		long day = (edate.getTime() - sdate.getTime()) / 1000L;
		return day;
	}

	/**
	 * 当前日期比较（由毫秒开始）
	 * 
	 * @param sdate
	 * @param edate
	 * @return
	 */
	public static long getDateDiffSecond(String sdate, String edate) {
		long day = 0L;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date begin_date = format.parse(sdate);
			Date end_date = format.parse(edate);
			day = (end_date.getTime() - begin_date.getTime()) / 1000L;
			return day;
		} catch (Exception var7) {
			return -1L;
		}
	}
	public static double getDateDiffSecond(Long sdate, Long edate) {
		double diffSecond = 0L;

		try {
			diffSecond = (edate - sdate) / 1000.0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffSecond;
	}
	/**
	 * 
	 * @param sdate
	 * @param edate
	 * @return
	 */
	public static long getDateDiffSecond(Date sdate, Date edate) {
		long day = 0L;

		try {
			day = (edate.getTime() - sdate.getTime()) / 1000L;
			return day;
		} catch (Exception var5) {
			return -1L;
		}
	}

	public static String getWeekOfDate(Date date) {
		String[] weekOfDays = new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}

		int w = calendar.get(7) - 1;
		if (w < 0) {
			w = 0;
		}

		return weekOfDays[w];
	}

	/**
	 * 获得当前是一周的第几天 周一 是1 周二是2....周日是7
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekIndexOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}

		int w = calendar.get(7) - 1;
		if (w < 0) {
			w = 0;
		}

		return w == 0 ? 7 : w;
	}

	public static String getWeekOfDate(int weekIndex) {
		String[] weekOfDays = new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		return weekIndex >= 0 && weekIndex <= 6 ? weekOfDays[weekIndex] : "";
	}

	public static String getShortWeekOfDate(int weekIndex) {
		String s = getWeekOfDate(weekIndex);
		return s.replace("星期", "周");
	}

	public static String getShortWeekOfDate(Date date) {
		String s = getWeekOfDate(date);
		return s.replace("星期", "周");
	}

	public static String formatDateChina(String SourceDate, String format) {
		Date d = new Date(dateToTimestamp(SourceDate) * 1000L);
		if (format.isEmpty()) {
			format = "MM月dd日";
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return dateFormat.format(calendar.getTime());
	}

	public static long dateToTimestamp(String dateString) {
		return dateToTimestamp(dateString, "yyyy-MM-dd HH:mm:ss");
	}

	public static long dateToTimestamp(String dateString, String format) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(format);

			Date date;
			try {
				date = df.parse(dateString);
			} catch (ParseException var6) {
				df = new SimpleDateFormat("yyyy-MM-dd");
				date = df.parse(dateString);
			}

			long s = date.getTime();
			return s / 1000L;
		} catch (ParseException var7) {
			var7.printStackTrace();
			return 0L;
		}
	}

	public static String getDateName(String date) {
		if (date != null && !date.isEmpty()) {
			int l = (int) getDateDiff(date(), date);
			if (l == 0) {
				return "今日";
			} else if (l == 1) {
				return "明日";
			} else {
				return l == 2 ? "后日" : formatDateChina(date, "M月d日");
			}
		} else {
			return "7日后";
		}
	}

	/**
	 * 求两个日期相差多少天
	 * 
	 * @param sdate
	 * @param edate
	 * @return
	 */
	public static long getDateDiff(String sdate, String edate) {
		long day = 0L;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date begin_date = format.parse(sdate);
			Date end_date = format.parse(edate);
			day = (end_date.getTime() - begin_date.getTime()) / 86400000L;
			return day;
		} catch (Exception var7) {
			return -1L;
		}
	}

}
