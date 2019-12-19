package org.wangyu.test;

import java.util.Calendar;

public class Test03 {
	public static void main(String[] args) {
		
		Calendar calender = Calendar.getInstance();
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH);
		System.out.println(year);
		System.out.println(month+1);
	}

}
