package org.wangyu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.wangyu.springcloud.entity.Dept;

@RestController
public class DeptController_consumer {
	
	private static final String rest_url_prefix="http://127.0.0.1:8001";
	
	/**
	 * 使用restTemplate模板来访问rest服务url:请求地址，requestMap:请求参数,  responseBean.class返回值类型
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(rest_url_prefix+"/dept/add", dept, boolean.class);
	}
	
	
	
	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable(value = "id") Long id) {
		Dept dept  = restTemplate.getForObject(rest_url_prefix+"/dept/get/"+id, Dept.class);
		return dept;
	}
	
	@RequestMapping(value = "/consumer/dept/list")
	@SuppressWarnings("unchecked")
	public List<Dept> list() {
		List<Dept> list  = restTemplate.getForObject(rest_url_prefix+"/dept/list", List.class);
		return list;
	}
	
	
	
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object Discover() {
		return restTemplate.getForObject(rest_url_prefix+"/dept/discovery", Object.class);
	}
	
	
	

	
}
