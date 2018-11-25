package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.print.attribute.standard.RequestingUserName;

/**
 * 
 * @author zmeng
 *
 */
public class PhpDateUtils {
	public static String parseDate(long time,String formatString) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time  * 1000);
		calendar.add(Calendar.HOUR, 8);
		return new SimpleDateFormat(formatString).format(calendar.getTime());
	}
	
	
	public static long getTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, -8);
		return calendar.getTimeInMillis() / 1000L;
	}
	
	public static String getOrderSn() {
		Random random = new Random();
		int value = 10 + random.nextInt(89);
		return "y"+getTime()+value;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getOrderSn());
	}
}
