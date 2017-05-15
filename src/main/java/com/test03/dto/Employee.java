package com.test03.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	private int eno;
	private String ename;
	private int salary;
	private int dno;
	private int gender;
	private Date joindate;
	private int title;
	
	private String strTitle;
	private String strDept;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public String toString() {
		return String.format("Employee [eno=%s, ename=%s, salary=%s, dno=%s, gender=%s, joindate=%s, title=%s]", eno,
				ename, salary, dno, gender, joindate, title);
	}
	
	public String[] toArray(){
		
		String strGender;
		if(gender==1){
			strGender="남자";
		}else{
			strGender="여자";
		}
		
		switch (title) {
		case 1:strTitle="사장";
		break;
		case 2:strTitle="부장";
		break;
		case 3:strTitle="과장";
		break;
		case 4:strTitle="대리";
		break;
		case 5:strTitle="사원";
		break;
		}
		
		switch (dno) {
		case 1:strDept="마케팅(10층)";
		break;
		case 2:strDept="개발(9층)";
		break;
		case 3:strDept="인사(6층)";
		break;
		case 4:strDept="총무(7층)";
		break;
		case 5:strDept="경영(4층)";
		break;

		default:
			break;
		}
		
		return new String[]{eno+"", ename, strTitle, salary+"", strGender, strDept, dateFormat.format(joindate)};
	}
	
	
	
}
