package com.deloitte.demo.resource;

import com.deloitte.demo.model.Department;
import com.deloitte.demo.service.DepartmentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/departments")
public class DepartmentResource {

    private DepartmentService departmentService = new DepartmentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Department getDepartmentById(@PathParam("id") int id) {
        return departmentService.getDepartmentById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Department addDepartment(Department department) {
        return departmentService.addDepartment(department);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Department updateDepartment(@PathParam("id") int id, Department updatedDepartment) {
        return departmentService.updateDepartment(id, updatedDepartment);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteDepartment(@PathParam("id") int id) {
        return departmentService.deleteDepartment(id);
    }
}
