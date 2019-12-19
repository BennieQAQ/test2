package org.wangyu.test;

public class Test02 {
	public static void main(String[] args) {
		Runabled runable = new Runabled();
		Thread t1 = new Thread(runable);
		t1.start();
		
	}

}
