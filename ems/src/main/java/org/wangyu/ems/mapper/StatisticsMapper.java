package org.wangyu.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wangyu.ems.entity.RecordCheck;
import org.wangyu.ems.entity.Statistics;

@Mapper
public interface StatisticsMapper {

	int add(Statistics statistics);
	
	void modify(Statistics statistics);
	
	Statistics findByYearAndMonth(@Param("year")int year,@Param("month")int month,@Param("employeeId")int employeeId);
	
	List<Statistics> findByCheckRecord(RecordCheck recordCheck);

	List<Statistics> findByEmployeeId(@Param("employeeId")int employeeId);
	
	List<Statistics> findAll();
	

}
