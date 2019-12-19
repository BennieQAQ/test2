 package org.wangyu.ems.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangyu.ems.entity.Dept;
import org.wangyu.ems.service.IDeptService;

@Controller
@RequestMapping("/dept")
public class DeptHandler {

	@Autowired
	private IDeptService deptService;

	@RequestMapping("/list")
	public String list(ModelMap modelMap) {
		List<Dept> list = deptService.QueryAll();
		modelMap.addAttribute("list", list);
		return "dept/list";
	}

	
	@RequestMapping("/tomodify")
	public String tomodify(int id,ModelMap modelMap) {
		Dept dept = deptService.QueryById(id);
		modelMap.addAttribute("dept", dept);
		return "dept/modify";
	}
	
	@RequestMapping("/modify")
	public String modify(Dept dept) {
		deptService.modify(dept);
		return "redirect:/dept/list";
	}

	@RequestMapping("/remove")
	public String remove(int id,boolean status) {
		deptService.removeById(id,status);
		return "redirect:/dept/list";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public Object query(String deptName) {
		List<Dept> list = deptService.QueryByName("%"+deptName+"%");
		return list;
	}
	
	@RequestMapping("/toAdd")
	public String toAdd() {
		return "dept/add";
	}
	
	
	@RequestMapping("/add")
	public String add(Dept dept) {
		dept.setStatus(true);
		deptService.appendDept(dept);
		return "redirect:/dept/list";
	}
	
	
	@RequestMapping("/queryAll")
	@ResponseBody
	public Object queryAll() {
		List<Dept> list = deptService.QueryAll();
		return list;
	}
	
	
	

}

















