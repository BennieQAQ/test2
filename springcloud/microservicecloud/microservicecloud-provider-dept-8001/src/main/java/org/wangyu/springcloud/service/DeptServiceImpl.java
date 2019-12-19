package org.wangyu.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangyu.springcloud.entity.Dept;
import org.wangyu.springcloud.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;
	
	
	@Override
	public boolean add(Dept dept) {
		
		return deptMapper.addDept(dept);
	}

	@Override
	public Dept QueryById(Long id) {
		Dept dept = deptMapper.findById(id);
		return dept;
	}

	@Override
	public List<Dept> QueryAll() {
		List<Dept> list = deptMapper.findAll();
		return list;
	}

}
