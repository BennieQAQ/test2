package org.wangyu.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wangyu.ems.entity.RecordCheck;

@Mapper
public interface RecordCheckMapper {
	
	int add(RecordCheck recordCheck);
	
	List<RecordCheck> findByDay(RecordCheck recordCheck);
	
	RecordCheck  findById(@Param("CheckId")int CheckId);

}
