package com.restapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.restapi.dao.EmployeeDao;
import com.restapi.dao.EmployeeDaoImpl;

@Path("/demo")
public class Service {

	@GET
	@Path("/test/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponse(@PathParam("name") String name){
		
		String output = "Testing " + name;
		System.out.println("Test");
		return Response.status(200).entity(output).build();
		
	}
	
	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees(){
		
		EmployeeDao dao = new EmployeeDaoImpl();
		List<Employee> employees = dao.getEmployees();
		
		return employees;
	}
	
	@GET
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeebyId(@PathParam("id") int id){
		
		EmployeeDao dao = new EmployeeDaoImpl();
		Employee employee = dao.getEmployeebyId(id);
		
		return employee;
	}
	
	@POST
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addEmployee(Employee employee){
		
		EmployeeDao dao = new EmployeeDaoImpl();
		dao.addEmployee(employee);
		
	}
	
	@PUT
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateEmployee(Employee employee){
		
		EmployeeDao dao = new EmployeeDaoImpl();
		dao.updateEmployee(employee);
	}
	
	@DELETE
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEmployee(@PathParam("id") int id){
		
		EmployeeDao dao = new EmployeeDaoImpl();
		dao.deleteEmployee(id);
	}
}
