package org.wangyu.ems.util;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class CurrentTime {
	private  Calendar calender = Calendar.getInstance();
	
	public  int getYear() {
		int year = calender.get(Calendar.YEAR);
		return year; 
	}
	
	public  int getMonth() {
		int month = calender.get(Calendar.MONTH);
		return month+1;
	}
	
	

}
