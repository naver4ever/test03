package com.test03;


import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.test03.dto.Employee;
import com.test03.service.EmployeeService;

public class EmployeeServiceTest {
	
	private static EmployeeService employeeService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		employeeService = EmployeeService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		employeeService = null;
	}
	
	@Test
	public void testFindLastEmployee(){
		Employee lastEmp = employeeService.findLastEmployee();
		int lastEno =  lastEmp.getEno();
		System.out.println(lastEno);
	}
	
	
	@Test
	public void testInsertEmployee(){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2017, 12, 28);
		
		Employee aEmployee = new Employee();
		aEmployee.setEno(0002);
		aEmployee.setEname("hak2");
		aEmployee.setSalary(2500000);
		aEmployee.setDno(002);
		aEmployee.setGender(2);
		aEmployee.setJoindate(cal.getTime());
		aEmployee.setTitle(002);
		
		int res = employeeService.insertEmployee(aEmployee);	
	}

}
