package org.wangyu.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wangyu.ems.entity.Dept;

@Mapper
public interface DeptMapper {
	
	int add(Dept dept);
	
	void deleteById(int id);
	
	void update(@Param("id")int id,@Param("status")boolean status);
	
	void updataName(Dept dept);
	
	List<Dept> findByName(@Param("deptName")String deptName);
	
	Dept findById(int id);
	
	List<Dept> findAll();
	

}
