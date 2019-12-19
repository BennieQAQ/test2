package org.wangyu.ems.service;

import java.util.List;

import org.wangyu.ems.entity.Title;

public interface ITitleService {
	
	int append(Title title);
	
	void removeById(int id);
	
	void modify(Title title);
	
	Title QueryById(int id);
	
	List<Title> QueryByDeptId(int DeptID);
	
	List<Title>  QueryByName(String titleName);
 	
	List<Title> QueryAll();
	
	

}
