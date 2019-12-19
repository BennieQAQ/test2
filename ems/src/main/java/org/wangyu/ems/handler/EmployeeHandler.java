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
import org.wangyu.ems.entity.PageBean;
import org.wangyu.ems.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeHandler {

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping("/emplist")
	public String emplist(ModelMap modelMap) {
		List<Employee> list = employeeService.QueryByPage(0, 5);
		modelMap.addAttribute("list", list);
		return "employee/emplist";
	}
	
	@RequestMapping("/toadd")
	public String toadd() {
		return "employee/add";
	}
	
	@RequestMapping("/add")
	public String add(Employee employee,String start,String birth) throws ParseException {
		employee.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birth));
		employee.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(start));
		employeeService.register(employee);
		return "redirect:/employee/emplist";
	}

	@RequestMapping("/remove")
	public String remove(int id) {
		employeeService.remove(id);
		return "redirect:/employee/emplist";
	}

	@RequestMapping("/tomodify")
	public String tomodify(int id, ModelMap modelMap) {
		Employee employee = employeeService.QueryById(id);
		modelMap.addAttribute("employee", employee);
		return "employee/modify";
	}

	@RequestMapping("/modify")
	public String modify(Employee employee, String birth, String start) throws ParseException {
		employee.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birth));
		employee.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(start));
		employeeService.modify(employee);
		return "redirect:/employee/emplist";
	}

	@RequestMapping("/query")
	@ResponseBody
	public Object query(String name) {
		String empName = name.trim();
		List<Employee> list = employeeService.QueryByName("%" + empName + "%");
		return list;
	} 

	@RequestMapping("/queryPage")
	@ResponseBody
	public Object queryPage(int start, int length) {
		List<Employee> list = employeeService.QueryByPage(start, length);
		int count = employeeService.QueryCount();
		PageBean<Employee> pageBean = new PageBean<Employee>();
		pageBean.setCount(count);
		pageBean.setCurrentPage(start / length + 1);
		pageBean.setCountPage(length);
		pageBean.setTotalPage((count + length - 1) / length);
		pageBean.setData(list);
		return pageBean;
	}

}
