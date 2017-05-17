package com.test03.dto;

public class Title {
	
	private int tcode;
	private String tname;
	
	public int getTcode() {
		return tcode;
	}
	public void setTcode(int tcode) {
		this.tcode = tcode;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@Override
	public String toString() {
		return String.format("Title [tcode=%s, tname=%s]", tcode, tname);
	}
	
	public String[] toArray() {
		return new String[]{tcode+"", tname};
	}
	
}
