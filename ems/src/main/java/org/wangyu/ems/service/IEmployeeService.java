package org.wangyu.ems.service;

import java.util.List;

import org.wangyu.ems.entity.Employee;

public interface IEmployeeService {
	
	int register(Employee employee);
	
	void modify(Employee employee);
	
	void remove(int id);
	
	Employee login(String account,String password);
	
	List<Employee> QueryAll();
	
	int QueryCount();
	
	List<Employee> QueryByName(String name);
	
	List<Employee> QueryByPage(int start,int length);
	
	Employee QueryById(int id);
	
	

}
