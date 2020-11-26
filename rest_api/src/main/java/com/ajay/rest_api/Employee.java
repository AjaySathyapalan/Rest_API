package com.ajay.rest_api;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee
{
	private int employee_id;
	private String name;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", name=" + name + "]";
	}
	
	 
}
   