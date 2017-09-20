package com.Cucumber.framework.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHelper {

	public static String getCurrentDateTime() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
		return df.format(date);
	}

	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("_yyyy_MM_dd");
		return df.format(date);
	}

}
