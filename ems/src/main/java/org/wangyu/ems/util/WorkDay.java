package org.wangyu.ems.util;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class WorkDay {

	public static int workDayCount(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int start = 1;
		int count = 0;
		while (start < max) {
			cal.set(Calendar.DAY_OF_MONTH, start);
			if (isWorkDay(cal)) {
				count++;
			}
			start++;
		}
		return count;
	}

	public static boolean isWorkDay(Calendar c) {
		int week = c.get(Calendar.DAY_OF_WEEK);
		return week != Calendar.SUNDAY && week != Calendar.SATURDAY;
	}

}
