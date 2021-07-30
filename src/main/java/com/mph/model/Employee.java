package com.mph.model;

public class Employee {
	private int eid;
	private String ename;
	private String dept;
	
	public Employee(int eid, String ename, String dept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.dept = dept;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", dept=" + dept + "]";
	}


}
