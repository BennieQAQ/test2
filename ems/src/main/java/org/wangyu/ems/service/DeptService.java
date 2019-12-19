package org.wangyu.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangyu.ems.entity.Dept;
import org.wangyu.ems.mapper.DeptMapper;

@Service
public class DeptService implements IDeptService {
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public int appendDept(Dept dept) {
		int id = deptMapper.add(dept);
		return id;
	}
	
	@Override
	public void removeById(int id ,boolean status) {
		deptMapper.update(id,status);
	}
	
	@Override
	public void modify(Dept dept) {
		deptMapper.updataName(dept);
	}


	@Override
	public List<Dept> QueryAll() {
		List<Dept> list = deptMapper.findAll();
		return list;
	}
	

	@Override
	public List<Dept> QueryByName(String deptName) {
		List<Dept> list =   deptMapper.findByName(deptName);
		return list;
	}
	
	@Override
	public Dept QueryById(int id) {
		return deptMapper.findById(id);
	}

	





	
}
