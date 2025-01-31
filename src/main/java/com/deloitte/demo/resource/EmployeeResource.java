package com.deloitte.demo.resource;

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

import com.deloitte.demo.model.Employee;
import com.deloitte.demo.service.EmployeeService;

@Path("/employees")
public class EmployeeResource {

	private EmployeeService empService = new EmployeeService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(@PathParam("id") int id) {
	    return empService.getEmployeeById(id); 
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee addEmployee(Employee employee) {
		return empService.addEmployee(employee);
	}
	
	@DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteEmployee(@PathParam("id") int id) {
        return empService.deleteEmployee(id);
    }
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(@PathParam("id") int id, Employee updatedEmployee) {
	    return empService.updateEmployee(id, updatedEmployee);
	}
	
	
//	implement these methods - 
//	getEmployeeById
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	addEmployee
//	updateEmployee 
//	deleteEmployee 

}