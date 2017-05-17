package com.test03.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.test03.dto.Employee;
import com.test03.mappers.EmployeeMapper;
import com.test03.util.MyBatisSqlSessionFactory;

public class EmployeeService {
	private static final Logger logger = Logger.getLogger(EmployeeService.class);
	private final static EmployeeService instance = new EmployeeService();

	public static EmployeeService getInstance() {
		return instance;
	}

	private EmployeeService() {}
	
	public int insertEmployee(Employee employee){
		if(logger.isDebugEnabled()){
			logger.debug("insertEmployee(Employee employee) - start");
		}
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			int res = employeeMapper.insertEmployee(employee);
			sqlSession.commit();
			return res;
		}finally{
			sqlSession.close();
		}
		
	}
	
	public List<Employee> findAllEmployee(){
		logger.debug("findAllEmployee()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			List<Employee> res = employeeMapper.findAllEmployee();
			return res;
		}finally{
			sqlSession.close();
		}
	}
	
	public Employee findLastEmployee(){
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			return employeeMapper.findLastEmployee();
		}finally{
			sqlSession.close();
		}
		
	}
	
	public int deleteEmployee(int eno){
		logger.debug("deleteEmployee()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			int res = employeeMapper.deleteEmployee(eno);
			sqlSession.commit();
			return res;
		} finally {
			sqlSession.close();
		}
		
	}
	
	public Employee findEmployeeByEno(int eno){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee findEmp = employeeMapper.findEmployeeByEno(eno);
			return findEmp;
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateEmployee(Employee employee){
		logger.debug("updateEmployee()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try{
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			int res = employeeMapper.updateEmployee(employee);
			sqlSession.commit();
			return res;
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally{
			sqlSession.close();
		}
	}
	
	
	
}
