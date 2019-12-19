package org.wangyu.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangyu.ems.entity.Employee;
import org.wangyu.ems.entity.Salary;
import org.wangyu.ems.mapper.EmployeeMapper;
import org.wangyu.ems.mapper.SalaryMapper;
import org.wangyu.ems.util.CalculateSalary;
import org.wangyu.ems.util.CurrentTime;

@Service
public class SalaryService implements ISalaryService {
	
	@Autowired
	private SalaryMapper salaryMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper; 
	
	
	@Autowired
	private CurrentTime currentTime;
	
	@Autowired
	private CalculateSalary calculateSalary;
	

	@Override
	public List<Salary> QueryAll() {
		List<Employee> employeeList = employeeMapper.findAll();
		List<Salary> salaryCount = salaryMapper.findDistinctSalary();
		List<Salary> salaryList = salaryMapper.findAll();
		int year = currentTime.getYear();
		int month = currentTime.getMonth();
		if(salaryList.isEmpty()) {
			for(Employee employee:employeeList) {
				Salary salary = calculateSalary.getInsurance(employee, year, month);
				salaryMapper.addSalary(salary);
			}
		}else if(salaryCount.size() == employeeList.size()) {
			
		}else {
			for(Employee employee:employeeList) {
				int employeeid = employee.getId();
				List<Salary> List = salaryMapper.findById(employeeid);
				if(List.isEmpty()) {
					Salary salary = calculateSalary.getInsurance(employee, year, month);
					salaryMapper.addSalary(salary);
				}
			}
		}
		
		
		for(Salary salary:salaryList) {
			if(salary.getYear() != year && salary.getMonth() != month) {
				int employeeID = salary.getEmployeeId();
				Employee employee = employeeMapper.findById(employeeID);
				Salary NewSalary = calculateSalary.getInsurance(employee, year, month);
				salaryMapper.addSalary(NewSalary);
			}
			int employeeid = salary.getEmployeeId();
			Employee employee = employeeMapper.findById(employeeid);
			salary.setEmp(employee);
		}
		return salaryList;
	}


	@Override
	public List<Salary> QueryByName(String name) {
		String SalaryName = name.trim();
		List<Employee> employeeList = employeeMapper.findByName("%"+SalaryName+"%");
		List<Salary> salaryList = new ArrayList<Salary>();
		for(Employee employee:employeeList) {
			int employeeid = employee.getId();
			List<Salary> list = salaryMapper.findById(employeeid);
			salaryList.addAll(list);
		}
		
		for(Salary salary:salaryList) {
			Employee employee = employeeMapper.findById(salary.getEmployeeId());
			salary.setEmp(employee);
		}
		
		return salaryList;
	}

}
