package com.mph.view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.*;
import java.util.Scanner;

import com.mph.exception.UserNotFoundException;

public class main {
static boolean valid(String un, String pw) {
String username = "vBASH";
String password = "BASH";
if ((un.equals(username)) && (pw.equals(password))) {
System.out.println("in Success " );
return true;}else
return false;
}
public static void main(String[] args) throws Throwable {
System.out.println("Welcome");
try {
System.out.println("Enter UserName");
BufferedReader br;
String un=br.readLine();
System.out.println("Enter password");
String pw = br.readLine();
if((valid (un,pw))) {

Object input;
do
{
System.out.println("Choice");
System.out.println("1. Add Employee");
System.out.println("2. View Employee");
Scanner sc;
int choice = sc.nextInt();
switch (choice) {
case 1: {	
addEmployee();
break;
}
case 2: {
viewEmployee();
break;
}
default:
System.out.println("enter valid choice");
}
System.out.println("want to continue Y or y");
input= sc.next();
}while(input.equals("Y") || input.equals("y"));
}
else {
throw new UserNotFoundException();
}
}catch (UserNotFoundException ufe) {
ufe.printStackTrace();
}
System.out.println("EXIT");
System.exit(0);
}
}
	

