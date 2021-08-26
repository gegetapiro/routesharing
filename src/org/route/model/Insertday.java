package org.route.model;

import java.security.AllPermission;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Insertday {
	String daystr;
	String monthstr;
	String yearstr;
	String hourstr;
	String minutesstr;
	String alltogheter;

	public Insertday() {
		Calendar cla = new GregorianCalendar();
		int day = cla.get(Calendar.DAY_OF_MONTH);
		int month = cla.get(Calendar.MONTH) + 1;
		int year = cla.get(Calendar.YEAR);
		int hour = cla.get(Calendar.HOUR_OF_DAY);
		int minutes = cla.get(Calendar.MINUTE);
		daystr = Integer.toString(day);
		monthstr = Integer.toString(month);
		yearstr = Integer.toString(year);
		hourstr = Integer.toString(hour);
		minutesstr = Integer.toString(minutes);
		alltogheter = daystr + "-" + monthstr + "-" + yearstr + "-" + hourstr + "-" + minutesstr;
	}

	public String getInsertday() {
		return alltogheter;
	}
}
