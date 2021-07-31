package com.mph.daoimpl;

import com.mph.model.Employee;
import com.mph.model.Salary;

public interface EmployeeDao {
	public void createEmployee(Employee emp, Salary sal);
	public void listEmployee();
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int empno);
	public void insertUsingProcedure(Employee emp,Salary sal);
	public void rsmd();
	public void type_forward_only_rs();
	public void type_scroll_insensitive_rs();
	public void type_scroll_sensitive_rs();
	public void type_scroll_sensitive_update_rs();
}
