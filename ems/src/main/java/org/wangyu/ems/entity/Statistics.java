package org.wangyu.ems.entity;

public class Statistics {

	private Integer id;
	//年份
	private Integer year;
	//月份
	private Integer month;
	//基础工资
	private Double baseSalary;
	// 迟到次数
	private Integer lateCount;
	// 早退次数
	private Integer leaveCount;
	// 出席天数
	private Integer attendance;
	// 旷工天数
	private Integer absenteeismDay;
	// 应该天数
	private Integer originDay;
	// 实到天数
	private Integer actualDay;
	// 实际工资
	private Double finallySalary;
	private Integer employeeId;
	private Employee employee;

	public Statistics() {
		super();
	}

	public Statistics(Integer id, Double baseSalary, Integer lateCount, Integer leaveCount, Integer attendance,
			Integer absenteeismDay, Integer originDay, Integer actualDay, Double finallySalary, Integer employeeId,
			Employee employee) {
		super();
		this.id = id;
		this.baseSalary = baseSalary;
		this.lateCount = lateCount;
		this.leaveCount = leaveCount;
		this.attendance = attendance;
		this.absenteeismDay = absenteeismDay;
		this.originDay = originDay;
		this.actualDay = actualDay;
		this.finallySalary = finallySalary;
		this.employeeId = employeeId;
		this.employee = employee;
	}

	

	@Override
	public String toString() {
		return "Statistics [id=" + id + ", year=" + year + ", month=" + month + ", baseSalary=" + baseSalary
				+ ", lateCount=" + lateCount + ", leaveCount=" + leaveCount + ", attendance=" + attendance
				+ ", absenteeismDay=" + absenteeismDay + ", originDay=" + originDay + ", actualDay=" + actualDay
				+ ", finallySalary=" + finallySalary + ", employeeId=" + employeeId + ", employee=" + employee + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Integer getLateCount() {
		return lateCount;
	}

	public void setLateCount(Integer lateCount) {
		this.lateCount = lateCount;
	}

	public Integer getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(Integer leaveCount) {
		this.leaveCount = leaveCount;
	}

	public Integer getAttendance() {
		return attendance;
	}

	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}

	public Integer getAbsenteeismDay() {
		return absenteeismDay;
	}

	public void setAbsenteeismDay(Integer absenteeismDay) {
		this.absenteeismDay = absenteeismDay;
	}

	public Integer getOriginDay() {
		return originDay;
	}

	public void setOriginDay(Integer originDay) {
		this.originDay = originDay;
	}

	public Integer getActualDay() {
		return actualDay;
	}

	public void setActualDay(Integer actualDay) {
		this.actualDay = actualDay;
	}

	public Double getFinallySalary() {
		return finallySalary;
	}

	public void setFinallySalary(Double finallySalary) {
		this.finallySalary = finallySalary;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
