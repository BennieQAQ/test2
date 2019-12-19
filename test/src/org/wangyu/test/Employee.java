package org.wangyu.test;

import java.util.Date;

public class Employee {

	private String name;
	private boolean gender;
	private Date birthday;
	private String workNumber;
	private int salary;

	public Employee() {
	}

	public Employee(String name, boolean gender, Date birthday, String workNumber, int salary) {
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.workNumber = workNumber;
		this.salary = salary;
	}

	public String info() {
		return "name=" + name + ",gender" + gender + ",birthday" + birthday + ",workNumber" + workNumber + ",salary"
				+ salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
