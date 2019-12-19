package org.wangyu.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wangyu.ems.entity.Title;

@Mapper
public interface TitleMapper {

	int add(Title title);

	void deleteById(@Param("id") int id);

	void update(Title title);

	List<Title> findAll();
	
	List<Title> findByName(@Param("titleName")String titleName);
	
	List<Title> findByDeptId(@Param("DeptId")int DeptId);

	Title findById(@Param("id") int id);

}
