package org.cjh.javabasic.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TimeTest {

	@Test
	public void format() {
		String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
		DateFormat format = new SimpleDateFormat(dateTimePattern);
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTimeInMillis()); // the current time as UTC milliseconds from the epoch
		String str = format.format(c.getTime());
		System.out.println(str);
		
	}
	
	@Test
	public void zeroClock() throws Exception {
		String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
		DateFormat format = new SimpleDateFormat(dateTimePattern);
		Date dateTime = format.parse("2018-02-27 00:00:00");
		String str = format.format(dateTime.getTime());
		System.out.println(str);
		
	}
	
	@Test
	public void calendar() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTimeInMillis()); // the current time as UTC milliseconds from the epoch
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
		String str = format.format(c.getTime());
		System.out.println(str);
		
	}
	
	@Test
	public void time() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.toString());
		// the current time as UTC milliseconds from the epoch
		System.out.println(c.getTimeInMillis()); 
		System.out.println(c.getTime().getTime());
	}
	
	@Test
	public void firstDayofMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 获取前月的第一天
		Calendar now = Calendar.getInstance();// 获取当前日期
		now.add(Calendar.MONTH, -1);
		now.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String firstDay = format.format(now.getTime());
		System.out.println("-----1------firstDay:" + firstDay);
		// 获取前月的最后一天
		now = Calendar.getInstance();
		now.set(Calendar.DAY_OF_MONTH, 0);// 设置为1号,当前日期既为本月第一天
		String lastDay = format.format(now.getTime());
		System.out.println("-----2------lastDay:" + lastDay);
		// 获取当前月第一天：
		now = Calendar.getInstance();
		now.add(Calendar.MONTH, 0);
		now.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(now.getTime());
		System.out.println("===============first:" + first);
		// 获取当前月最后一天
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH,
				ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		System.out.println("===============last:" + last);
	}
	
	@Test
	public void parse() {
		String pattern = "MM/dd/yy";
		DateFormat format = new SimpleDateFormat(pattern);
		String str = "02/26/18";
		try {
			System.out.println(format.parse(str));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
