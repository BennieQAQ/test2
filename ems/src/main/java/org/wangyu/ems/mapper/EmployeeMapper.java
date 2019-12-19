package org.wangyu.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wangyu.ems.entity.Employee;

@Mapper
public interface EmployeeMapper {
	
	int add(Employee employee);
	
	void deleteById(int id);
	
	void update(Employee employee);
	
	void updateById(@Param("id")int id);
	
	Employee findById(int id);
	
	int findCount();
	
	List<Employee> findByName(@Param("name")String name);
	
	List<Employee> findByPage(@Param("start")int start,@Param("length")int length);
	
	Employee findByAccounAndPassword(@Param("account")String account,
			@Param("password")String password);
	
	List<Employee> findAll();

}
