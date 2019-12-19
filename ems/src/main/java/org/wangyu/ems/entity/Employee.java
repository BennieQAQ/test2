package org.wangyu.ems.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
	private Integer id;
	private String name;
	private String account;
	private String password;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birthday;
	private Boolean gender;
	private String phone;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date startDate;
	private Integer titleId;
	private Integer deptId;
	private String workNumber;
	private Integer roleId;
	private Integer status;
	private Dept dept;
	private Title title;  
	private List<RecordCheck> RecordCheck;
	private List<Statistics> statistics;

	public Employee() {
		super();
	}

	public Employee(Integer id, String name, String account, String password, Date birthday, Boolean gender,
			String phone, Date startDate, Integer titleId, Integer deptId, String workNumber, Integer roleId,
			Integer status, List<org.wangyu.ems.entity.RecordCheck> recordCheck) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.startDate = startDate;
		this.titleId = titleId;
		this.deptId = deptId;
		this.workNumber = workNumber;
		this.roleId = roleId;
		this.status = status;
		RecordCheck = recordCheck;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password
				+ ", birthday=" + birthday + ", gender=" + gender + ", phone=" + phone + ", startDate=" + startDate
				+ ", titleId=" + titleId + ", deptId=" + deptId + ", workNumber=" + workNumber + ", roleId=" + roleId
				+ ", status=" + status + ", RecordCheck=" + RecordCheck + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RecordCheck> getRecordCheck() {
		return RecordCheck;
	}

	public void setRecordCheck(List<RecordCheck> recordCheck) {
		RecordCheck = recordCheck;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public List<Statistics> getStatistics() {
		return statistics;
	}

	public void setStatistics(List<Statistics> statistics) {
		this.statistics = statistics;
	}
	
	
	
	

}
