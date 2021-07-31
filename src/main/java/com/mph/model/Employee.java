package com.mph.model;

import java.io.Serializable;
import java.util.Comparator;

public class Employee implements Serializable, Comparable<Employee> {

	private int empno;
	private String empname;
	private Salary sal;
	private String depName;

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Employee() {
//		System.out.println("Employee Constructor ");
	}

	public Employee(int empno, String empname, String depName, Salary sal) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.depName = depName;
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Salary getSal() {
		return sal;
	}

	public void setSal(Salary sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee Number \t" + empno + "\n" + "Employee Name \t\t" + empname + "\n" + "Department Namee \t"
				+ depName + "\n" + "Employee Salary Details \n" + sal + "\n";
	}

	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return (e1.getEmpname().compareTo(e2.getEmpname()));
		}

	};

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
