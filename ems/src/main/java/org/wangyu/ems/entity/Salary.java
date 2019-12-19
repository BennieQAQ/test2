package org.wangyu.ems.entity;

import java.util.List;

public class Salary {
	private Integer id;
	private Integer year;
	private Integer month;
	private Integer employeeId;// 员工ID
	private Double endowmentInsurance;// 养老保险
	private Double medicalInsurance;// 医疗保险
	private Double injuryInsurance;// 工伤保险
	private Double birthInsurance;// 生育保险
	private Double unemployInsurance;// 失业保险
	private Employee emp;
	private List<Employee> employee; // 员工集合

	public Salary() {
		super();
	}

	public Salary(Integer id, Integer year, Integer month, Integer employeeId, Double endowmentInsurance,
			Double medicalInsurance, Double injuryInsurance, Double birthInsurance, Double unemployInsurance,
			List<Employee> employee, Employee emp) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.employeeId = employeeId;
		this.endowmentInsurance = endowmentInsurance;
		this.medicalInsurance = medicalInsurance;
		this.injuryInsurance = injuryInsurance;
		this.birthInsurance = birthInsurance;
		this.unemployInsurance = unemployInsurance;
		this.employee = employee;
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", year=" + year + ", month=" + month + ", employeeId=" + employeeId
				+ ", endowmentInsurance=" + endowmentInsurance + ", medicalInsurance=" + medicalInsurance
				+ ", injuryInsurance=" + injuryInsurance + ", birthInsurance=" + birthInsurance + ", unemployInsurance="
				+ unemployInsurance + ", employee=" + employee + "]";
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

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Double getEndowmentInsurance() {
		return endowmentInsurance;
	}

	public void setEndowmentInsurance(Double endowmentInsurance) {
		this.endowmentInsurance = endowmentInsurance;
	}

	public Double getMedicalInsurance() {
		return medicalInsurance;
	}

	public void setMedicalInsurance(Double medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}

	public Double getInjuryInsurance() {
		return injuryInsurance;
	}

	public void setInjuryInsurance(Double injuryInsurance) {
		this.injuryInsurance = injuryInsurance;
	}

	public Double getBirthInsurance() {
		return birthInsurance;
	}

	public void setBirthInsurance(Double birthInsurance) {
		this.birthInsurance = birthInsurance;
	}

	public Double getUnemployInsurance() {
		return unemployInsurance;
	}

	public void setUnemployInsurance(Double unemployInsurance) {
		this.unemployInsurance = unemployInsurance;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
