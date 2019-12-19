package org.wangyu.test;

public class Person {

	private Integer hight;

	public Person() {
		super();
	}

	public Person(Integer hight) {
		super();
		this.hight = hight;
	}
	
	

	public Integer getHight() {
		return hight;
	}

	public void setHight(Integer hight) {
		this.hight = hight;
	}

	public void sleep() {
			System.out.println("睡觉");
	}

}
