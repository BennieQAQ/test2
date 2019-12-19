package org.wangyu.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
	
	public static void main(String[] args) {
			
			Thread t1 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(char i='A';i<='Z';i++) {
						System.out.println(i);
					}
				}
			});
			Thread t2 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(char i='a';i<='z';i++) {
						System.out.println(i);
					}
				}
			});
			
			t1.start();
			t2.start();		
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-20");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
	}

}
