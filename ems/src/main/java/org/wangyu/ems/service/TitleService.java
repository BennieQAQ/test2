package org.wangyu.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangyu.ems.entity.Dept;
import org.wangyu.ems.entity.Title;
import org.wangyu.ems.mapper.DeptMapper;
import org.wangyu.ems.mapper.TitleMapper;

@Service
public class TitleService implements ITitleService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private TitleMapper titleMapper;
	
	
	@Override
	public int append(Title title) {
		int id = titleMapper.add(title);
		return id;
	}

	@Override
	public List<Title> QueryAll() {
		List<Title> list =  titleMapper.findAll();
		for(Title title:list) {
			Dept dept = deptMapper.findById(title.getDeptId());
			title.setDept(dept);
		}
		return list;
	}

	@Override
	public void removeById(int id) {
		titleMapper.deleteById(id);
	}

	@Override
	public Title QueryById(int id) {
		Title title =  titleMapper.findById(id);
		int deptID = title.getDeptId();
		Dept dept = deptMapper.findById(deptID);
		title.setDept(dept);
		return title;
	}
	
	
	@Override
	public List<Title> QueryByDeptId(int DeptID) {
		List<Title> list = titleMapper.findByDeptId(DeptID);
		return list;
	}
	

	@Override
	public List<Title> QueryByName(String titleName) {
		List<Title> list = titleMapper.findByName(titleName);
		for(Title title:list) {
			Dept dept = deptMapper.findById(title.getDeptId());
			title.setDept(dept);
		}
		return list;
	}

	@Override
	public void modify(Title title) {
		titleMapper.update(title);
	}

	

	




}
