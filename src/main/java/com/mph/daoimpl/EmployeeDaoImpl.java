package com.mph.daoimpl;

import java.sql.Statement;
import java.util.HashMap;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mph.model.Employee;
import com.mph.model.Salary;
import com.mph.util.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	public void createEmployee(Employee emp,Salary sal) {
		con = DBConnection.getDBConnection();
		try {
			ps = con.prepareStatement("insert into mphemp(eid,ename,dept,basic,da,hra,pf,grosssalary,netsalary) values(?,?,?,?,?,?,?,?,?)");
			int eid = emp.getEmpno();
			String ename = emp.getEmpname();
			String dept = emp.getDepName();
			int basic =  sal.getBasic();
			int da =  sal.getDa();
			int hra =  sal.getHra();
			int pf =  sal.getPf();
			int grosssalary =  sal.getGrossSalary();
			int netsalary =  sal.getNetSalary();
						
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setString(3, dept);
			ps.setInt(4, basic);
			ps.setInt(5, da);
			ps.setInt(6, hra);
			ps.setInt(7, pf);
			ps.setInt(8, grosssalary);
			ps.setInt(9, netsalary);
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " no of rows Inserted Succefully. ");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void listEmployee() {
		con = DBConnection.getDBConnection();
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from mphemp");
			while(rs.next()) {
//				System.out.println("Employee Details");
				System.out.println("\nEmp no " + rs.getInt(1));
				System.out.println("Name " + rs.getString(2));
				System.out.println("Department Name " + rs.getString(3));
				System.out.println("Salary Details of " + rs.getString(2));
				System.out.println("Basic " + rs.getInt(4));
				System.out.println("Da " + rs.getInt(5));
				System.out.println("Hra " + rs.getInt(6));
				System.out.println("Pf " + rs.getInt(7));
				System.out.println("Gross Salary " + rs.getInt(8));
				System.out.println("Net Salary " + rs.getInt(9));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(Employee emp) {
		
	}
	public void deleteEmployee(int empno) {
	
	}

	public void insertUsingProcedure(Employee emp,Salary sal)
	{
		con = DBConnection.getDBConnection();
		try {
			con = DBConnection.getDBConnection();
			CallableStatement cs = con.prepareCall("{call insertEmp(?,?,?,?,?,?,?,?,?)}");
			cs.setInt(1, emp.getEmpno());
			cs.setString(2, emp.getEmpname());
			cs.setString(3, emp.getDepName());
			cs.setInt(4, sal.getBasic());
			cs.setInt(5, sal.getDa());
			cs.setInt(6, sal.getHra());
			cs.setInt(7, sal.getPf());
			cs.setInt(8, sal.getGrossSalary());
			cs.setInt(9, sal.getNetSalary());
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void rsmd() {
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from mphemp");
			ResultSetMetaData md = rs.getMetaData();
			System.out.println(md.getColumnCount());
			while(rs.next()) {
				HashMap<String,Object> row = new HashMap<String,Object>();
				for (int i = 1; i<=md.getColumnCount();i++) {
					row.put(md.getColumnName(i), rs.getObject(i));
					System.out.println(row);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void type_forward_only_rs() {
		try {
				con = DBConnection.getDBConnection();
				ps  = con.prepareStatement("select * from mphemp",
						ResultSet.TYPE_FORWARD_ONLY,
						ResultSet.CONCUR_UPDATABLE);
				rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString("ename"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void type_scroll_insensitive_rs() {
		try {
			con = DBConnection.getDBConnection();
			ps  = con.prepareStatement("select * from mphemp",
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("ename"));
			}
			System.out.println("Move Cursor to First Position ");
			rs.first();
			System.out.println(rs.getString("ename"));
			
			System.out.println("Move Cursor to Last Position ");
			rs.last();
			System.out.println(rs.getString("ename"));
			
			System.out.println("Move Cursor to Previous Position ");
			rs.previous();
			System.out.println(rs.getString("ename"));
			
			
			
	} catch (SQLException e) {
		e.printStackTrace();
	
	}
	}

	@Override
	public void type_scroll_sensitive_rs() {
		try {
			con = DBConnection.getDBConnection();
			ps  = con.prepareStatement("select eid,ename from mphemp",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			rs.moveToInsertRow();
			rs.updateInt("eid", 15);
			rs.updateString("ename", "Roja");
			rs.insertRow();
			
			System.out.println("after insertion the ResultSet is ");
			while(rs.next()) {
				System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("ename"));
			}
	} catch (SQLException e) {
		e.printStackTrace();
	
	}
	}

	@Override
	public void type_scroll_sensitive_update_rs() {
		try {
			con = DBConnection.getDBConnection();
			ps = con.prepareStatement(
					"select eid,ename from mphemp where ename='Ravi'",
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("ename"));
				rs.updateString("ename", "boss");
				rs.updateRow();
				rs.refreshRow();
				System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}
}

