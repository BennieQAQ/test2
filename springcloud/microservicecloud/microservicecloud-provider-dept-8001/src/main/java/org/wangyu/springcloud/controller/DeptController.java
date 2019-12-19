package org.wangyu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wangyu.springcloud.entity.Dept;
import org.wangyu.springcloud.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	@Autowired
	private DiscoveryClient discoveryClient; //eureka服务发现中封装了该微服务的信息
	
	@RequestMapping(value = "/dept/add")
	public boolean add(Dept dept) {
		System.out.println(dept);
		return deptService.add(dept);
	}
	
	//使用@PathVariable注解
	@RequestMapping(value = "/dept/get/{id}",method =RequestMethod.GET)
	public Dept queryById(@PathVariable(value = "id") long id) {
		return deptService.QueryById(id);
	}
	
	@RequestMapping(value = "/dept/list",method = RequestMethod.GET)
	public List<Dept> queryAll(){
		List<Dept> list = deptService.QueryAll();
		return list;
	}
	
	@RequestMapping(value = "/dept/discovery")
	public Object discovery() {
		List<String> ServiceList  = discoveryClient.getServices();
		System.out.println("*******************"+ServiceList);
		List<ServiceInstance> list = discoveryClient.getInstances("microservicecloud-dept");
		
		for(ServiceInstance element:list) {
			System.out.println(element.getServiceId()+"/t"+element.getHost()+"/t"+element.getPort());
		}
		
		return this.discoveryClient;
	
	}
	
	
	
	
}
