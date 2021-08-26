package org.route.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Whattaday {
	Calendar cla = new GregorianCalendar();
	int day = cla.get(Calendar.DAY_OF_MONTH);
	int month = cla.get(Calendar.MONTH) + 1;
	int year = cla.get(Calendar.YEAR);
	int hour = cla.get(Calendar.HOUR_OF_DAY);
	int minutes = cla.get(Calendar.MINUTE);
	String daystr = Integer.toString(day);
	String monthstr = Integer.toString(month);
	String yearstr = Integer.toString(year);
	String hourstr = Integer.toString(hour);
	String minutesstr = Integer.toString(minutes);
	String alltogheter = daystr + "-" + monthstr + "-" + yearstr + "-" + hourstr + "-" + minutesstr;

}
