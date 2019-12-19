package org.wangyu.ems.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangyu.ems.entity.Employee;
import org.wangyu.ems.entity.RecordCheck;
import org.wangyu.ems.entity.Salary;
import org.wangyu.ems.entity.Statistics;
import org.wangyu.ems.service.IAttendanceService;
import org.wangyu.ems.service.IEmployeeService;
import org.wangyu.ems.service.ISalaryService;

@Controller
@RequestMapping("/attendance")
public class AttendanceHandler {

	@Autowired
	private IAttendanceService attendanceService;
	
	@Autowired
	private ISalaryService salaryService;

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping("/attendancelist")
	public String attendancelist(ModelMap modelMap) {
		List<Statistics> list = attendanceService.QueryStatisticsAll();
		for (Statistics statistics : list) {
			int employeeId = statistics.getEmployeeId();
			Employee employee = employeeService.QueryById(employeeId);
			statistics.setEmployee(employee);
		}
		modelMap.addAttribute("list", list);
		return "attendance/statistics";
	}

	@RequestMapping("/check")
	@ResponseBody
	public Object check(RecordCheck recordCheck, String Time) throws ParseException {
		recordCheck.setCheckTime(new SimpleDateFormat("HH:mm:ss").parse(Time));
		 List<RecordCheck> recordChecklist =  attendanceService.QueryByDay(recordCheck);
		 if(recordChecklist.isEmpty()) {
			 attendanceService.addRecord(recordCheck);
			 List<Statistics> statisticslist = attendanceService.QueryByCheckRecord(recordCheck);
			 int year = recordCheck.getYear();
			 int month = recordCheck.getMonth();
			 if(statisticslist.isEmpty()) {
				 attendanceService.appendStatistics(recordCheck);
			 }else {
				for(Statistics statistics:statisticslist) {
					if(statistics.getYear()==year && statistics.getMonth()==month) {
						attendanceService.modifyStatistics(recordCheck);
					}else {
						attendanceService.appendStatistics(recordCheck);
					}
				}
			 }
		 }
		List<Statistics> list = attendanceService.QueryStatisticsAll();
		for (Statistics element : list) {
			int employeeId = element.getEmployeeId();
			Employee employee = employeeService.QueryById(employeeId);
			element.setEmployee(employee);
		}
		return list;
	}
	
	
	@RequestMapping("/Signback")
	@ResponseBody
	public Object Signback(RecordCheck recordCheck,String Time) throws ParseException {
		recordCheck.setCheckTime(new SimpleDateFormat("HH:mm:ss").parse(Time));
		attendanceService.addRecord(recordCheck);
		List<RecordCheck> RecordCheckList = attendanceService.QueryByDay(recordCheck);
		if(RecordCheckList.size()==1) {
			attendanceService.Signback(recordCheck);
		}else if(RecordCheckList.size()==2) {
			attendanceService.Signback02(recordCheck);
		}
		List<Statistics> list = attendanceService.QueryStatisticsAll();
		for(Statistics statistics:list) {
			int employeeId  = statistics.getEmployeeId();
			Employee employee = employeeService.QueryById(employeeId);
			statistics.setEmployee(employee);
		}
		
		
		return list;
	}
	
	
	@RequestMapping("/queryAll")
	@ResponseBody
	public Object queryAll(String name) {
		List<Statistics> list = attendanceService.ConditionsQuery(name);
		return list;
	}
	
	
	@RequestMapping("/SalaryStatistics")
	public String SalarySalaryList() {
		
		return null;
	}
	
	
	@RequestMapping("/SalaryList")
	public String SalaryList(ModelMap modelMap) {
		List<Salary> list = salaryService.QueryAll();
		modelMap.addAttribute("list", list);
		return "salary/list";
	}
	
	
	@RequestMapping("/query")
	@ResponseBody
	public Object QuerySalaryByName(String salaryName) {
		List<Salary> list = salaryService.QueryByName(salaryName);
		return list;
	}
	
	

	
}
