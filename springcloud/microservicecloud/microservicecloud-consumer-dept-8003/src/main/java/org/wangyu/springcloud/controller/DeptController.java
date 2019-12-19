package org.wangyu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangyu.springcloud.entity.Dept;
import org.wangyu.springcloud.service.DeptServiceClient;

@Controller
public class DeptController {
	
	@Autowired
	public DeptServiceClient  deptServiceClient;
	
	
	@RequestMapping(value = "/consumer/get/{id}")
	@ResponseBody
	public Dept getdept(@PathVariable("id") Long id) {
		return deptServiceClient.getDept(id);
	}
	
	@RequestMapping(value = "/consumer/dept/list")
	@ResponseBody
	public List<Dept> getList() {
		return deptServiceClient.getlist();
	}
	
	@RequestMapping(value = "/consumer/dept/add")
	@ResponseBody
	public Boolean addDept(Dept dept) {
		return deptServiceClient.add(dept);
	}
	
	
	
}
