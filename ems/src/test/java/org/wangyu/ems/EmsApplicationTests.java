package org.wangyu.ems;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.wangyu.ems.entity.Dept;
import org.wangyu.ems.entity.Employee;
import org.wangyu.ems.entity.RecordCheck;
import org.wangyu.ems.entity.Salary;
import org.wangyu.ems.entity.Statistics;
import org.wangyu.ems.entity.Title;
import org.wangyu.ems.mapper.DeptMapper;
import org.wangyu.ems.mapper.EmployeeMapper;
import org.wangyu.ems.mapper.RecordCheckMapper;
import org.wangyu.ems.mapper.SalaryMapper;
import org.wangyu.ems.mapper.StatisticsMapper;
import org.wangyu.ems.mapper.TitleMapper;
import org.wangyu.ems.service.IAttendanceService;
import org.wangyu.ems.service.ISalaryService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class EmsApplicationTests {
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private SalaryMapper SalaryMapper;
	
	@Autowired
	private TitleMapper titleMapper;
	
	@Autowired
	private RecordCheckMapper recordCheckMapper; 
	
	@Autowired
	private StatisticsMapper statisticsMapper;
	
	@Autowired
	private IAttendanceService attendanceService;
	
	@Autowired
	private ISalaryService  salaryService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void TestConncetion() throws Exception {
		DataSource dataSource =  (DataSource) context.getBean("dataSource");
		System.out.println(dataSource);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
	
	
	@Test
	public void TestAdd() {
		Dept dept = new Dept();
		dept.setDeptName("业务部门");
		dept.setStatus(true);
		int count = deptMapper.add(dept);
		System.out.println(count);
	}
	
	
	@Test
	public  void TestfindByAccounAndPassword() {
		Employee employee =   employeeMapper.findByAccounAndPassword("wangyu", "123");
		System.out.println(employee);
	}
	
	@Test
	public  void TestDeptFindAll() {
		 List<Dept> list =  deptMapper.findAll();
		 for(Dept element:list) {
			 System.out.println(element);
		 }
		
	}
	
	@Test
	public void TestDeptFindById() {
		Dept dept = deptMapper.findById(1);
		System.out.println(dept);
	}
	
	@Test
	public void TestEmployeeFfindById() {
		Employee employee  =  employeeMapper.findById(1);
		System.out.println(employee);
	}
	
	
	@Test
	public void TestDeptUpdate() {
		deptMapper.update(8, false);
	}
	
	
	@Test
	public void FindDeptByName() {
		List<Dept> list =  deptMapper.findByName("%业务%");
		for(Dept element:list) {
			System.out.println(element);
		}
	}
	
	@Test
	public void TestTitleMapper() {
		List<Title> list =   titleMapper.findAll();
		for(Title element:list) {
			System.out.println(element.getDeptId());
		}
		
	}
	
	@Test
	public void TestTitleFindById() {
		 Title title =  titleMapper.findById(4);
		 System.out.println(title);
	}
	
	
	@Test
	public void TestTitleUpdate() {
		Title title = new Title();
		title.setId(4);
		title.setBaseSalary(4500.0);
		titleMapper.update(title);
	}
	
	
	@Test
	public void TestTitleFindByName() {
		List<Title> list = titleMapper.findByName("%程序%");
		for(Title title:list) {
			System.out.println(title);
		}
	}
	
	
	@Test
	public void TestEmployeeFindAll() {
		List<Employee> list = employeeMapper.findAll();
		for(Employee employee:list) {
			System.out.println(employee);
		}
	}
	
	
	@Test
	public void TestEmployeeUpdateById() {
		employeeMapper.updateById(5);
	}
	
	@Test
	public void TestUpdateEmployee() {
		Employee employee = new Employee();
		employee.setName("张三");
		employee.setId(1);
		employeeMapper.update(employee);
	}
	
	
	@Test
	public void TestTitleFindByDeptId() {
		List<Title> list = titleMapper.findByDeptId(4);
		for(Title title:list) {
			System.out.println(title);
		}
	}
	
	@Test
	public void TestEmployeeFindByPage() {
		for(Employee employee:employeeMapper.findByPage(0, 4)) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void TestEmployeeFindCount() {
		int count = employeeMapper.findCount();
		System.out.println(count);
	}
	
	@Test
	public void TestEmployeeFindByName() {
		for(Employee employee:employeeMapper.findByName("%张%")) {
			System.out.println(employee);
		}
		
	}
	
	@Test
	public void TestEmployeeAdd() {
		Employee employee = new Employee();
		employee.setAccount("zhaosi");
		employeeMapper.add(employee);
		System.out.println(employee.getId());		
	}
	
	
	
	@Test
	public void TestRecordCheckAdd() throws ParseException {
		RecordCheck recordCheck = new RecordCheck();
		String date = "09:30:00";
		recordCheck.setCheckTime(new SimpleDateFormat("HH:mm:ss").parse(date));
		recordCheckMapper.add(recordCheck);
		System.out.println(recordCheck.getId());
	}
	
	@Test
	public void TestStatisticsFindById() {
		List<Statistics> list = statisticsMapper.findByEmployeeId(1);
		for(Statistics statistics:list) {
			System.out.println(statistics);
		}
	}
	
	@Test
	public void TestStatisticsFindByDay() {
		RecordCheck recordCheck = new RecordCheck(null, 1, 2019, 8, 15, null);
		List<RecordCheck> list = recordCheckMapper.findByDay(recordCheck);
		for(RecordCheck element:list) {
			System.out.println(element);
		}
	}
	
	
	@Test
	public void TestStatisticsFindAll() {
		for(Statistics statistics:statisticsMapper.findAll()) {
			System.out.println(statistics);
		}
	}
	
	
	@Test
	public void TestStatisticsFindByYearAndMonth() {
		Statistics statistics = statisticsMapper.findByYearAndMonth(2019, 8,1);
		System.out.println(statistics);
	}
	
	
	@Test
	public void TestCheckFindById() {
		RecordCheck recordCheck =  recordCheckMapper.findById(21);
		System.out.println(recordCheck);
	}
	
	
	@Test
	public void TestStatisticsFindByCheckRecord() {
		RecordCheck recordCheck = new RecordCheck(null, 1, 2019, 8, 15, null);
		List<Statistics> list = statisticsMapper.findByCheckRecord(recordCheck);
		for(Statistics element:list) {
			System.out.println(element);
		}
	}
	
	
	@Test
	public void ConditionsQuery() {
		List<Statistics> list = attendanceService.ConditionsQuery("宇");
		for(Statistics statistics:list) {
			System.out.println(statistics);
		}
	}
	
	@Test
	public void salaryfindAll() {
		List<Salary> list = SalaryMapper.findAll();
		for(Salary element: list) {
			System.out.println(element);
		}
	}
	
	
	@Test
	public void salaryServicefindAll() {
		List<Salary> list = salaryService.QueryAll();
		for(Salary salary:list) {
			System.out.println(salary.getEmp());
		}
	}
	
	
	@Test
	public void salaryUpdate() {
		Salary salary = new Salary();
		salary.setId(1);
		salary.setBirthInsurance(20.0);
		SalaryMapper.update(salary);
	}
	
	
	@Test
	public void salaryDistinct() {
		List<Salary> list = SalaryMapper.findDistinctSalary();
		for(Salary salary:list) {
			System.out.println(salary.getEmployeeId());
		}
		
	}
	
	
	@Test
	public void addSalary() {
		Salary salary = new Salary();
		salary.setBirthInsurance(20.0);
		SalaryMapper.addSalary(salary);
		int salaryId = salary.getId();
		System.out.println(salaryId);
	}
	
	
	@Test
	public void SalaryFindById() {
		List<Salary> list = SalaryMapper.findById(8);
		for(Salary salary:list) {
			System.out.println(salary);
		}
	}
	
	
	@Test
	public void QueryBySalaryName() {
		List<Salary> list = salaryService.QueryByName("王雨");
		for(Salary salary:list) {
			System.out.println(salary);
		}
	}

}












