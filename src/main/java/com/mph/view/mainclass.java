package com.mph.view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.Scanner;

import com.mph.controller.EmployeeController;
import com.mph.controller.EmployeeInterface;
import com.mph.exception.UserNotFoundException;
import com.mph.model.Employee;

public class MainClass{

	static boolean Validation(String username, String password) {
		String validUsername = "vBASH";
		String validPassword = "vBASH";
		BiPredicate<String, String> v1 = (x, y) -> x.equals(y);
		BiPredicate<String, String> v2 = (x, y) -> x.equals(y);
		Boolean valid = v1.test(username, validUsername) && (v2.test(password, validPassword));
//		Predicate<Employee> p1 = v->username.equals(validUsername)&&password.equals(validPassword);
		return valid;

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Welcome To Employee Management System !!!");
		EmployeeInterface ec = new EmployeeController();

		Scanner sc = new Scanner(System.in);
		String input = null;
		List elist = null;

//		-----------
		try {

			String username;
			String password;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			// connecting InputStreamReader to BufferReader

			System.out.println("Enter Username :");
			username = (br.readLine());

			System.out.println("Enter password :");
			password = (br.readLine());

			if (Validation(username, password)) {

				System.out.println("Please wait while we Validate ");
				Thread.sleep(1000);
				System.out.println("Welcome " + username + ", You succesfully logged in");
//                --------------
				do {

					System.out.println("Enter your Choice:");
					System.out.println("1. Add Employee");
					System.out.println("2. View Employee");
					System.out.println("3. Serialize Employee");
					System.out.println("4. DeSerialize Employee");
					System.out.println("5. Sort Employees By Names ");
					System.out.println("6. View Employee by departmment");
					System.out.println("7. Insert Using Procedure ");
					System.out.println("8. rsmd ");
					System.out.println("9. RS Forward type only  ");
					System.out.println("10. Type scroll insensitive  ");
					System.out.println("11. Type scroll sensitive  ");
					System.out.println("12. Update  ");
					int choice = sc.nextInt();

					switch (choice) {
					case 1: {
//						Add Employee
						elist = ec.addEmployee();

						break;
					}
					case 2: {
//						View Employees
						ec.viewEmployee(elist);

						break;
					}
					case 3: {
//        			Serialization
						ec.serializeEmp(elist);
						break;
					}
					case 4: {
//        			De-Serialization
						ec.deSerializeEmp(elist);
						break;
					}
					case 5: {
//        			Sort Employee by Names
						ec.SortByEmpName(elist);
						break;
					}
					case 6: {
//        			View Employee Department wise
						ec.ViewByDepartment(elist);
						break;
					}
					case 7: {
						ec.InsertUsingProcedure();
						break;
					}

					case 8: {
						ec.rsmd();
						break;
					}
					case 9: {
						ec.type_forward_only_rs();
						break;
					}
					case 10: {
						ec.type_scroll_insensitive_rs();
						break;
					}
					case 11: {
						ec.type_scroll_sensitive_rs();
						break;
					}
					case 12: {
						ec.type_scroll_sensitive_update_rs();
						break;
					}
					default:
						System.out.println("Plz enter a valid choice !!");

					}
					System.out.println("Do you want to continue? Type Y or y to continue ");
					input = sc.next();
				} while (input.equals("Y") || input.equals("y"));
				System.out.println("System Exited. Thanks for using Employee Management System !!!");
				System.exit(0);
			} else {
				throw new UserNotFoundException();
			}
		} catch (UserNotFoundException ude) { // exception name and another whatever name we want but follow convention
			ude.printStackTrace();
			// this gives the explanation of exception and line number of where it happened
			// but handle exception and goes forward

		}

	}
}
