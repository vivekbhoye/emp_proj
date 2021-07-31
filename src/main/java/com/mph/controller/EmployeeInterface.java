package com.mph.controller;

import java.io.IOException;
import java.util.List;

public interface EmployeeInterface {
	public List addEmployee();
	public void viewEmployee(List elist);
	public void serializeEmp(List elist ) ;
	public void deSerializeEmp(List elist) ;
	public void SortByEmpName(List elist);
	public void ViewByDepartment(List elist);
	public void InsertUsingProcedure();
	public void rsmd();
	public void type_forward_only_rs();
	public void type_scroll_insensitive_rs();
	public void type_scroll_sensitive_rs();
	public void type_scroll_sensitive_update_rs();
}
