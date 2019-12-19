package org.wangyu.test;

import java.util.Date;

public class TestMain {
	
	public static void main(String[] args) {
		Employee employee = new Employee("zhangsan", true, new Date(), "NO-001",10000 );
		employee.getClass();
		System.out.println(employee.info());
		employee.setName("lisi");
		System.out.println(employee.info());
	}

}
