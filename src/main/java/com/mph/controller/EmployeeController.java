package com.mph.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.mph.daoimpl.EmployeeDao;
import com.mph.daoimpl.EmployeeDaoImpl;
import com.mph.model.Employee;
import com.mph.model.Salary;

public class EmployeeController implements EmployeeInterface {

	Employee emp;
	EmployeeDao dao = new EmployeeDaoImpl();
	Salary sal;
	List empList = new ArrayList();
	

	public List addEmployee() {
		emp = new Employee();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Emp Number:");
		int eno = sc.nextInt();
		emp.setEmpno(eno);

		System.out.println("Enter your name :");
		emp.setEmpname(sc.next());

		System.out.println("Enter your Department name :");
		emp.setDepName(sc.next());

		sal = new Salary();
		System.out.println("Enter Basic : ");
		int basic = sc.nextInt();
		sal.setBasic(basic);
		sal.setDa(basic);
		sal.setHra(basic);
		sal.setPf(basic);
		sal.setGrossSalary();
		sal.setNetSalary();
		emp.setSal(sal);
		empList.add(emp);
		dao.createEmployee(emp,sal);
		System.out.println(emp.getEmpname() + " Employee Added into System");
		return empList;
	}

	public void viewEmployee(List elist) {
//		elist.forEach(li -> System.out.println(li));
		System.out.println("\nEmployee Details ");
		dao.listEmployee();
	}

//	-----------------------------------------------------------------
	public void serializeEmp(List elist) {

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {

			fout = new FileOutputStream("Employee-Serialization.txt");
			oos = new ObjectOutputStream(fout);

			oos.writeObject(elist);
			System.out.println("Employee Management system Serialized check Employee-Serialization.txt ");
			oos.close();
			fout.close();
		} catch (Exception ex) {
			System.out.println("Serialization raising exception" + ex);
		}
	}

	public void deSerializeEmp(List elist) {
		try {

			FileInputStream fin = new FileInputStream("Employee-Serialization.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);

			List<Employee> empl = (List<Employee>) ois.readObject();

			System.out.println("De-Serialized Employee Object");
			Iterator<Employee> i = empl.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
			ois.close();
			fin.close();
		} catch (Exception ex) {
			System.out.println("De-Serialization raising exception" + ex);
		}

	}

	public void SortByEmpName(List empList) {
		Collections.sort(empList);
		empList.sort(Employee.nameComparator);
		System.out.println("Sorted Employee Array by Name : " + "\n" + empList.toString());
//
	}

	public void ViewByDepartment(List elist) {
		Map<String, List<Employee>> groupByDept = (Map<String, List<Employee>>) elist.stream()
				.collect(Collectors.groupingBy(Employee::getDepName));


		groupByDept.forEach((dep, empInDept) -> {
			System.out.println("\n***Department Name \t" + dep + " ***");
			empInDept.forEach(System.out::println);

		});
	}
	
	public void InsertUsingProcedure() {
		Employee e = new Employee();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Emp Number: proc ");
		int eno = sc.nextInt();
		e.setEmpno(eno);

		System.out.println("Enter your name proc :");
		e.setEmpname(sc.next());

		System.out.println("Enter your Department name proc :");
		e.setDepName(sc.next());

		sal = new Salary();
		System.out.println("Enter Basic proc : ");
		int basic = sc.nextInt();
		dao.insertUsingProcedure(e, sal);
		System.out.println("proc Done");
	}

	@Override
	public void rsmd() {
		// TODO Auto-generated method stub
		dao.rsmd();
	}

	@Override
	public void type_forward_only_rs() {
		// TODO Auto-generated method stub
		dao.type_forward_only_rs();
	}

	@Override
	public void type_scroll_insensitive_rs() {
		// TODO Auto-generated method stub
		dao.type_scroll_insensitive_rs();
	}

	@Override
	public void type_scroll_sensitive_rs() {
		// TODO Auto-generated method stub
		dao.type_scroll_sensitive_rs();
		
	}

	@Override
	public void type_scroll_sensitive_update_rs() {
		// TODO Auto-generated method stub
		dao.type_scroll_sensitive_update_rs();
	}
	}
