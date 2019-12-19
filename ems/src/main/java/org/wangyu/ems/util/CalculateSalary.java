package org.wangyu.ems.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wangyu.ems.entity.Employee;
import org.wangyu.ems.entity.Salary;
import org.wangyu.ems.entity.Title;
import org.wangyu.ems.mapper.TitleMapper;

@Component
public class CalculateSalary {
	
	@Autowired
	private  TitleMapper titleMapper;

	public  Salary getInsurance(Employee employee, int year,int month) {
		int employeeid = employee.getId();
		Title title = titleMapper.findById(employee.getTitleId());
		double baseSalary =  title.getBaseSalary();
		double endowmentInsurance = baseSalary*0.08;
		double medicalInsurance = baseSalary*0.02+3;
		double injuryInsurance = 0.0;
		double birthInsurance = 0.0;
		double unemployInsurance =baseSalary*0.002;
		Salary salary = new Salary(null, year, month, employeeid, endowmentInsurance, medicalInsurance, injuryInsurance, birthInsurance, unemployInsurance, null, null);
		return salary;
	}
	
}
