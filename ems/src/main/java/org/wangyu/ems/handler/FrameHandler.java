package org.wangyu.ems.handler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FrameHandler {
	
	
	
	@RequestMapping("/top")
	public String top() {
//		System.out.println("id====================="+id);
//		Employee employee = employeeService.QueryById(id);
//		httpSession.setAttribute("employee", employee);
		return "/top";
	}
	
	
	
	@RequestMapping("/left")
	public String left() {
		return "/left";
	}
	
	
	
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	
	
	@RequestMapping("/main")
	public String main() {
		return "/main";
	}
	
	
}
