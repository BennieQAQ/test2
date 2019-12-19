package org.wangyu.ems.entity;

import java.util.List;

public class Dept {
	private Integer id;
	private String deptName;
	private Boolean status;
	private List<Title> titleList;

	public Dept() {
		super();
	}

	public Dept(Integer id, String deptName, Boolean status, List<Title> titleList) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.status = status;
		this.titleList = titleList;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", status=" + status + ", titleList=" + titleList + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Title> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<Title> titleList) {
		this.titleList = titleList;
	}

}
