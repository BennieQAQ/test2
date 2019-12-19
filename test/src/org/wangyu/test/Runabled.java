package org.wangyu.test;

public class Runabled implements Runnable {

	@Override
	public void run() {
		for(char i = 'A'; i<'Z'; i++) {
			System.out.println(i);
		}
	}

}
