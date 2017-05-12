package com.test03.mappers;

import java.util.List;

import com.test03.dto.Employee;

public interface EmployeeMapper {
	int insertEmployee(Employee employee);
	List<Employee> findAllEmployee();
	Employee findLastEmployee();
}
