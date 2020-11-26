package com.ajay.rest_api;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;

@Path("employees")
public class EmployeeResource
{
	EmployeeRepository repo = new EmployeeRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> getEmployees()
	{
		System.out.println ("getEmployee() is Called......");
		
		return repo.getEmployees();
	}
	
	@GET
	@Path("employee/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployee(@PathParam("id") int id)
	{
		return repo.getEmployee(id);
	}
	
	@POST
	@Path("employee")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Employee CreateEmployee(Employee e1)
	{
		System.out.println(e1);
		repo.create(e1);
		return e1;
	}
	
	@PUT
	@Path("employee")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Employee updateEmployee(Employee e1)
	{
		System.out.println(e1);
		if(repo.getEmployee(e1.getEmployee_id()).getEmployee_id()==0)
		{
			repo.create(e1);
		} 
		else
		{
			repo.update(e1);
		} 
		return e1;
	}
	 
	@DELETE
	@Path("alien/{id}")
	public Employee deleteEmployee(@PathParam("id") int id)
	{
		Employee e1 = repo.getEmployee(id);
		if(e1.getEmployee_id()!=0)
		{
			repo.delete(id);
		}
		return e1;
	}
	
}
