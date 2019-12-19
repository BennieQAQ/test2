package org.wangyu.ems.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangyu.ems.entity.Employee;
import org.wangyu.ems.entity.RecordCheck;
import org.wangyu.ems.entity.Statistics;
import org.wangyu.ems.mapper.EmployeeMapper;
import org.wangyu.ems.mapper.RecordCheckMapper;
import org.wangyu.ems.mapper.StatisticsMapper;
import org.wangyu.ems.mapper.TitleMapper;
import org.wangyu.ems.util.WorkDay;

@Service
public class AttendanceService implements IAttendanceService {

	@Autowired
	private RecordCheckMapper recordCheckMapper;

	@Autowired
	private StatisticsMapper statisticsMapper;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private TitleMapper titleMapper;

	@Override
	public int addRecord(RecordCheck recordCheck) {
		recordCheckMapper.add(recordCheck);
		int count = recordCheck.getId();
		return count;
	}

	@Override
	public int appendStatistics(RecordCheck recordCheck) {
		int employeeId = recordCheck.getEmployeeId();
		int year = recordCheck.getYear();
		int month = recordCheck.getMonth();
		Employee employee = employeeMapper.findById(employeeId);
		int titleId = employee.getTitleId();
		double baseSalary = titleMapper.findById(titleId).getBaseSalary();
		Statistics statistics = new Statistics();
		statistics.setOriginDay(WorkDay.workDayCount(year, month));
		statistics.setYear(year);
		statistics.setMonth(month);
		statistics.setActualDay(1);
		statistics.setAttendance(1);
		statistics.setAbsenteeismDay(0);
		statistics.setLateCount(0);
		statistics.setAbsenteeismDay(0);
		statistics.setBaseSalary(baseSalary);
		statistics.setEmployeeId(employeeId);
		try {
			Date workTime = new SimpleDateFormat("HH:mm:ss").parse("09:00:00");
			Date checkTime = recordCheck.getCheckTime();
			long digitalworkTime = workTime.getTime();
			long digitalcheckTime = checkTime.getTime();
			if (digitalcheckTime > digitalworkTime) {
				statistics.setLateCount(1);
			} else {
				statistics.setLateCount(0);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		statisticsMapper.add(statistics);
		int statisticsId = statistics.getId();
		return statisticsId;
	}

	@Override
	public void modifyStatistics(RecordCheck recordCheck) {
		int year = recordCheck.getYear();
		int month = recordCheck.getMonth();
		int employeeId = recordCheck.getEmployeeId();
		Statistics statistics = statisticsMapper.findByYearAndMonth(year, month, employeeId);
		int lateCount = statistics.getLateCount();
		int attendance = statistics.getAttendance();
		statistics.setAttendance(attendance + 1);
		statistics.setActualDay(attendance + 1);
		try {
			Date workTime = new SimpleDateFormat("HH:mm:ss").parse("09:00:00");
			Date checkTime = recordCheck.getCheckTime();
			long digitalworkTime = workTime.getTime();
			long digitalcheckTime = checkTime.getTime();
			if (digitalcheckTime > digitalworkTime) {
				statistics.setLateCount(lateCount + 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		statisticsMapper.modify(statistics);
	}

	@Override
	public List<Statistics> findByEmployeeId(int employeeId) {
		List<Statistics> statistics = statisticsMapper.findByEmployeeId(employeeId);
		return statistics;
	}

	@Override
	public List<RecordCheck> QueryByDay(RecordCheck recordCheck) {
		List<RecordCheck> list = recordCheckMapper.findByDay(recordCheck);
		return list;
	}

	@Override
	public List<Statistics> QueryStatisticsAll() {
		List<Statistics> list = statisticsMapper.findAll();
		return list;
	}

	@Override
	public RecordCheck QueryByCheckId(int CheckId) {
		RecordCheck recordCheck = recordCheckMapper.findById(CheckId);
		return recordCheck;
	}

	@Override
	public List<Statistics> QueryByCheckRecord(RecordCheck recordCheck) {
		List<Statistics> list = statisticsMapper.findByCheckRecord(recordCheck);
		return list;
	}

	/**
	 * @param RecordCheck
	 * @return void 签退业务方法
	 */
	@Override
	public void Signback(RecordCheck recordCheck) {
		List<Statistics> statisticsList = statisticsMapper.findByCheckRecord(recordCheck);
		for (Statistics statistics : statisticsList) {
			int absenteeismDay = statistics.getAbsenteeismDay();
			statistics.setAbsenteeismDay(absenteeismDay + 1);
			statisticsMapper.modify(statistics);
		}
	}

	@Override
	public void Signback02(RecordCheck recordCheck) {
		List<Statistics> statisticsList = statisticsMapper.findByCheckRecord(recordCheck);
		try {
			Date workTime = new SimpleDateFormat("HH:mm:ss").parse("17:00:00");
			Date checkTime = recordCheck.getCheckTime();
			long digitalworkTime = workTime.getTime();
			long digitalcheckTime = checkTime.getTime();
			if (digitalcheckTime < digitalworkTime) {
				for (Statistics statistics : statisticsList) {
					int leaveCount = statistics.getLeaveCount();
					statistics.setLeaveCount(leaveCount + 1);
					statisticsMapper.modify(statistics);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Statistics> ConditionsQuery(String name) {
		List<Employee> EmployeeList = employeeMapper.findByName("%" + name + "%");
		List<Statistics> statisticsList = new ArrayList<Statistics>();


		for (int i = 0; i < EmployeeList.size(); i++) {
			Employee employee = EmployeeList.get(i);
			int employeeId = employee.getId();
			List<Statistics> list = statisticsMapper.findByEmployeeId(employeeId);
			employee.setStatistics(list);
			for (int j = 0; j < employee.getStatistics().size(); j++) {
				statisticsList.add(employee.getStatistics().get(j));
			}
		}

		for (Statistics statistics : statisticsList) {
			int employeeId = statistics.getEmployeeId();
			Employee employee = employeeMapper.findById(employeeId);
			statistics.setEmployee(employee);
		}
		return statisticsList;
	}

}
