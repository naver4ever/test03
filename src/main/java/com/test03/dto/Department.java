package com.test03.dto;

public class Department {
	private int dcode;
	private String dname;
	private int floor;
	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	@Override
	public String toString() {
		return String.format("Department [dcode=%s, dname=%s, floor=%s]", dcode, dname, floor);
	}
	
	public String[] toArray() {
		return new String[]{dcode+"", dname, floor+""};
	}
	
	
}
