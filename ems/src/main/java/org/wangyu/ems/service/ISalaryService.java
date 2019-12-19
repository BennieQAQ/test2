package org.wangyu.ems.service;

import java.util.List;

import org.wangyu.ems.entity.Salary;

public interface ISalaryService {
	
	List<Salary> QueryAll();
	
	List<Salary> QueryByName(String name);

}
