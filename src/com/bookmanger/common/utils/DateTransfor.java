package com.bookmanger.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTransfor {
	private static GregorianCalendar gc = new GregorianCalendar();
	/**
	 * 加减天数
	 * 
	 * @param days
	 *            +,-为加减天数 如：+15，-15
	 * @param format
	 * @param dstf 被处理的时间
	 * @return
	 */
	public static String addordecDay(int days, String format, String dstf) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date d=null;
		try {
			d = sf.parse(dstf);
		} catch (Exception e) {

		}
		gc.setTime(d);
		gc.add(5, days);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH),
				gc.get(Calendar.DATE));
		return sf.format(gc.getTime()).toString();
	}

	/**
	 * 加减天数
	 * @param days
	 * @param format
	 * @param dstf
	 * @return
	 */
	public static java.sql.Date addordecDayAsDate(int days, java.sql.Date dstf) {
		Date d = new Date();
		d=new Date(dstf.getTime());
		gc.setTime(d);
		gc.add(5, days);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH),
				gc.get(Calendar.DATE));
		
		 
		return new java.sql.Date(gc.getTime().getTime());
	}
	
	/**
	 * 计算时间差
	 * 
	 * @param str1
	 *            最近时间
	 * @param str2
	 *            老时间
	 * @param style
	 *            year/day/minute
	 * @return
	 */
	public static String timeXiangJian(String str1, String str2) {
		long days=0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = df.parse(str1);
			Date d2 = df.parse(str2);
			gc.setTime(d1);
			long beginTime=gc.getTimeInMillis();
			gc.setTime(d2);
			long endTime=gc.getTimeInMillis();
			long diff = beginTime-endTime;// 这样得到的差值是微秒级别
			days = diff / (1000 * 60 * 60 * 24);

			
		} catch (Exception e) {
		}
		return days+"";
	}
	/**
	 * 获得现在时间
	 * @return
	 */
	public static String getNowDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date()).toString();
	}
	/**
	 * 获得现在时间
	 * @return
	 */
	public static java.sql.Date getNowDateAsDate(){
		return new java.sql.Date(new Date().getTime());
	}
	
}
