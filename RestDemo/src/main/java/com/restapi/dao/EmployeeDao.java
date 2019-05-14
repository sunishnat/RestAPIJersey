package com.restapi.dao;

import java.util.List;

import com.restapi.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeebyId(int id);
	public void addEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int id);

}
