package com.test03.dto;

import java.util.Date;

public class Employee {
	private int eno;
	private String ename;
	private int salary;
	private int dno;
	private int gender;
	private Date joindate;
	private int title;
	
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
	
	@Override
	public String toString() {
		return String.format("Employee [eno=%s, ename=%s, salary=%s, dno=%s, gender=%s, joindate=%s, title=%s]", eno,
				ename, salary, dno, gender, joindate, title);
	}
	
}
