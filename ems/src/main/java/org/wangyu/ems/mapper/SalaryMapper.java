package org.wangyu.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wangyu.ems.entity.Salary;

@Mapper
public interface SalaryMapper {
	
	List<Salary> findAll();
	
	List<Salary> findById(@Param("id")int id);
	
	//List<Salary> findBySalaryName(@Param("name")String name);
	
	void update(Salary salary);
	
	void deleteById(@Param("id")int id);
	
	List<Salary> findDistinctSalary();
	
	int addSalary(Salary salary);
	
}
