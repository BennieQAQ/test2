package org.wangyu.ems.entity;

import java.util.Date;

public class RecordCheck {
	private Integer id;
	private Integer employeeId;
	private Integer year;
	private Integer month;
	private Integer day;
	private Date checkTime;
	private Employee employee;

	public RecordCheck() {
		super();
	}

	public RecordCheck(Integer id, Integer employeeId, Integer year, Integer month, Integer day, Date checkTime) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.year = year;
		this.month = month;
		this.day = day;
		this.checkTime = checkTime;
	}

	@Override
	public String toString() {
		return "RecordCheck [id=" + id + ", employeeId=" + employeeId + ", year=" + year + ", month=" + month + ", day="
				+ day + ", check_Time=" + checkTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}


	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
