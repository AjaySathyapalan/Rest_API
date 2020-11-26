package com.ajay.rest_api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository 
{	
	Connection con = null;
	
	public EmployeeRepository()
	{
		String url = "jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "0143";  
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public List<Employee> getEmployees()
	{
		List<Employee> employees = new ArrayList<>();
		String sql = "Select * from employee";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Employee e1 = new Employee();
				e1.setEmployee_id(rs.getInt(1));
				e1.setName(rs.getString(2));
				
				employees.add(e1);
			}
		} 
		catch(Exception e)
		{
			System.out.println(e);
		}
		return employees;
	}
	
	public Employee getEmployee(int Employee_id)
	{
		String sql = "Select * from employee where id="+Employee_id;
		Employee e1 = new Employee();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				e1.setEmployee_id(rs.getInt(1));
				e1.setName(rs.getString(2));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return e1;
	}

	public void create(Employee e1 ) 
	{
		String sql = "insert into employee values (?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, e1.getEmployee_id());
			st.setString(2, e1.getName());
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void update(Employee e1) 
	{
		String sql = "update employee name = ? where id = ?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(2, e1.getEmployee_id());
			st.setString(1, e1.getName());
			st.executeUpdate(); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
 
	public void delete(int id)
	{
		String sql = "delete from employee where id = ?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,id);
			st.executeUpdate(); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
