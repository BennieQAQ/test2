package org.wangyu.ems.handler;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wangyu.ems.entity.Employee;
import org.wangyu.ems.service.IEmployeeService;

@Controller
public class LoginHandler {
	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping("/login")
	public String login(String account,String password,HttpSession session
			) {
		Employee employee =  employeeService.login(account, password);
		if(employee!=null) {
			session.setAttribute("employee", employee);
			return "redirect:/main";
		}else {
			return "redirect:/";
		}
	
	}
	
//	@RequestMapping("/top")
//	public String top() {
//		return "/top";
//	}
//	
//	
//	
//	@RequestMapping("/left")
//	public String left() {
//		return "/left";
//	}
//	
//	
//	
//	@RequestMapping("/index")
//	public String index() {
//		return "/index";
//	}
//	
	

}
