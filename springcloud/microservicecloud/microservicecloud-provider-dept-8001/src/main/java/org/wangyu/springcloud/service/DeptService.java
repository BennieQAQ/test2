package org.wangyu.springcloud.service;

import java.util.List;

import org.wangyu.springcloud.entity.Dept;

public interface DeptService {
	public boolean add(Dept dept);

	public Dept QueryById(Long id);

	public List<Dept> QueryAll();

}
