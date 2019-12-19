package org.wangyu.ems.service;

import java.util.List;

import org.wangyu.ems.entity.RecordCheck;
import org.wangyu.ems.entity.Statistics;

public interface IAttendanceService {
	
	int addRecord(RecordCheck recordCheck);
	
	int appendStatistics(RecordCheck recordCheck);
	
	RecordCheck QueryByCheckId(int CheckId);
	
	List<RecordCheck> QueryByDay(RecordCheck recordCheck);
	
	void modifyStatistics(RecordCheck recordCheck);
	
	List<Statistics> ConditionsQuery(String name);
	
	List<Statistics> findByEmployeeId(int EmployeeId);
	
	List<Statistics> QueryByCheckRecord(RecordCheck recordCheck);
	
	List<Statistics> QueryStatisticsAll();

	void Signback(RecordCheck recordCheck);
	
	void Signback02(RecordCheck recordCheck);

}
