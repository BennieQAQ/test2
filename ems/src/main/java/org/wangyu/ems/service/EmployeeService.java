package org.wangyu.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangyu.ems.entity.Dept;
import org.wangyu.ems.entity.Employee;
import org.wangyu.ems.entity.Title;
import org.wangyu.ems.mapper.DeptMapper;
import org.wangyu.ems.mapper.EmployeeMapper;
import org.wangyu.ems.mapper.TitleMapper;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private DeptMapper deptMapper;

	@Autowired
	private TitleMapper titleMapper;
	
	@Override
	public int register(Employee employee) {
		employee.setStatus(1);
		employeeMapper.add(employee);
		int id = employee.getId();
		return id;
	}

	@Override
	public void modify(Employee employee) {
		employeeMapper.update(employee);
	}

	@Override
	public void remove(int id) {
		employeeMapper.updateById(id);
	}

	@Override
	public Employee login(String account, String password) {
		Employee employee = employeeMapper.findByAccounAndPassword(account, password);
		return employee;
	}

	/**
	 * 员工列表功能
	 * 
	 * @return list
	 */
	@Override
	public List<Employee> QueryAll() {
		List<Employee> list = employeeMapper.findAll();
		for (Employee employee : list) {
			Dept dept = deptMapper.findById(employee.getDeptId());
			Title title = titleMapper.findById(employee.getTitleId());
			employee.setDept(dept);
			employee.setTitle(title);
		}
		return list;
	}

	@Override
	public int QueryCount() {
		int count = employeeMapper.findCount();
		return count;
	}

	@Override
	public List<Employee> QueryByName(String name) {
		String empName = name.trim();
		List<Employee> list  = employeeMapper.findByName(empName);
		for(Employee employee:list) {
			Dept dept = deptMapper.findById(employee.getDeptId());
			Title title = titleMapper.findById(employee.getTitleId());
			employee.setDept(dept);;
			employee.setTitle(title);
		}
		return list;
	}

	@Override
	public List<Employee> QueryByPage(int start, int length) {
		List<Employee> list = employeeMapper.findByPage(start, length);
		for (Employee employee : list) {
			Dept dept = deptMapper.findById(employee.getDeptId());
			Title title = titleMapper.findById(employee.getTitleId());
			employee.setDept(dept);
			employee.setTitle(title);
		}
		return list;
	}

	@Override
	public Employee QueryById(int id) {
		Employee employee = employeeMapper.findById(id);
		int deptId = employee.getDeptId();
		int titleId = employee.getTitleId();
		Title title = titleMapper.findById(titleId);
		Dept dept = deptMapper.findById(deptId);
		employee.setDept(dept);
		employee.setTitle(title);
		return employee;
	}

	

}
