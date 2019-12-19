package org.wangyu.ems.entity;

public class Title {

	private Integer id;
	private String titleName;
	private Double baseSalary;
	private Integer deptId;
	private Dept dept;

	public Title() {
		super();
	}

	public Title(Integer id, String titleName, Double baseSalary, Integer deptId, Dept dept) {
		super();
		this.id = id;
		this.titleName = titleName;
		this.baseSalary = baseSalary;
		this.deptId = deptId;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Title [id=" + id + ", titleName=" + titleName + ", baseSalary=" + baseSalary + ", deptId=" + deptId
				+ ", dept=" + dept + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}
