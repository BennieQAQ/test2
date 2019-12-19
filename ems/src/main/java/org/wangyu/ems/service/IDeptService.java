package org.wangyu.ems.service;

import java.util.List;

import org.wangyu.ems.entity.Dept;

public interface IDeptService {

	int appendDept(Dept dept);
	
	void removeById(int id,boolean status);
	
	void modify(Dept dept);
	
	List<Dept> QueryAll();
	
	List<Dept> QueryByName(String deptName);
	
	Dept QueryById(int id);
	

}
